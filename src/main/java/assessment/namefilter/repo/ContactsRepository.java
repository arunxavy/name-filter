package assessment.namefilter.repo;

import assessment.namefilter.entity.Contacts;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactsRepository extends ListCrudRepository<Contacts,Integer> {

    @Cacheable(cacheNames = "all-names")
    List<Contacts> findAll();
}