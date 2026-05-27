package com.test.sectionC.q12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/*
 * Q12 - Register "product-service" with Eureka.
 *
 * MAIN CLASS ANNOTATION: @EnableDiscoveryClient (works with any discovery server;
 * @EnableEurekaClient is the Eureka-specific equivalent). Combined with the
 * spring-cloud-starter-netflix-eureka-client dependency and the application.yml
 * below, the service registers itself with the Eureka server on startup.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }
}
