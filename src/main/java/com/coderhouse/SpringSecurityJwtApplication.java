package com.coderhouse;

import com.coderhouse.model.User;
import com.coderhouse.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringSecurityJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(UserRepository repository) {
        return (args) -> {
            repository.save(User.builder().username("Jose").password("123456").build());
            repository.save(User.builder().username("Esteban").password("123").build());
            repository.save(User.builder().username("Juan").password("123").build());
            repository.save(User.builder().username("Matias").password("123").build());
            repository.save(User.builder().username("Nina").password("123").build());
            repository.save(User.builder().username("Camila").password("123").build());
        };
    }

}
