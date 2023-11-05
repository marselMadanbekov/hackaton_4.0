package com.example.hackaton_4.controllers;


import com.example.hackaton_4.configurations.CustomConfig;
import com.example.hackaton_4.model.Organization;
import com.example.hackaton_4.model.OrganizationsResponse;
import com.example.hackaton_4.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MainController {
    private final OrganizationService organizationService;

    @Autowired
    public MainController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping()
    public String getOrganizations(@RequestParam(defaultValue = CustomConfig.ip_address + "/api/organizations") String url,
                                   Model model) {
        OrganizationsResponse organizationsResponse = organizationService.getOrganizationsByUrl(url);
        model.addAttribute("organizations", organizationsResponse);
        return "redirect:/organizations";
    }
}
