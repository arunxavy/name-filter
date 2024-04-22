package assessment.namefilter.controller;

import assessment.namefilter.dto.NameDto;
import assessment.namefilter.entity.Contacts;
import assessment.namefilter.service.NameStoreService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
import java.util.Collections;
import java.util.List;

@RestController
@Slf4j
public class NameStoreController {

    private final NameStoreService nameStoreService;

    public NameStoreController(NameStoreService nameStoreService) {
        this.nameStoreService = nameStoreService;
    }

    @GetMapping("/hello/contacts")
    public List<String> filter(@RequestParam("nameFilter") String nameFilter){
        log.info("Name filter {}",nameFilter);
        return nameStoreService.filter(nameFilter);
    }

    @PostMapping("/create")
    public void create(@RequestBody @Valid NameDto name){
        nameStoreService.save(name);
    }

    @GetMapping("/fetch-all")
    public List<Contacts> fetachAll(){
        return nameStoreService.fetchAll();
    }
}
