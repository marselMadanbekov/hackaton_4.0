package com.example.hackaton_4.controllers;

import com.example.hackaton_4.configurations.CustomConfig;
import com.example.hackaton_4.model.Category;
import com.example.hackaton_4.model.PurchaseDetails;
import com.example.hackaton_4.model.PurchasesResponse;
import com.example.hackaton_4.service.CategoriesService;
import com.example.hackaton_4.service.PurchasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/purchases")
public class PurchasesController {
    private final PurchasesService purchasesService;

    private final CategoriesService categoriesService;
    @Autowired
    public PurchasesController(PurchasesService purchasesService, CategoriesService categoriesService) {
        this.purchasesService = purchasesService;
        this.categoriesService = categoriesService;
    }

    @GetMapping("")
    public String purchases(@RequestParam(defaultValue = CustomConfig.ip_address + "/api/purchases") String url,
                            Model model){
        PurchasesResponse purchasesResponse = purchasesService.getPurchasesByUrl(url);
        List<Category> categories = categoriesService.getAllCategories();

        model.addAttribute("categories", categories);
        model.addAttribute("purchases", purchasesResponse);
        return "user/purchases";
    }

    @GetMapping("/purchase-details")
    public String purchaseDetails(@RequestParam Long purchaseId,
                                  Model model){
        PurchaseDetails purchaseDetails = purchasesService.purchaseDetailsById(purchaseId);

        model.addAttribute("purchase", purchaseDetails);
        return "user/purchase-details";
    }

    @GetMapping("/by-filters")
    public String purchasesByFilters(@RequestParam(required = false) Long categoryId,
                                     Model model){
        PurchasesResponse purchasesResponse = purchasesService.getPurchasesByFilters(categoryId);
        List<Category> categories = categoriesService.getAllCategories();
        model.addAttribute("purchases", purchasesResponse);
        model.addAttribute("categories", categories);
        return "user/purchases";
    }
}
