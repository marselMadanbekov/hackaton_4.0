package com.example.hackaton_4.model;

import lombok.Data;

import java.util.List;

@Data
public class SupplierRequirement {
    private Boolean has_no_arrears;
    private Boolean is_reliable_supplier;
    private List<Requirement> additional_requirements;
}
