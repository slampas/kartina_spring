package com.formation.kartina_spring;

import com.formation.kartina_spring.models.Adresse;
import com.formation.kartina_spring.models.Article;
import com.formation.kartina_spring.models.Artiste;
import com.formation.kartina_spring.models.Cadre;
import com.formation.kartina_spring.models.CodePromotionnel;
import com.formation.kartina_spring.models.Commande;
import com.formation.kartina_spring.models.Facture;
import com.formation.kartina_spring.models.Finition;
import com.formation.kartina_spring.models.Format;
import com.formation.kartina_spring.models.Image;
import com.formation.kartina_spring.models.Orientation;
import com.formation.kartina_spring.models.Tag;
import com.formation.kartina_spring.models.Theme;
import com.formation.kartina_spring.models.Utilisateur;
import com.formation.kartina_spring.services.ArticleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({
        @PropertySource(value = "classpath:application.properties"),
        @PropertySource(value = "classpath:datasource.properties", ignoreResourceNotFound = true)
})
public class KartinaSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(KartinaSpringApplication.class, args);
    }


   
   
   
    public void saveDB () {
    
        Adresse adresse1= new Adresse();
        Artiste artiste1 = new Artiste();
        Article article1 = new Article();
        Commande commande1 = new Commande();
        Facture facture1 = new Facture();
        Utilisateur utilsateur1 = new Utilisateur();

        Cadre cadre1 = new Cadre();
        Finition finition1= new Finition();
        Format format1 = new Format();
        Tag tag1 = new Tag();
        Theme theme1 = new Theme();
        Orientation orientation1 = new Orientation();
        Image image1 = new Image();
        CodePromotionnel codePromotionnel1 = new CodePromotionnel;



    }


}
