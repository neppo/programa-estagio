package com.neppo.estagio.data;

import com.neppo.estagio.data.model.User;
import com.neppo.estagio.data.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {
            // save a couple of users
            repository.save(new User("zezinho", "123456", "Zezinho", "Silva"));
            repository.save(new User("maria", "654321", "Maria", "Dolores"));
            repository.save(new User("joao", "567890", "Joao", "Batista"));

            // fetch all users
            System.out.println("Users found with findAll():");
            System.out.println("-------------------------------");
            for (User user : repository.findAll()) {
                System.out.println(user.toString());
            }

            // fetch an individual user by ID
            User user = repository.findOne(1L);
            System.out.println("User found with findOne(1L):");
            System.out.println("--------------------------------");
            System.out.println(user.toString());

            // fetch users by name
            System.out.println("User found with findByName('Zezinho'):");
            System.out.println("--------------------------------------------");
            for (User zezinho : repository.findByName("Zezinho")) {
                System.out.println(zezinho.toString());
            }
        };
    }

}