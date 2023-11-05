package com.example.hackaton_4.model;

import lombok.Data;

import java.util.List;

@Data
public class PurchaseDetails {
    private Long id;
    private String name;
    private String registration_number;
    private String additional_contact_info;
    private String starting_price;
    private String currency_title;
    private String purchase_start_datetime;
    private String purchase_end_datetime;
    private Long proposal_validity_days;
    private Double fee_amount;
    private Status status;
    private Organization organization;
    private SupplierRequirement supplier_requirements;
    private Edm edms;
    private List<Lot> deliverables;
    private Product product;
    private ContractDraftAttachment contract_draft_attachment;
    private List<ContractDraftAttachment> notice_supplementary_attachments;

    private List<Proposal> proposals;
    private EnvelopesOpeningProtocol envelopes_opening_protocol;
}
