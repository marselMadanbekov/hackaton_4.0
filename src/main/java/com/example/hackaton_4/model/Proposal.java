package com.example.hackaton_4.model;

import lombok.Data;

@Data
public class Proposal {
    private String id;
    private Long price;
    private Status status;
    private Supplier supplier;
    private String rejection_reason;
    private String created_at;
}
