package com.formation.kartina_spring.controllers;

import com.formation.kartina_spring.models.ChoixPersonnalisation;
import com.formation.kartina_spring.services.FormatService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

    private FormatService formatService;

    //Objet pour sauvegarde temporaire des choix
    private ChoixPersonnalisation choixPersonnalisation;

    @Autowired
    public IndexController(FormatService formatService, ChoixPersonnalisation choixPersonnalisation) {
        this.formatService = formatService;
        this.choixPersonnalisation = choixPersonnalisation;
    }


    //Index, page principale
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("fragment", "index");
        return "index";
    }

    //Page parcours des photographies
    @GetMapping("/explore")
    public String getPhotographies(Model model) {
        model.addAttribute("fragment", "parcours_photo");
        return "index";
    }

    //Page artiste
    @GetMapping("/artist")
    public String getArtiste(Model model) {
        model.addAttribute("fragment", "artiste");
        return "index";
    }


    //Page parcours achat
    @GetMapping("/oeuvre/{ref}")
    public String getOeuvre(
            Model model,
            @PathVariable Long ref
    ) {
        model.addAttribute("fragmentForm", "fragments :: format");
        model.addAttribute("fragment", "parcours_achat");
        return "index";
    }

    @PostMapping("/oeuvre/{ref}/finition")
    public String postOeuvreFinition(
            Model model,
            @PathVariable Long ref,
            @RequestParam(name = "format") String format
    ) {
        choixPersonnalisation.setFormat(format);
        System.out.println("obj = " + choixPersonnalisation.toString());
        model.addAttribute("fragmentForm", "fragments :: finition");
        model.addAttribute("fragment", "parcours_achat");
        return "index";
    }

    @PostMapping("/oeuvre/{ref}/cadre")
    public String postOeuvreCadre(
            Model model,
            @PathVariable Long ref,
            @RequestParam(name = "finition") String finition
    ) {
        choixPersonnalisation.setFinition(finition);
        System.out.println("obj = " + choixPersonnalisation.toString());
        model.addAttribute("fragmentForm", "fragments :: cadre");
        model.addAttribute("fragment", "parcours_achat");
        return "index";
    }

    @PostMapping("/oeuvre/{ref}")
    public String postOeuvre(
            @RequestParam(name = "cadre") String cadre
    ) {
        choixPersonnalisation.setCadre(cadre);
        System.out.println("obj = " + choixPersonnalisation.toString());

        return "redirect:/oeuvre/{ref}";
    }
}
