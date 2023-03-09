package ex.proj.skyline.saitonproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Vladislav Domaniewski
 */

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Настройка аутентификации
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(); //
    }
}
