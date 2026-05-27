package com.test.sectionC.q13;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/*
 * Q13 - Circuit Breaker
 *
 * WHAT: A Circuit Breaker is a resilience pattern that monitors calls to a remote
 *       service. When failures cross a threshold it "opens" and short-circuits
 *       further calls (failing fast / running a fallback) instead of waiting on a
 *       service that is down. After a wait it half-opens to test recovery.
 *
 * WHY NEEDED: It stops one slow/failing downstream service from blocking threads
 *       and cascading the failure across the whole system, and gives users a
 *       graceful fallback while the dependency recovers.
 */
@Service
public class PaymentService {

    private final RestTemplate restTemplate = new RestTemplate();

    @CircuitBreaker(name = "paymentService", fallbackMethod = "paymentFallback")
    public PaymentResponse callPaymentService() {
        // Real call to the external payment-service.
        return restTemplate.getForObject(
                "http://payment-service/api/payments/process",
                PaymentResponse.class);
    }

    // Fallback must have the same return type plus a Throwable parameter.
    public PaymentResponse paymentFallback(Throwable t) {
        return new PaymentResponse("FAILED",
                "Payment service unavailable, please try again later.");
    }
}
