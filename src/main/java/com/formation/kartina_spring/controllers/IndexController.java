package com.formation.kartina_spring.controllers;

import com.formation.kartina_spring.utils.RemplissageBDD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    private RemplissageBDD remplissageBDD;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("fragment", "index");
        return "index";
    }

    @GetMapping("/remplissage")
    public String remplissage(){
        remplissageBDD.saveDB();
        return "redirect:/";
    }
}
