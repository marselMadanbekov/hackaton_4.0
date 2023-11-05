package com.example.hackaton_4.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc

public class CustomConfig implements WebMvcConfigurer {

    public static final String ip_address = "http://192.168.43.33:8082";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry){
        resourceHandlerRegistry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
