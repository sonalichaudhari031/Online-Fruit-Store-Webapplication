package com.example.online.fruit.store.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Bahar ke folder 'uploads' ko URL path '/uploads/' se jodne ke liye
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:uploads/");
    }
}