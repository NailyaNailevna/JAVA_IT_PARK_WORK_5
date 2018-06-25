package ru.itpark.milkyKitchen.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by nailya.shakirova on 19.06.2018.
 */

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
@ComponentScan("ru.itpark.milkyKitchen")
@EntityScan(basePackages = "ru.itpark.milkyKitchen.models")
@EnableJpaRepositories(basePackages = "ru.itpark.milkyKitchen.repositories")

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
