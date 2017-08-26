package com.patrick.demo;

import com.patrick.demo.entity.PredictionEntity;
import com.patrick.demo.networks.JeffNetwork;
import com.patrick.demo.utils.ObjectFactory;
import org.aspectj.lang.annotation.After;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

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

    @Autowired
    private ObjectFactory factory;

    public static final Logger logger = LoggerFactory.getLogger(SpringBootWebApplication.class);



    public static void main(String[] args) {

        SpringApplication.run(SpringBootWebApplication.class, args);
    }

    @PostConstruct
    public void run(){

        logger.info("Starting use case....");


        // Step 1: Upload Data & pre-process

        // Step 2: Configure network

        // Step 3: Begin learning

        // Step 4: Review results and fine tune network

        // Step 5: Query and generate endpoint

    }
}
