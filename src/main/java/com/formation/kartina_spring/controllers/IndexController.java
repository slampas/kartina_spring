package com.formation.kartina_spring.controllers;

import com.formation.kartina_spring.utils.RemplissageBDD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    //Index, page principale

    @Autowired
    private RemplissageBDD remplissageBDD;

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

    @GetMapping("/remplissage")
    public String remplissage(){
        remplissageBDD.saveDB();
        return "redirect:/";
    }
}
