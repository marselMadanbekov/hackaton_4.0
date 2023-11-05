package com.example.hackaton_4.model;


import lombok.Data;

@Data
public class Organization {
    private Long id;
    private String name;
    private String inn;
    private String okpo;
    private String registration_number;
    private String registration_date;
    private String head;
    private String country_name;
    private String legal_address;
    private String postal_address;
    private String email;
    private String website;
    private String phone;
    private String contact_person_name;
}
