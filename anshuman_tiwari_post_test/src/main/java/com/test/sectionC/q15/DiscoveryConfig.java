package com.test.sectionC.q15;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/*
 * Q15 - Service Discovery
 *
 * WHAT: Service Discovery lets services find each other by logical name at runtime
 *       through a registry (e.g. Eureka), instead of using fixed IP:port values.
 *
 * WHY (not hardcoding IPs): in the cloud, instances start/stop and scale, and IPs
 *       change constantly. Hardcoding breaks on every change and can't load-balance
 *       across multiple instances. Discovery always resolves to a live instance.
 *
 * TOOL USED IN CLASS: Netflix Eureka.
 *
 * The @LoadBalanced RestTemplate below lets you call "http://product-service/..."
 * using the service NAME; the load balancer resolves it to a real instance via Eureka.
 */
@Configuration
public class DiscoveryConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
