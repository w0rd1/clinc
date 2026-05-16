package com.example.demo.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}

/*    @Bean
    public UserDetailsService checkUser(PatientRepo repo){
        return username -> {
            Patient search_result = repo.findByUsername(username);
            if(search_result  != null) {return search_result;}
            throw new UsernameNotFoundException("User '" + username + "' not found");
        };
    }*/

    @Bean
    public SecurityFilterChain FilterChain(HttpSecurity http) throws Exception{
        return http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/","/**").permitAll()
                )
                .csrf(csrf-> csrf.disable())
                .build();
    }

}
