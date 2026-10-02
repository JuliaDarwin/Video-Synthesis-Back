package com.videosynthesis.tfmBack.config;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Value("${cloudinary.url}")
    private String cloudinaryUrl;

    @Bean
    public Cloudinary cloudinary() {
        // If the URL is just a placeholder, return a mock/empty instance to prevent crashing on startup before configured
        if (cloudinaryUrl == null || cloudinaryUrl.contains("your_cloudinary_url_here")) {
            return new Cloudinary();
        }
        return new Cloudinary(cloudinaryUrl);
    }
}
