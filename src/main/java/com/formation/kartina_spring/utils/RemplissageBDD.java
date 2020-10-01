package com.formation.kartina_spring.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.GregorianCalendar;

import com.formation.kartina_spring.enums.CadreEnum;
import com.formation.kartina_spring.enums.FinitionEnum;
import com.formation.kartina_spring.enums.FormatEnum;
import com.formation.kartina_spring.enums.OrientationEnun;
import com.formation.kartina_spring.enums.RoleUtilisateur;
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
import com.formation.kartina_spring.models.Image;
import com.formation.kartina_spring.models.JointureArticleFormat;

import com.formation.kartina_spring.models.Orientation;
import com.formation.kartina_spring.models.Tag;
import com.formation.kartina_spring.models.Theme;
import com.formation.kartina_spring.models.UserType;
import com.formation.kartina_spring.models.Utilisateur;
import com.formation.kartina_spring.services.AdresseService;
import com.formation.kartina_spring.services.ArticleService;
import com.formation.kartina_spring.services.ArtisteService;
import com.formation.kartina_spring.services.CadreService;
import com.formation.kartina_spring.services.CodePromotionnelService;
import com.formation.kartina_spring.services.CommandeService;
import com.formation.kartina_spring.services.DetailCommandeService;
import com.formation.kartina_spring.services.FactureService;
import com.formation.kartina_spring.services.FinitionService;
import com.formation.kartina_spring.services.FormatService;
import com.formation.kartina_spring.services.ImageService;
import com.formation.kartina_spring.services.JointureArticleFormatService;

