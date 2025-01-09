package com.bnt.BloodBank.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Apply to all endpoints
                .allowedOrigins("http://127.0.0.1:5500", "http://localhost:5500") // Allow both '127.0.0.1' and 'localhost'
                .allowedMethods("GET", "POST", "PUT", "DELETE","PATCH", "OPTIONS") // Allowed HTTP methods
                .allowedHeaders("*") // Allow all headers
                .allowCredentials(false); // Set to false unless you need to send credentials (cookies, etc.)
    }

}