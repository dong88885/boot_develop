package com.boot.develop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class BootDevelopApplication {
	
	public static void main(String[] args) {
		
        SpringApplication.run(BootDevelopApplication.class, args);
    }

}
