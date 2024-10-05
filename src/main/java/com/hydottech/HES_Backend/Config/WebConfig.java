package com.hydottech.HES_Backend.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Map URL path to the upload directory on the file system
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:src/main/resources/uploads");
    }
}
