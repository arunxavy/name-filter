package assessment.namefilter.service;

import assessment.namefilter.dto.NameDto;
import assessment.namefilter.entity.Contacts;
import assessment.namefilter.repo.ContactsRepository;
import assessment.namefilter.service.NameStoreService;
import assessment.namefilter.service.PublishService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

@ExtendWith(MockitoExtension.class)
public class NameStoreServiceTest {

    @InjectMocks
    NameStoreService nameStoreService;
    @Mock
    ContactsRepository contactsRepository;

    @Mock
    PublishService publishService;

    @Mock
    CacheManager cacheManager;

    @Test
    public void testSave(){

        Contacts contacts = new Contacts();
        contacts.setId(1);
        contacts.setName("Test");
        Mockito.when(contactsRepository.save(Mockito.any())).thenReturn(contacts);
        Mockito.when(cacheManager.getCache(Mockito.any())).thenReturn(Mockito.mock(Cache.class));
        NameDto name = new NameDto();
        nameStoreService.save(name);
        Mockito.verify(publishService,Mockito.times(1)).publish(Mockito.any());
    }
}
