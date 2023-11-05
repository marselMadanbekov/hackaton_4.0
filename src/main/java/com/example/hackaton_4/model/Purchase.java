package com.example.hackaton_4.model;

import lombok.Data;

@Data
public class Purchase {
    private Long id;
    private String product;
    private String name;
    private String registration_number;
    private String additional_contact_info;
    private String starting_price;
    private String currency_title;
    private String purchase_start_datetime;
    private String purchase_end_datetime;
    private String category;
    private Integer proposal_validity_days;
    private Double fee_amount;
    private String status;
    private String organization;
}