import com.formation.kartina_spring.services.OrientationService;
import com.formation.kartina_spring.services.TagService;
import com.formation.kartina_spring.services.ThemeService;
import com.formation.kartina_spring.services.UserTypeService;
import com.formation.kartina_spring.services.UtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemplissageBDD {

  AdresseService adresseService;
  ArtisteService artisteService;
  ArticleService articleService;
  CommandeService commandeService;
  FactureService factureService;
  UtilisateurService utilisateurService;
  CadreService cadreService;
  FinitionService finitionService;
  FormatService formatService;
  TagService tagService;
  ThemeService themeService;
  OrientationService orientationService;
  ImageService imageService;
  CodePromotionnelService codePromotionnelService;
  DetailCommandeService detailCommandeService;
  UserTypeService userTypeService;
  JointureArticleFormatService jointureArticleFormatService;

  
  
  
  public void saveDB() {

    Cadre cadre1 = new Cadre();
    Finition finition1 = new Finition();
    Format format1 = new Format();
    Tag tag1 = new Tag();
    Theme theme1 = new Theme();
    Image image1 = new Image();
    CodePromotionnel codePromotionnel1 = new CodePromotionnel();

/****************************************************/
    Adresse adresse1 = new Adresse();
    adresse1.setCodePostal((long) 5900);
    adresse1.setComplementVoie("complementVoie");
    adresse1.setNomAdresse("nom de l' Adresse");
    adresse1.setNum("20");
    adresse1.setPays("France");
    adresse1.setVille("Lille");
    adresse1.setVoie("rue");
    adresseService.save(adresse1);

    /****************************************************/

    Article article1 = new Article();
    article1.setDateAjout(new GregorianCalendar(2020, 7, 20));
    article1.setDescription(" cesi est une description de l'article ");
    article1.setNom("the name  of this article");
    article1.setPrixBase((float) 100.00);
    articleService.save(article1);

    /****************************************************/

    Artiste artiste1 = new Artiste();
    artiste1.setBiographie("ceci est la biographie de l'artiste");
    artiste1.setNationalite("Fraçaise");
    artiste1.setNom("Lecoq");
    artiste1.setPrenom("Charles");
    artiste1.setArticles(new ArrayList<Article>(Arrays.asList(article1))); // 
    artisteService.save(artiste1);

    /****************************************************/

    UserType userType1 = new UserType();
    userType1.setUserEnum(RoleUtilisateur.UTILISATEUR);
    userType1.setUserEnum(RoleUtilisateur.ADMIN);
    userTypeService.save(userType1);

    /****************************************************/

    Utilisateur utilisateur1 = new Utilisateur();
    utilisateur1.setAdresse(adresse1);
    utilisateur1.setArtiste(artiste1);
    utilisateur1.setCivilite("Monsieur");
    utilisateur1.setEmail("ceci est l'email");
    utilisateur1.setNom("Baziz");
    utilisateur1.setPassword("the password");
    utilisateur1.setPasswordHash("passwordHash");
    utilisateur1.setPrenom("moussa");
    utilisateur1.setSalt("salt");
    utilisateur1.setTelephone("060654812");
    utilisateur1.setRole(userType1);
    utilisateurService.save(utilisateur1);

    /****************************************************/

    codePromotionnel1.setDescription("ceci est la description de l'article");
    codePromotionnel1.setDateLimite(new GregorianCalendar(2020, 7, 10));
    codePromotionnelService.save(codePromotionnel1);

    /****************************************************/

    Commande commande1 = new Commande();
    commande1.setTVA(20);
    commande1.setDate(new GregorianCalendar(2020, 7, 20));
    commande1.setDateLivraison(new GregorianCalendar(2020, 7, 26));
    commande1.setDatePaiement(new GregorianCalendar(2020, 7, 29));
    commande1.setPrixTotalHt(150);
    commande1.setCodePromotionnel(codePromotionnel1);
    commande1.setUser(utilisateur1);
    commandeService.save(commande1);

    /****************************************************/

    DetailCommande detailCommande1 = new DetailCommande();
    detailCommande1.setQuantiteArticle(8);
    detailCommande1.setArticle(article1);
    detailCommande1.setCommande(commande1);

    /****************************************************/

    Facture facture1 = new Facture();
    facture1.setTVA(20);
    facture1.setDateLivraison(new GregorianCalendar(2020, 7, 20));
    facture1.setDatePaiement(new GregorianCalendar(2020, 7, 20));
    facture1.setDate(new GregorianCalendar(2020, 7, 10));
    facture1.setDescription("cesi est une description de la facture ");
    facture1.setPaiementId("paiementId"); // le id du paiment
    facture1.setPrixHt(100);
    facture1.setUserEmail("userEmail@gmail.com");
    facture1.setUserForname("userForname");
    facture1.setUserName("userName");
    factureService.save(facture1);

    /****************************************************/
    finition1.setFinitionEnum(FinitionEnum.BLACKOUT);
    cadre1.setCadreEnum(CadreEnum.ALUMINIUM_BROSSE);
    cadreService.save(cadre1);



    format1.setFormatEnum(FormatEnum.CLASSIQUE);

    tag1.setNom("un nom de ce tag ");
    tag1.setArticles(new ArrayList<Article>(Arrays.asList(article1)));
   
/****************************************************/

    theme1.setNom("ceci est un theme ");
    theme1.setArticles(new ArrayList<Article>(Arrays.asList(article1)));

  /****************************************************/

    Orientation orientation1 = new Orientation();
    orientation1.setNom(OrientationEnun.PAYSAGE);
  
    /****************************************************/

    image1.setNom("ceci est le nom de l'article");
    image1.setUrl("ceci est l'url de l'article");
    image1.setLargeur((long) 800.00);
    image1.setHauteur((long) 400);
    image1.setArticle(article1); 

/****************************************************/

    finitionService.save(finition1);
    formatService.save(format1);
    tagService.save(tag1);
    themeService.save(theme1);
    orientationService.save(orientation1);
    imageService.save(image1);

    /****************************************************/

    detailCommande1.setFinition(finition1);
    detailCommande1.setCadre(cadre1);
    detailCommande1.setFormat(format1);
    detailCommandeService.save(detailCommande1);
  }



  @Autowired
  public RemplissageBDD(AdresseService adresseService, ArtisteService artisteService, ArticleService articleService,
      CommandeService commandeService, FactureService factureService, UtilisateurService utilisateurService,
      CadreService cadreService, FinitionService finitionService, FormatService formatService, TagService tagService,
      ThemeService themeService, OrientationService orientationService, ImageService imageService,
      CodePromotionnelService codePromotionnelService, DetailCommandeService detailCommandeService,
      UserTypeService userTypeService, JointureArticleFormatService jointureArticleFormatService) {
    this.adresseService = adresseService;
    this.artisteService = artisteService;
    this.articleService = articleService;
    this.commandeService = commandeService;
    this.factureService = factureService;
    this.utilisateurService = utilisateurService;
    this.cadreService = cadreService;
    this.finitionService = finitionService;
    this.formatService = formatService;
    this.tagService = tagService;
    this.themeService = themeService;
    this.orientationService = orientationService;
    this.imageService = imageService;
    this.codePromotionnelService = codePromotionnelService;
    this.detailCommandeService = detailCommandeService;
    this.userTypeService = userTypeService;
    this.jointureArticleFormatService = jointureArticleFormatService;

  }

}
