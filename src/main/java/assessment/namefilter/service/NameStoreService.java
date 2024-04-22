package assessment.namefilter.service;

import assessment.namefilter.dto.ContactCreatedEvent;
import assessment.namefilter.dto.NameDto;
import assessment.namefilter.entity.Contacts;
import assessment.namefilter.repo.ContactsRepository;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class NameStoreService {
    private final ContactsRepository contactsRepository;
    private final PublishService publishService;
    private final CacheManager cacheManager;

    public NameStoreService(ContactsRepository contactsRepository, PublishService publishService, CacheManager cacheManager) {
        this.contactsRepository = contactsRepository;
        this.publishService = publishService;
        this.cacheManager = cacheManager;
    }

    public void save(NameDto name) {
        Contacts contacts = new Contacts();
        contacts.setName(name.getName());
        Contacts savedContact = contactsRepository.save(contacts);
        ContactCreatedEvent contactCreatedEvent = new ContactCreatedEvent(savedContact.getId(),savedContact.getName());
        publishService.publish(contactCreatedEvent);
        Objects.requireNonNull(cacheManager.getCache("filter")).clear();
        Objects.requireNonNull(cacheManager.getCache("all-names")).clear();
    }

    public List<Contacts> fetchAll() {
        return contactsRepository.findAll();
    }

    @Cacheable(cacheNames = "filter")
    public List<String> filter(String nameFilter) {
        Pattern pattern = Pattern.compile(nameFilter);
        return contactsRepository.findAll().stream().map(Contacts::getName)
                .filter(pattern.asPredicate().negate())
                .collect(Collectors.toList());

    }
}
