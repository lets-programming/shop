package com.letsprogramming.shop.config;

import com.letsprogramming.shop.auth.MemberRoles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigure {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(requests -> requests
                .requestMatchers("/", "/getProducts").permitAll()
                .requestMatchers("/saveReview").hasRole(MemberRoles.USER)
                .requestMatchers(HttpMethod.POST).hasRole(MemberRoles.USER)
                .requestMatchers(HttpMethod.DELETE).hasRole(MemberRoles.USER)
                .anyRequest().anonymous()
        ).build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
