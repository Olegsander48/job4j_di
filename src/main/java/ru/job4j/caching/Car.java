package ru.job4j.caching;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class Car {
    @Value("Mercedes G63")
    private String model;

    @Value("2018")
    private String year;

    public Car() {
    }

    @Cacheable("model")
    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }
}
