package ru.job4j.caching;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(Config.class);
        Car car = context.getBean("car", Car.class);
        System.out.println(car.getModel());
    }
}
