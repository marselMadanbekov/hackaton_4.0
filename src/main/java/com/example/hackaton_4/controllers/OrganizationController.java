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
@RequestMapping("/organizations")
public class OrganizationController {
    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping()
    public String getOrganizations(@RequestParam(defaultValue = CustomConfig.ip_address + "/api/organizations") String url,
                                   Model model) {
        OrganizationsResponse organizationsResponse = organizationService.getOrganizationsByUrl(url);
        model.addAttribute("organizations", organizationsResponse);
        return "user/organizations";
    }

    @GetMapping("/by-filters")
    public String getOrganizationsByFilters(@RequestParam(required = false) String name,
                                            @RequestParam(required = false) String inn,
                                            @RequestParam(required = false) String okpo,
                                            @RequestParam(required = false) String registration_number,
                                            Model model) {
        OrganizationsResponse organizationsResponse = organizationService.getFilteredOrganizations(name, inn, okpo, registration_number);
        model.addAttribute("organizations", organizationsResponse);
        return "user/organizations";
    }

    @GetMapping("/organization-analytics")
    public String organizationAnalytics(@RequestParam Long organizationId,
                                        Model model){
        Organization organization = organizationService.getOrganizationById(organizationId);
        model.addAttribute("organization", organization);

        return "user/organization-analytics";
    }

    @GetMapping("/organization-details")
    public String organizationDetails(@RequestParam Long id,
                                      Model model) {
        Organization organization = organizationService.getOrganizationById(id);
        model.addAttribute("organization", organization);
        return "user/organization-details";
    }
}
