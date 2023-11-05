package com.example.hackaton_4.model;

import lombok.Data;

@Data
public class Lot {
    private Long id;
    private String name;
    private Okei okei;
    private Long quantity;
    private Long price_per_unit;
    private String characteristics;
}
