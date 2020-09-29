package com.formation.kartina_spring.controllers.admin;

import com.formation.kartina_spring.models.Facture;
import com.formation.kartina_spring.services.FactureService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/factures")
public class AdminFactureController {


    private final FactureService factureService;

    @Autowired
    public AdminFactureController(FactureService factureService) {
        this.factureService = factureService;
    }

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("factures", factureService.findAll());
        model.addAttribute("fragment", "facture/index");
        return "admin/index";
    }

    @GetMapping("add")
    public String getCreateArticle(Model model, Facture facture){
        model.addAttribute("action", "/add");
        model.addAttribute("fragment", "facture/form");
        return "admin/index";
    }
    
}
