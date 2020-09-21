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
import com.formation.kartina_spring.models.JointureFinitionCadre;
import com.formation.kartina_spring.models.JointureFinitionCadreId;
import com.formation.kartina_spring.models.JointureFormatFinition;
import com.formation.kartina_spring.models.JointureFormatFinitionId;
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
import com.formation.kartina_spring.services.JointureFinitionCadreService;
import com.formation.kartina_spring.services.JointureFormatFinitionService;
import com.formation.kartina_spring.services.OrientationService;
import com.formation.kartina_spring.services.TagService;
import com.formation.kartina_spring.services.ThemeService;
import com.formation.kartina_spring.services.UserTypeService;
import com.formation.kartina_spring.services.UtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemplissageBDD{
    
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
    JointureArticleFormatService jointureArticleFormatService ;
    JointureFinitionCadreService jointureFinitionCadreService ;
    JointureFormatFinitionService  jointureFormatFinitionService ; 
    

    
  
    public void saveDB() {
  

      
      Commande commande1 = new Commande();
      Facture facture1 = new Facture();
     
  
      Cadre cadre1 = new Cadre();
      Finition finition1 = new Finition();
      Format format1 = new Format();
      Tag tag1 = new Tag();
      Theme theme1 = new Theme();
      Image image1 = new Image();
  
      CodePromotionnel codePromotionnel1 = new CodePromotionnel();
      DetailCommande detailCommande1 = new DetailCommande();
      

      
      
      
      
      Adresse adresse1 = new Adresse();
      adresse1.setCodePostal((long) 5900);
      adresse1.setComplementVoie("complementVoie");
      adresse1.setNomAdresse("nom de l' Adresse");
      adresse1.setNum("20");
      adresse1.setPays("France");
      adresse1.setVille("Lille");
      adresse1.setVoie("rue");
  
      adresseService.save(adresse1);

      Article article1 = new Article();
      article1.setDateAjout(new GregorianCalendar(2020, 7, 20));
      article1.setDescription(" cesi est une description de l'article ");
      article1.setName("the name of this article");
      article1.setNom("the name  of this article");
      article1.setPrixBase((float) 100.00);
  

      articleService.save(article1);

      Artiste artiste1 = new Artiste();
      artiste1.setBiographie("ceci est la biographie de l'artiste");
      artiste1.setNationalite("Fraçaise");
      artiste1.setNom("Lecoq");
      artiste1.setPrenom("Charles");
      artiste1.setArticles(new ArrayList<Article>(Arrays.asList(article1))); // listes d'articles

      artisteService.save(artiste1);
  
      Utilisateur utilisateur1 = new Utilisateur();
      utilisateur1.setAdresse(adresse1);
      utilisateur1.setArtiste(artiste1);
      utilisateur1.setCivilite("Monsieur");
      // utilisateur1.setCommandes(commandes);//une listes de commandes
      utilisateur1.setEmail("ceci est l'email");
      utilisateur1.setNom("Baziz");
      utilisateur1.setPassword("the password");
      utilisateur1.setPasswordHash("passwordHash");
      utilisateur1.setPrenom("moussa");
      utilisateur1.setSalt("salt");
      utilisateur1.setTelephone("060654812");

      utilisateurService.save(utilisateur1);
 /** **** création d'une liste d'utilisateurs *
      Utilisateur utilisateur2 = new Utilisateur();
      Utilisateur utilisateur3 = new Utilisateur();
      Utilisateur utilisateur4 = new Utilisateur();
      Utilisateur utilisateur5 = new Utilisateur();
      ArrayList<Utilisateur> users = new ArrayList<Utilisateur>();
      users.add(utilisateur1);
      users.add(utilisateur2);
      users.add(utilisateur3);
      users.add(utilisateur4);
      users.add(utilisateur5);

*/
UserType userType1 = new UserType();
         
      userType1.setUserEnum(RoleUtilisateur.ADMIN);
      userType1.setUser(new ArrayList<Utilisateur>(Arrays.asList(utilisateur1)));
  

      // article1.setArtistes((java.util.List<Artiste>) artistes); //liste d'artistes
      // article1.setCommandes(commandes); //liste de commandes
  
      /*
       * obligation de changement de type generique collection , ÃÂ  voir avec marc
       * anoine
       */
      /* creation de plusieurs articles */
      // Article article2 = new Article();
      // Article article3 = new Article();
      // Article article4 = new Article();
      // Article article5 = new Article();
  
      // ArrayList<Article> articles = new ArrayList<Article>();
      // articles.add(article1);
      // articles.add(article2);
      // articles.add(article3);
      // articles.add(article4);
      // articles.add(article5);
  
      ArrayList<DetailCommande> detailCommandes = new ArrayList<DetailCommande>();
      DetailCommande detailCommande2 = new DetailCommande();
      DetailCommande detailCommande3 = new DetailCommande();
      DetailCommande detailCommande4 = new DetailCommande();
      DetailCommande detailCommande5 = new DetailCommande();
      detailCommandes.add(detailCommande1);
      detailCommandes.add(detailCommande2);
      detailCommandes.add(detailCommande3);
      detailCommandes.add(detailCommande4);
      detailCommandes.add(detailCommande5);
  

      /* creation de plusieurs artistes */
      // Artiste artiste2 = new Artiste();
      // Artiste artiste3 = new Artiste();
      // Artiste artiste4 = new Artiste();
      // Artiste artiste5 = new Artiste();
      // ArrayList<Artiste> artistes = new ArrayList<Artiste>();
      // artistes.add(artiste2);
      // artistes.add(artiste3);
      // artistes.add(artiste4);
      // artistes.add(artiste5);
  
      commande1.setTVA(20);
      commande1.setDate(new GregorianCalendar(2020, 7, 20));
      commande1.setDate(new GregorianCalendar(2020, 7, 26));
      commande1.setDate(new GregorianCalendar(2020, 7, 29));
      commande1.setPrixTotalHt(150);
      commande1.setCodePromotionnel(codePromotionnel1);
      commande1.setUser(utilisateur1);
      commande1.setArticles(detailCommandes);// liste d'articles
      /* liste de commandes */
      Commande commande2 = new Commande();
      Commande commande3 = new Commande();
      Commande commande4 = new Commande();
      Commande commande5 = new Commande();
      Collection<Commande> commandes = new ArrayList<Commande>();
      commandes.add(commande1);
      commandes.add(commande2);
      commandes.add(commande3);
      commandes.add(commande4);
      commandes.add(commande5);
  
      facture1.setTVA(20);
      facture1.setDateLivraison(new GregorianCalendar(2020, 7, 20));
      facture1.setDate(new GregorianCalendar(2020, 7, 10));
      facture1.setDescription("cesi est une description de la facture ");
      facture1.setPaiementId("paiementId"); // le id du paiment
      facture1.setPrixHt(100);
      facture1.setUserEmail("userEmail");
      facture1.setUserForname("userForname");
      facture1.setUserName("userName");
  
      /* Liste de format jointures */
      JointureFormatFinitionId jointureFormatFinitionId = new JointureFormatFinitionId();
      JointureFormatFinition jointureFormatFinition1 = new JointureFormatFinition();
      JointureFormatFinition jointureFormatFinition2 = new JointureFormatFinition();
      JointureFormatFinition jointureFormatFinition3 = new JointureFormatFinition();
      JointureFormatFinition jointureFormatFinition4 = new JointureFormatFinition();
      JointureFormatFinition jointureFormatFinition5 = new JointureFormatFinition();
      ArrayList<JointureFormatFinition> formatsJointures = new ArrayList<JointureFormatFinition>();
      formatsJointures.add(jointureFormatFinition1);
      formatsJointures.add(jointureFormatFinition2);
      formatsJointures.add(jointureFormatFinition3);
      formatsJointures.add(jointureFormatFinition4);
      formatsJointures.add(jointureFormatFinition5);
      JointureFinitionCadreId jointureFinitionCadreid = new JointureFinitionCadreId();
      /* Liste de jointure finitions cadre */
      JointureFinitionCadre jointureFinitionCadre1 = new JointureFinitionCadre();
      JointureFinitionCadre jointureFinitionCadre2 = new JointureFinitionCadre();
      JointureFinitionCadre jointureFinitionCadre3 = new JointureFinitionCadre();
      JointureFinitionCadre jointureFinitionCadre4 = new JointureFinitionCadre();
      JointureFinitionCadre jointureFinitionCadre5 = new JointureFinitionCadre();
      ArrayList<JointureFinitionCadre> finitionsJointures = new ArrayList<JointureFinitionCadre>();
      finitionsJointures.add(jointureFinitionCadre1);
      finitionsJointures.add(jointureFinitionCadre2);
      finitionsJointures.add(jointureFinitionCadre3);
      finitionsJointures.add(jointureFinitionCadre4);
      finitionsJointures.add(jointureFinitionCadre5);
  
      finition1.setFinitionEnum(FinitionEnum.BLACKOUT);
      finition1.setCadres(finitionsJointures);
      finition1.setFormats(formatsJointures);
      /** Liste de finition */
      Finition finition2 = new Finition();
      Finition finition3 = new Finition();
      Finition finition4 = new Finition();
      Finition finition5 = new Finition();
      ArrayList<Finition> finitions = new ArrayList<Finition>();
      finitions.add(finition1);
      finitions.add(finition2);
      finitions.add(finition3);
      finitions.add(finition4);
      finitions.add(finition5);
  
      cadre1.setCadreEnum(CadreEnum.ALUMINIUM_BROSSE);
      cadre1.setFinitions(finitions);
      /* création d'une liste de cadre */
      Cadre cadre2 = new Cadre();
      Cadre cadre3 = new Cadre();
      Cadre cadre4 = new Cadre();
      Cadre cadre5 = new Cadre();
      ArrayList<Cadre> cadres = new ArrayList<Cadre>();
      cadres.add(cadre1);
      cadres.add(cadre2);
      cadres.add(cadre3);
      cadres.add(cadre4);
      cadres.add(cadre5);
  
      // JointureArticleFormatId JointureArticleFormatId = new
      // JointureArticleForutilisateurService.save(utilisateur1);matId();
      /* List de jointure Article format */
      JointureArticleFormat jointureArticleFormat1 = new JointureArticleFormat();
      JointureArticleFormat jointureArticleFormat2 = new JointureArticleFormat();
      JointureArticleFormat jointureArticleFormat3 = new JointureArticleFormat();
      JointureArticleFormat jointureArticleFormat4 = new JointureArticleFormat();
      JointureArticleFormat jointureArticleFormat5 = new JointureArticleFormat();
      ArrayList<JointureArticleFormat> articlesJointures = new ArrayList<JointureArticleFormat>();
      articlesJointures.add(jointureArticleFormat1);
      articlesJointures.add(jointureArticleFormat2);
      articlesJointures.add(jointureArticleFormat3);
      articlesJointures.add(jointureArticleFormat4);
      articlesJointures.add(jointureArticleFormat5);
  
      /******
       * a voir avec marc antoine la classe cadre pourquoi l'utilisation de la
       * jointure et du read
       *******/
      format1.setArticles(articlesJointures); // liste jointure cast impossible
      format1.setFinitions(formatsJointures); // liste de jointure aussi
      format1.setFormatEnum(FormatEnum.CLASSIQUE);
  
      tag1.setNom("un nom de ce tag ");
    tag1.setArticles(new ArrayList<Article>(Arrays.asList(article1)));// listes d'articles
  
      theme1.setNom("ceci est un theme ");
      theme1.setArticles(new ArrayList<Article>(Arrays.asList(article1)));// une liste d'articles
  
      /* voir avec marc antoine , ajout du lambok pour l'import des geters setters */
      Orientation orientation1 = new Orientation();
      orientation1.setNom(OrientationEnun.PAYSAGE);
      orientation1.setArticles(new ArrayList<Article>(Arrays.asList(article1))); // listes d'articles
  
      image1.setNom("ceci est le nom de l'article");
      image1.setUrl("ceci est l'url de l'article");
      image1.setLargeur((long) 800.00);
      image1.setHauteur((long) 400);
      image1.setArticle(article1); // le nom de l'article
  
      codePromotionnel1.setDescription("ceci est la description de l'article");
      codePromotionnel1.setDateLimite(new GregorianCalendar(2020, 7, 10));
      codePromotionnel1.setCommande((java.util.List<Commande>) commandes); // une liste de commandes
  
      
      /* Les services */
      userTypeService.save(userType1);
      
      //adresseService.save(adresse1);
      // utilisateurService.save(utilisateur1);
      // articleService.save(article1);
      
      //artisteService.save(artiste1);
      commandeService.save(commande1);
      factureService.save(facture1);
      
      cadreService.save(cadre1);
      finitionService.save(finition1);
      formatService.save(format1);
      tagService.save(tag1);
      themeService.save(theme1);
      orientationService.save(orientation1);
      imageService.save(image1);
      codePromotionnelService.save(codePromotionnel1);
      detailCommandeService.save(detailCommande1);

      jointureArticleFormatService.save(jointureArticleFormat1);
      jointureFinitionCadreService.save(jointureFinitionCadre1);
      jointureFormatFinitionService.save(jointureFormatFinition1); 

    }

    @Autowired
    public RemplissageBDD(AdresseService adresseService, ArtisteService artisteService, ArticleService articleService,
            CommandeService commandeService, FactureService factureService, UtilisateurService utilisateurService,
            CadreService cadreService, FinitionService finitionService, FormatService formatService,
            TagService tagService, ThemeService themeService, OrientationService orientationService,
            ImageService imageService, CodePromotionnelService codePromotionnelService,
            DetailCommandeService detailCommandeService, UserTypeService userTypeService ,JointureArticleFormatService jointureArticleFormatService,
            JointureFinitionCadreService jointureFinitionCadreService,
            JointureFormatFinitionService jointureFormatFinitionService ) {
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
        this.jointureArticleFormatService  =jointureArticleFormatService ;
        this.jointureFinitionCadreService=jointureFinitionCadreService ;
        this.jointureFormatFinitionService=jointureFormatFinitionService ;
       
    }
  
}
