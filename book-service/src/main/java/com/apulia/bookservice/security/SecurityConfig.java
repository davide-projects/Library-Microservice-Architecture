package com.apulia.bookservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())          // Disabilita CSRF (necessario per API REST)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()       // Tutte le rotte sono pubbliche
                )
                .cors(cors -> {});                     // Abilita CORS (necessario per frontend)

        return http.build();
    }
}
