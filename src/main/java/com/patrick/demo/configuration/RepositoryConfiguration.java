package com.patrick.demo.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @author patrick
 * 
 * @Configuration  tells the Spring Framework this is a Java configuration class.
 * @EnableAutoConfiguration tells Spring Boot to do its auto configuration magic. This is what has Spring Boot automatically create the Spring Beans with sensible defaults for our tests.
 * @EntityScan specifies the packages to look for JPA Entities.
 * @EnableJpaRepositories enables the auto configuration of Spring Data JPA.
 * @EnableTransactionManagement Enables Spring’s annotation driven transaction management
 *
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.patrick.demo.db"})
@EnableJpaRepositories(basePackages = {"com.patrick.demo.db"})
@EnableTransactionManagement
public class RepositoryConfiguration {
	
}
