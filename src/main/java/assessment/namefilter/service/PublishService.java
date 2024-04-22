package assessment.namefilter.service;

import assessment.namefilter.dto.ContactCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PublishService {

    private final StreamBridge streamBridge;

    public PublishService(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public void publish(ContactCreatedEvent contactCreatedEvent) {
      log.info("publishing {}",contactCreatedEvent);
        streamBridge.send("contact-channel", contactCreatedEvent);
    }
}
