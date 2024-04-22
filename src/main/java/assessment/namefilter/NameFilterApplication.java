package assessment.namefilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.integration.config.EnableIntegration;

@SpringBootApplication
@EnableCaching
@EnableIntegration
public class NameFilterApplication {

	public static void main(String[] args) {
		SpringApplication.run(NameFilterApplication.class, args);
	}

}
