package com.formation.kartina_spring.utils;

import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;

import com.formation.kartina_spring.models.Adresse;
import com.formation.kartina_spring.models.Article;
import com.formation.kartina_spring.models.Artiste;
import com.formation.kartina_spring.models.Cadre;
import com.formation.kartina_spring.models.CodePromotionnel;
import com.formation.kartina_spring.models.Commande;
import com.formation.kartina_spring.models.DetailCommande;
import com.formation.kartina_spring.models.Facture;
import com.formation.kartina_spring.models.Finition;
import com.formation.kartina_spring.models.Format;
import com.formation.kartina_spring.models.Utilisateur;
import com.formation.kartina_spring.repositories.CodePromotionnelRepository;
import com.formation.kartina_spring.services.AdresseService;
import com.formation.kartina_spring.services.ArticleService;
import com.formation.kartina_spring.services.ArtisteService;
import com.formation.kartina_spring.services.CodePromotionnelService;
import com.formation.kartina_spring.services.CommandeService;
import com.formation.kartina_spring.services.DetailCommandeService;
import com.formation.kartina_spring.services.FactureService;
import com.formation.kartina_spring.services.UtilisateurService;

import org.springframework.stereotype.Component;

@Component
public class initKartina {

    AdresseService adresseService;
    ArticleService articleService;
    ArtisteService artisteService;
    CodePromotionnelService codePromotionnelService;
    CommandeService commandeService;
    UtilisateurService utilisateurService;
    DetailCommandeService detailCommandeService;
    FactureService factureService;

    public void initAdresse() {

        Stream.of("Lille", "Paris", "Lyon", "Marseille").forEach(villes -> {
            for(var i = 10;i < villes.length();i++){
                Adresse adresse = new Adresse();
                adresse.setCodePostal((long) 5900);
                adresse.setComplementVoie("complementVoie");
                adresse.setNomAdresse("nom de l' Adresse");
                adresse.setNum("20"+i);
                adresse.setPays("France");
                adresse.setVille(villes);
                adresse.setVoie("rue");
    
                adresseService.save(adresse);
            }

        }); 
    }



    public void initArticle() {

        Stream.of("Article1", "Article2", "Article3", "Article4","Article5").forEach(articles -> {

    Article article = new Article();
    article.setDateAjout(new GregorianCalendar(2020, (int) (Math.random()*10), 20));
    article.setDescription(" cesi est une description de détaillé de cette article ");
    article.setNom(articles);
    article.setPrixBase((float) Math.random()*10 );
    articleService.save(article);
        });
    
}

static int count = 0;
public void initArtiste() {
    /*type de retour*/
    //Article articles = initArticle();
    
    Stream.of("Charles Lecoq", "Pino Bar", "Fiesta lara", "Melodie Carmen","Samsam Renaud").forEach(artistes -> {

        Artiste artiste = new Artiste();
        artiste.setBiographie("ceci est la biographie de l'artiste, date de naissance vie privée,études et réalisations");
        artiste.setNationalite("Fraçaise");
        artiste.setNom(artistes);
        artiste.setPrenom(artistes);
        List<Article> articles = articleService.findAll();
        artiste.setArticles(Arrays.asList(articles.get(count++)));
        artisteService.save(artiste);

    });

}


public void initCodePromo() {

    Stream.of("Code Promo 1", "Code Promo 2", "Code Promo 3", "Code Promo 4","Code Promo 5").forEach(codePromos -> {
        CodePromotionnel codePromotionnel = new CodePromotionnel();
        codePromotionnel.setDescription(codePromos);
        codePromotionnel.setDateLimite(new GregorianCalendar(2020, 7, 10));
    
        codePromotionnelService.save(codePromotionnel);

    });

}


public void initCommande() {


    codePromotionnelService.findAll().forEach(c -> {
       
        

        Commande commande = new Commande();
        commande.setTVA(20);
        commande.setDate(new GregorianCalendar(2020, (int)Math.random()*10, 20));
        commande.setDateLivraison(new GregorianCalendar(2020, (int)Math.random()*10, 26));
        commande.setDatePaiement(new GregorianCalendar(2020, (int)Math.random()*10, 29));
        commande.setPrixTotalHt((int)Math.random()*100);
        
        commande.setCodePromotionnel(c);
        //commande.setUser(utilisateurService.findById() );
        //commande.setUser(utilisateurService.findById(""));
        commandeService.save(commande);

    });

}

public void initDetailCommande() {


    commandeService.findAll().forEach(c -> {
       
        Finition finition ;
        Article article ;
        Cadre cadre;
        Format format;

        DetailCommande detailCommande = new DetailCommande();
        detailCommande.setQuantiteArticle((int)Math.random()*10);
        detailCommande.setArticle(article);
        detailCommande.setCommande(c);
        detailCommande.setFinition(finition);
        detailCommande.setCadre(cadre);
        detailCommande.setFormat(format);
        detailCommandeService.save(detailCommande);

    });

}



public void initFacture() {

    Stream.of("0001", "0002", "0003", "0004","0005").forEach(factures -> {
 
        Facture facture = new Facture();
        facture.setTVA(20);
        facture.setDateLivraison(new GregorianCalendar(2020, 7, (int) Math.random()*10));
        facture.setDatePaiement(new GregorianCalendar(2020, 7, (int) Math.random()*10));
        facture.setDate(new GregorianCalendar(2020, 7, (int) Math.random()*10));
        facture.setDescription("cesi est une description de la facture ");
        facture.setPaiementId(factures);
        facture.setPrixHt((int)Math.random()*100);
        facture.setUserEmail(factures+"@gmail.com");
        facture.setUserForname("userForname");
        facture.setUserName("userName");
        factureService.save(facture);

    });

}






}
