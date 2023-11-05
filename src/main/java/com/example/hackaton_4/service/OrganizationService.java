package com.example.hackaton_4.service;

import com.example.hackaton_4.configurations.CustomConfig;
import com.example.hackaton_4.model.Organization;
import com.example.hackaton_4.model.OrganizationsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrganizationService {
    private final RestTemplate restTemplate;


    @Autowired
    public OrganizationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public OrganizationsResponse getOrganizationsByUrl(String url){
        ResponseEntity<OrganizationsResponse> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                OrganizationsResponse.class
        );
        return response.getBody();
    }

    public Organization getOrganizationById(Long id) {
        String url = CustomConfig.ip_address + "/api/organizations/get?organization=" + id;
        ResponseEntity<Organization> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                Organization.class
        );
        return response.getBody();
    }

    public OrganizationsResponse getFilteredOrganizations(String name, String inn, String okpo, String registration_number) {
        String url = CustomConfig.ip_address + "/api/organizations/search?";

        if(name != null)
            url += "name=" + name + "&";
        if(inn != null)
            url += "inn=" + inn + "&";
        if(okpo != null)
            url += "okpo=" + okpo + "&";
        if(registration_number != null)
            url += "registration_number=" + registration_number + "&";


        ResponseEntity<OrganizationsResponse> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                OrganizationsResponse.class
        );
        return response.getBody();
    }
}
