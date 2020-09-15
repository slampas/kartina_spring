package com.formation.kartina_spring;

import com.formation.kartina_spring.services.ArticleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({
        @PropertySource(value = "classpath:application.properties"),
        @PropertySource(value = "classpath:datasource.properties", ignoreResourceNotFound = true)
})
public class KartinaSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(KartinaSpringApplication.class, args);
    }
}
