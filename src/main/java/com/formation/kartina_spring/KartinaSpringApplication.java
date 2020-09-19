package com.formation.kartina_spring;

import com.formation.kartina_spring.enums.CadreEnum;
import com.formation.kartina_spring.enums.FinitionEnum;
import com.formation.kartina_spring.enums.FormatEnum;
import com.formation.kartina_spring.enums.OrientationEnun;
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
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.BeanDefinitionDsl.Role;

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
        Utilisateur utilisateur1 = new Utilisateur();
    
        Cadre cadre1 = new Cadre();
        Finition finition1= new Finition();
        Format format1 = new Format();
        Tag tag1 = new Tag();
        Theme theme1 = new Theme();
        Orientation orientation1 = new Orientation();
        Image image1 = new Image();
        CodePromotionnel codePromotionnel1 = new CodePromotionnel();

    
    adresse1.setCodePostal((long) 5900);
    adresse1.setComplementVoie("complementVoie");
    adresse1.setNomAdresse("nom de l' Adresse");
    adresse1.setNum("20");
    adresse1.setPays("France");
    adresse1.setUser(utilisateur1);  // le type 
    adresse1.setVille("Lille");
    adresse1.setVoie("rue");
    

    artiste1.setBiographie("ceci est la biographie de l'artiste");
    artiste1.setNationalite("Fraçaise");
    artiste1.setNom("Lecoq");
    artiste1.setPrenom("Charles");
    artiste1.setArticles(articles); //listes d'articles
    artiste1.setArtisteId(artisteId);//artiste id
    artiste1.setUsers(users);// liste d'utilisateurs

    article1.setDateAjout(20 juillet 2020);   // voir type date
    article1.setDescription(" cesi est une description de l'article ");
    article1.setName("the name of this article");
    article1.setNom("the name  of this article");
    article1.setPrixBase((float) 100.00);
    article1.setOrientation(orientation1);
    article1.setArtistes(artistes);  //liste d'artistes
    article1.setCommandes(commandes);  //liste de commandes

    
    
    commande1.setTVA(20);    
    commande1.setDate(20 janvier 2020);
    commande1.setDateLivraison(20 juillet 2020);
    commande1.setDatePaiement( 27 juillet 2020);
    commande1.setPrixTotalHt(150);
    commande1.setCodePromotionnel(codePromotionnel1);
    commande1.setUser(utilisateur1);
    commande1.setArticles(articles);//liste d'articles

    
    facture1.setTVA(20);
    facture1.setDateLivraison(20 juillet 2020);
    facture1.setDatePaiement(10 juillet 2020);
    facture1.setDescription("cesi est une description de la facture ");
    facture1.setPaiementId("paiementId"); //le id du paiment
    facture1.setPrixHt(100);
    facture1.setUserEmail("userEmail");
    facture1.setUserForname("userForname");
    facture1.setUserName("userName"); 


    utilisateur1.setAdresse(adresse1);
    utilisateur1.setArtiste(artiste1);
    utilisateur1.setCivilite("Monsieur");
    utilisateur1.setCommandes(commandes);//une listes de commandes
    utilisateur1.setEmail("ceci est l'email");
    utilisateur1.setNom("Baziz");
    utilisateur1.setPassword("the password");
    utilisateur1.setPasswordHash("passwordHash");
    utilisateur1.setPrenom("moussa");
    utilisateur1.setRole(Role.APPLICATION);   // à voir ...
    utilisateur1.setSalt("salt");
    utilisateur1.setTelephone("060654812");
        

    cadre1.setCadreEnum(CadreEnum.ALUMINIUM_BROSSE); //type
    cadre1.setFinitions(finitions);  // liste de finitions


    
    finition1.setFinitionEnum(FinitionEnum.BLACKOUT);
    finition1.setCadres(cadres);   //listes de cadres
    finition1.setFormats(formats);   // listes de formats
    
 
    format1.setArticles(articles); // listes d'articles
    format1.setFinitions(finitions); 
    format1.setFormatEnum(FormatEnum.CLASSIQUE);  

    tag1.setNom("un nom de ce tag ");
    tag1.setArticles(articles);// listes d'articles

    
    theme1.setNom("ceci est un theme ");
    theme1.setArticles(articles);// une liste d'articles  
        
    

    /*voir avec marc antoine , ajout du lambok pour l'import des geters setters*/
    orientation1.setNom(OrientationEnun.PAYSAGE);
    orientation1.setArticles(articles);  // listes d'articles 
 
        
    image1.setNom("ceci est le nom de l'article");
    image1.setUrl("ceci est l'url de l'article");
    image1.setLargeur((long) 800.00);
    image1.setHauteur((long) 400);
    image1.setArticle(article1); // le nom de l'article
    
    
    codePromotionnel1.setDescription("ceci est la description de l'article");
    codePromotionnel1.setDateLimite(20 janvier 2021); 
    codePromotionnel1.setCommande(commandes); // une liste de commandes 
    c


}


}
