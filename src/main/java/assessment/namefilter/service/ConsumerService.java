package assessment.namefilter.service;

import assessment.namefilter.dto.ContactCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
@Slf4j
public class ConsumerService {

    @Bean
    Consumer<ContactCreatedEvent> contact() {
        return event -> log.info("Event received : {}", event);
    }
}
