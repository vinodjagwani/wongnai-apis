package th.wongnai.fdelivery.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactivefeign.spring.config.EnableReactiveFeignClients;


@SpringBootApplication
@EnableReactiveFeignClients
public class Application {

    public static void main(final String... args) {
        SpringApplication.run(Application.class, args);
    }

}
