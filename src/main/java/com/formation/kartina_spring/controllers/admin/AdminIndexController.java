package com.formation.kartina_spring.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminIndexController {
    
    @GetMapping("admin")
    public String index(){
        return "admin/index" ;
    }
}

    

