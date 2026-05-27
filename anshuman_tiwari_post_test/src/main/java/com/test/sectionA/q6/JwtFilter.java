package com.test.sectionA.q6;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/*
 * (a) WHAT THIS FILTER DOES (2 lines):
 *     It runs once per request, reads the "Authorization: Bearer <token>" header,
 *     extracts the username from the JWT and, if valid, places an Authentication
 *     object in the SecurityContext so the request is treated as authenticated.
 *
 * (b) BUG:  String token = header.substring(6);
 *     "Bearer " is 7 characters (B-e-a-r-e-r + a space), so substring(6) keeps the
 *     leading space and produces " <token>", which is always invalid.
 *     CORRECTED LINE:  String token = header.substring(7);
 */
@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res,
                                    FilterChain chain) throws ServletException, IOException {

        String header = req.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            chain.doFilter(req, res);
            return;
        }

        String token = header.substring(7); // CORRECTED: was substring(6)
        String username = jwtUtil.extractUsername(token);
        if (username != null) {
            UsernamePasswordAuthenticationToken auth =
                    new UsernamePasswordAuthenticationToken(username, null, null);
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        chain.doFilter(req, res);
    }
}
