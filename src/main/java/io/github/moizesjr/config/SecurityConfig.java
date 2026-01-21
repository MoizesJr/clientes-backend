package io.github.moizesjr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Importante: Sem isso o POST no Postman não funciona
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic(); // Permite a autenticação que você configurou no Postman
    }
}