package com.example.vijuserver.security;

import com.example.vijuserver.security.jwt.JwtAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Entrypoint que tiene la aplicación y cuales de ellas necesita una autorización o no
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final AuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final PasswordEncoder passwordEncoder;
    private final JwtAuthorizationFilter jwtAuthorizationFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf()
                    .disable()
                .exceptionHandling()
                    .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                    .antMatchers(HttpMethod.POST, "/user").permitAll()
                    .antMatchers(HttpMethod.POST, "/auth/login").permitAll()
                    .antMatchers(HttpMethod.GET, "/user").permitAll()
                    .antMatchers(HttpMethod.GET, "/user/*").permitAll()
                    .antMatchers(HttpMethod.DELETE, "/user/*").hasRole("ADMIN")
                    .antMatchers(HttpMethod.GET, "/user/stats/*").permitAll()
                    .antMatchers(HttpMethod.GET, "/videogames").permitAll()
                    .antMatchers(HttpMethod.POST, "/videogame").hasRole("ADMIN")
                    .antMatchers(HttpMethod.PUT, "/videogame/*").hasRole("ADMIN")
                    .antMatchers(HttpMethod.DELETE, "/videogame/*").hasRole("ADMIN")
                    .antMatchers(HttpMethod.GET, "/reviews").permitAll()
                    .antMatchers(HttpMethod.GET, "/reviews/*").permitAll()
                    .antMatchers(HttpMethod.GET, "/reviewsDate").permitAll()
                    .antMatchers(HttpMethod.GET, "/reviewsDate/*").permitAll()
                    .antMatchers(HttpMethod.GET, "/review/*").permitAll()
                    .antMatchers(HttpMethod.OPTIONS).permitAll()
                    .anyRequest().authenticated();

        http.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
