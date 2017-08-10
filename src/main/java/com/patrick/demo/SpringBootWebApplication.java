package com.patrick.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author patrick
 * 
 * NB. Be sure to set JDBC url to 'jdbc:h2:mem:testdb'
 * 
 * Taken from tutorial at: https://springframework.guru/spring-boot-web-application-part-1-spring-initializr/
 * 
 *
 */
@SpringBootApplication
public class SpringBootWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }
}
