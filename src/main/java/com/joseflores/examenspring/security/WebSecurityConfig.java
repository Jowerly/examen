package com.joseflores.examenspring.security;

import org.apache.tomcat.util.net.DispatchType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
   

    @SuppressWarnings("deprecation")
    @Bean
        SecurityFilterChain defaultSecurityFilterChainProtected(HttpSecurity http) throws Exception{
        http
        .securityContext(context -> context
.requireExplicitSave(false))
.cors((cors) -> cors.disable())
.csrf((csrf) -> csrf.disable())
.exceptionHandling(exception -> exception.accessDeniedPage("/"))
.authorizeHttpRequests(authorize -> authorize
.dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.ERROR).permitAll()
.requestMatchers(HttpMethod.GET, "/").permitAll()
.requestMatchers
(HttpMethod.POST, "/register").permitAll()
.requestMatchers(
  HttpMethod.POST, "/login").permitAll()
.requestMatchers(
  HttpMethod.GET, "/programas")
.hasRole("USUARIO")
.anyRequest()
.authenticated()
)
.formLogin(login -> login
.usernameParameter("username")
.loginPage("/")
.defaultSuccessUrl("/programas",true))
.logout(logout -> logout
.invalidateHttpSession(true)
.logoutUrl("/logout")
.logoutSuccessUrl("/")
.clearAuthentication(true)
.invalidateHttpSession(true)
.deleteCookies("JSESSIONID"))
.sessionManagement(session -> session
.maximumSessions(1)
.expiredUrl("/login"));
;
    return http.build();
}
    }
