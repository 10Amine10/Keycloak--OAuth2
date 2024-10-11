package com.codewithAmine.OAuth2_keycloak.config;




import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.RedirectServerAuthenticationSuccessHandler;
import org.springframework.security.web.server.authentication.logout.RedirectServerLogoutSuccessHandler;
import java.net.URI;


@Configuration
@EnableWebFluxSecurity
public class SecurityConfig  {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeExchange(exchange -> exchange
                        .pathMatchers("/users").permitAll()
                        .anyExchange().authenticated()
                )
                .oauth2Login(oauth2 -> oauth2
                        .authenticationSuccessHandler(redirectHandler())
                )
                .logout(logout -> logout
                        .logoutSuccessHandler(logoutSuccessHandler())
                );
        return http.build();
    }

    @Bean
    public RedirectServerAuthenticationSuccessHandler redirectHandler() {
        return new RedirectServerAuthenticationSuccessHandler();
    }

    @Bean
    public RedirectServerLogoutSuccessHandler logoutSuccessHandler() {
        RedirectServerLogoutSuccessHandler handler = new RedirectServerLogoutSuccessHandler();
        handler.setLogoutSuccessUrl(URI.create("/"));
        return handler;
    }




}
