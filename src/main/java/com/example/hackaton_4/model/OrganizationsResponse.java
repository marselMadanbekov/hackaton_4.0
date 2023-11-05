package com.example.hackaton_4.model;

import lombok.Data;

import java.util.List;

@Data
public class OrganizationsResponse {
    private Integer current_page;
    private List<Organization> data;
    private List<Link> links;
    private String last_page_url;

}
