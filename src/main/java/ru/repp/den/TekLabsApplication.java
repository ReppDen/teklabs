package ru.repp.den;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import ru.repp.den.constants.FizzBuzzConstansProvider;
import ru.repp.den.service.FizzBuzzService;
import ru.repp.den.service.FizzBuzzServiceImpl;

@SpringBootApplication
public class TekLabsApplication {

    @Bean
    public FizzBuzzService fizzBuzzService() {
        return new FizzBuzzServiceImpl(new FizzBuzzConstansProvider());
    }

    public static void main(String[] args) {
        SpringApplication.run(TekLabsApplication.class);
    }
}
