package com.example.hackaton_4.service;

import com.example.hackaton_4.configurations.CustomConfig;
import com.example.hackaton_4.model.OrganizationsResponse;
import com.example.hackaton_4.model.PurchaseDetails;
import com.example.hackaton_4.model.PurchasesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PurchasesService {
    private final RestTemplate restTemplate;

    @Autowired
    public PurchasesService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public PurchasesResponse getPurchasesByUrl(String url){
        ResponseEntity<PurchasesResponse> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                PurchasesResponse.class
        );
        return response.getBody();
    }

    public PurchasesResponse getPurchasesByFilters(Long categoryId) {
        String url = CustomConfig.ip_address + "/api/purchases?categoryId=" + categoryId;
        ResponseEntity<PurchasesResponse> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                PurchasesResponse.class
        );
        return response.getBody();
    }

    public PurchaseDetails purchaseDetailsById(Long id){
        String url = CustomConfig.ip_address + "/api/purchases/" +id;
        ResponseEntity<PurchaseDetails> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                PurchaseDetails.class
        );
        return response.getBody();
    }
}
