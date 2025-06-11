package ru.job4j.annotation;

import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;

@Configuration
@ComponentScan(basePackages = "ru.job4j.annotation")
@PropertySource("classpath:application.properties")
public class Config {
    @Bean
    @Primary
    @Order(11)
    public Dog getAlfaDog() {
        return new Dog("AlfaDog");
    }

    @Order(3)
    @Bean(name = "secondDog")
    public Dog getDog() {
        return new Dog("SecondDog");
    }

    @Order(5)
    @Bean
    public Dog someDog() {
        return new Dog("Dog");
    }
}
