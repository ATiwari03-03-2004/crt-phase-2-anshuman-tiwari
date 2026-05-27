package com.test.sectionA.q6;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    // Stub: in a real app this would parse the JWT and return the subject claim.
    public String extractUsername(String token) {
        // ... decode token and read the "sub" claim ...
        return token == null || token.isBlank() ? null : "user-from-token";
    }
}
