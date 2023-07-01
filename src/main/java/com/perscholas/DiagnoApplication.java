package com.perscholas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.perscholas.persistence.repo")
@EntityScan("com.perscholas.persistence.model")
@SpringBootApplication
public class DiagnoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiagnoApplication.class, args);
    }

}
