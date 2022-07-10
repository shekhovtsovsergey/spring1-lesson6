package ru.gb.spring1lesson6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.gb.spring1lesson6.config.ProductProps;

@EnableConfigurationProperties(ProductProps.class)
@SpringBootApplication
public class Spring1Lesson6Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring1Lesson6Application.class, args);
    }

}
