package com.example.hackaton_4.service;

import com.example.hackaton_4.configurations.CustomConfig;
import com.example.hackaton_4.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CategoriesService {
    private final RestTemplate restTemplate;

    @Autowired
    public CategoriesService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Category> getAllCategories(){
        String url = CustomConfig.ip_address + "/api/categories";
        ResponseEntity<Category[]> response = restTemplate.getForEntity(url, Category[].class);
        Category[] categories = response.getBody();
        if (categories != null) {
            return Arrays.asList(categories);
        }
        return Collections.emptyList();
    }
}
