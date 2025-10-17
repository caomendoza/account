package com.cao.account.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ResourceServerConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .oauth2ResourceServer(o -> o.jwt(Customizer.withDefaults()))
                .authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.GET, "/api/accounts")
                        .hasAnyAuthority("read")
                        .anyRequest()
                        .authenticated());
        return http.build();
    }

    @Bean
    JwtDecoder jwtDecoder() {

        String jwkSetUri = "http://localhost:8080/.well-known/jwks.json";
        return NimbusJwtDecoder.withJwkSetUri(jwkSetUri).build();
    }
}
