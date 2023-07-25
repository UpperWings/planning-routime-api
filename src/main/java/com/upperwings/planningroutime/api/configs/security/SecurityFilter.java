package com.upperwings.planningroutime.api.configs.security;

import com.upperwings.planningroutime.api.repositories.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var tokenJWT = getAuthToken(request);
        if (tokenJWT != null){
            System.out.println("LocalDateTime.now() DATAAAAAAAAAA");
            System.out.println(LocalDateTime.now());
            var subject = tokenService.getSubject(tokenJWT);
            var user = userRepository.findByUsername(subject);

            var auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
        }


        //throw new RuntimeException("Authentication token cannot be null");

        filterChain.doFilter(request, response);
    }

    private String getAuthToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");

        if (authHeader != null){
            return authHeader.replace("Bearer ", "");
        }

        return null;
    }
}
