package assessment.namefilter.service;

import assessment.namefilter.dto.ContactCreatedEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.cloud.stream.function.StreamBridge;

@ExtendWith(MockitoExtension.class)
public class PublishServiceTest {

    @InjectMocks
    PublishService publishService;

    @Mock
    StreamBridge streamBridge;

    @Test
    public void testPublish(){
        publishService.publish(new ContactCreatedEvent(1,"Adam"));
        Mockito.verify(streamBridge,Mockito.times(1)).send(Mockito.eq("contact-channel"),Mockito.any());
    }
}
