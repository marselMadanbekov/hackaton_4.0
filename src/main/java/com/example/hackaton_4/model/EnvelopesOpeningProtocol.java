package com.example.hackaton_4.model;

import lombok.Data;

import java.util.List;

@Data
public class EnvelopesOpeningProtocol {
    private String id;
    private Long user_id;
    private Boolean confirmed;
    private Attachment attachment;
    private List<Commission> commission;
    private String reg_number;

}
