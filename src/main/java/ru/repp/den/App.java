package ru.repp.den;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.repp.den.constants.FizzBuzzConstansProvider;
import ru.repp.den.service.FizzBuzzService;
import ru.repp.den.service.FizzBuzzServiceImpl;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        //ololo

        SpringApplication.run(App.class, args);
    }

    @Bean
    public FizzBuzzService fizzBuzzService() {
        return new FizzBuzzServiceImpl(new FizzBuzzConstansProvider());
    }
}