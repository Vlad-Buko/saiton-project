package ex.proj.skyline.saitonproject.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * Created by Vladislav Domaniewski
 */
//
//@Configuration
//@Log4j2
//public class SecurityConfiguration {
//
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .formLogin(withDefaults())
//                .oauth2Login(withDefaults())
//                .authorizeRequests(c -> c.anyRequest().authenticated())
//                .build();
//    }
//
//
//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//
//    @Bean
//    ApplicationListener<AuthenticationSuccessEvent> successLogger() {
//        return event -> {
//            log.info("success: {}", event.getAuthentication());
//        };
//    }
//}
