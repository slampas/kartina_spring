package com.formation.kartina_spring.controllers;

import com.formation.kartina_spring.models.Article;
import com.formation.kartina_spring.models.Artiste;
import com.formation.kartina_spring.models.ChoixPersonnalisation;
import com.formation.kartina_spring.models.Image;
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


    @GetMapping("/oeuvre/{ref}")
    public String getOeuvre(
            Model model,
            @PathVariable Long ref,
            @RequestParam(name = "etape", required = true) String etape
    ) {
        //On recupere l'objet article
        Optional<Article> article = articleService.findById(ref);
        if (article.isPresent()) {
            //On recupere la liste des artistes associés à l'article
            List<Artiste> artistes = article.get().getArtistes();

            //On recupere la liste d'image associé à l'article
            List<Image> images = article.get().getImages();

            //Envoie à la vue
            model.addAttribute("article", article);
            model.addAttribute("artistes", artistes);
            model.addAttribute("images", images);
        }
        model.addAttribute("fragment", "parcours_achat");
        model.addAttribute("fragmentForm", "fragments :: format");
        return "index";
    }

    @PostMapping("/oeuvre/{ref}")
    public String postOeuvre(
            Model model,
            @PathVariable Long ref,
            @RequestParam(name = "format", required = false) String format,
            @RequestParam(name = "finition", required = false) String finition,
            @RequestParam(name = "cadre", required = false) String cadre,
            @RequestParam(name = "etape") String etape
    ) {
        Optional<Article> article = articleService.findById(ref);
        if (article.isPresent()) {
            List<Artiste> artistes = article.get().getArtistes();
            List<Image> images = article.get().getImages();
            model.addAttribute("article", article);
            model.addAttribute("artistes", artistes);
            model.addAttribute("images", images);
        }
        switch (etape) {
            case "finition":
                if (!format.isEmpty()) {
                    choixPersonnalisation.setFormat(format);
                    model.addAttribute("format", format);
                    model.addAttribute("fragmentForm", "fragments :: finition");
                }
                break;
            case "cadre":
                if (!finition.isEmpty()) {
                    choixPersonnalisation.setFinition(finition);
                    model.addAttribute("finition", finition);
                    model.addAttribute("fragmentForm", "fragments :: cadre");
                }
                break;
            case "panier":
                if (!cadre.isEmpty()) {
                    choixPersonnalisation.setCadre(cadre);
                    System.out.println(choixPersonnalisation);
                    // TODO : Envoi des infos vers la page du panier
                    return "redirect:/";
                }
        }
        model.addAttribute("fragment", "parcours_achat");
        return "index";
    }
}
