package com.formation.kartina_spring.controllers;

import com.formation.kartina_spring.models.Article;
import com.formation.kartina_spring.models.Artiste;
import com.formation.kartina_spring.models.ChoixPersonnalisation;
import com.formation.kartina_spring.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ParcoursAchatController {
    //Objet pour sauvegarde temporaire des choix
    private final ChoixPersonnalisation choixPersonnalisation;

    private ArticleService articleService;

    @Autowired
    public ParcoursAchatController(ChoixPersonnalisation choixPersonnalisation, ArticleService articleService) {
        this.choixPersonnalisation = choixPersonnalisation;
        this.articleService = articleService;
    }

    //Page parcours achat
    @GetMapping("/oeuvre/{ref}/format")
    public String getOeuvre(
            Model model,
            @PathVariable Long ref
    ) {
        //On recupere l'objet article
        Optional<Article> article = articleService.findById(ref);
        if (article.isPresent()) {
            //On recupere la liste des artistes associés à l'article
            List<Artiste> artistes = article.get().getArtistes();
            //Envoie à la vue
            model.addAttribute("article", article);
            model.addAttribute("artistes", artistes);
            model.addAttribute("fragmentForm", "fragments :: format");
            model.addAttribute("fragment", "parcours_achat");
            return "index";
        } else {
            return "redirect:/";
        }
    }

    //Recupération du format
    @PostMapping("/oeuvre/{ref}/finition")
    public String postOeuvreFinition(
            Model model,
            @PathVariable Long ref,
            @RequestParam(name = "format") String format
    ) {
        //On recupere l'objet article
        Optional<Article> article = articleService.findById(ref);
        choixPersonnalisation.setFormat(format);
        if (article.isPresent()) {
            //On recupere la liste des artistes associés à l'article
            List<Artiste> artistes = article.get().getArtistes();
            //Envoie à la vue
            model.addAttribute("article", article);
            model.addAttribute("artistes", artistes);
            model.addAttribute("format", format);
            model.addAttribute("fragmentForm", "fragments :: finition");
            model.addAttribute("fragment", "parcours_achat");
            return "index";
        } else {
            return "redirect:/";
        }
    }

    //Recupération du finition
    @PostMapping("/oeuvre/{ref}/cadre")
    public String postOeuvreCadre(
            Model model,
            @PathVariable Long ref,
            @RequestParam(name = "finition") String finition

    ) {
        choixPersonnalisation.setFinition(finition);

        //On recupere l'objet article
        Optional<Article> article = articleService.findById(ref);

        if (article.isPresent()) {
            //On recupere la liste des artistes associés à l'article
            List<Artiste> artistes = article.get().getArtistes();
            //Envoie à la vue
            model.addAttribute("article", article);
            model.addAttribute("artistes", artistes);
            model.addAttribute("finition", finition);
            model.addAttribute("fragmentForm", "fragments :: cadre");
            model.addAttribute("fragment", "parcours_achat");
            return "index";
        } else {
            return "redirect:/";
        }
    }


    //Recupération du cadre
    @PostMapping("/oeuvre/{ref}")
    public String postOeuvre(
            Model model,
            @PathVariable Long ref,
            @RequestParam(name = "cadre") String cadre
    ) {
        choixPersonnalisation.setCadre(cadre);
        //On recupere l'objet article
        Optional<Article> article = articleService.findById(ref);

        if (article.isPresent()) {
            //On recupere la liste des artistes associés à l'article
            List<Artiste> artistes = article.get().getArtistes();
            //Envoie à la vue
            model.addAttribute("article", article);
            model.addAttribute("artistes", artistes);
            model.addAttribute("cadre", cadre);
            model.addAttribute("fragmentForm", "fragments :: cadre");
            model.addAttribute("fragment", "parcours_achat");
            System.out.println(choixPersonnalisation);

            // TODO : Envoi des infos vers la page du panier
            return "redirect:/";
        } else {
            return "redirect:/";
        }
    }
}
