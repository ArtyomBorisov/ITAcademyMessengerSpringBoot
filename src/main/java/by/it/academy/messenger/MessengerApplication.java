package by.it.academy.messenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "by.it.academy.messenger.dao.api")
public class MessengerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MessengerApplication.class, args);
    }
}
