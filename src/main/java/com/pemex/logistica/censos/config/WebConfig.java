package com.pemex.logistica.censos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("*") // o "http://localhost:8080" si quieres restringir
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}