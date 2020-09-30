package com.formation.kartina_spring.utils;
import java.util.ArrayList;
import java.util.Arrays;
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
  JointureFinitionCadreService jointureFinitionCadreService;
  JointureFormatFinitionService jointureFormatFinitionService;

  public void saveDB() {

    Cadre cadre1 = new Cadre();
    Finition finition1 = new Finition();
    Format format1 = new Format();
    Tag tag1 = new Tag();
    Theme theme1 = new Theme();
    Image image1 = new Image();
    CodePromotionnel codePromotionnel1 = new CodePromotionnel();

    /********************************************************************/
    Adresse adresse1 = new Adresse();
    adresse1.setCodePostal((long) 5900);
    adresse1.setComplementVoie("complementVoie");// listes d'articles
    adresse1.setNomAdresse("nom de l' Adresse");
    adresse1.setNum("20");
    adresse1.setPays("France");
    adresse1.setVille("Lille");
    adresse1.setVoie("rue");

    adresseService.save(adresse1);

    /* listes d'adresse */
    Adresse adresse2 = new Adresse();
    adresse2.setCodePostal((long) 5900);
    adresse2.setComplementVoie("une adresse complementVoie");
    adresse2.setNomAdresse("rue des champs bleu");
    adresse2.setNum("25");
    adresse2.setPays("France");
    adresse2.setVille("Paris");
    adresse2.setVoie("rue");
    adresseService.save(adresse2);
    Adresse adresse3 = new Adresse();
    adresse3.setCodePostal((long) 75000);
    adresse3.setComplementVoie("Voie");
    adresse3.setNomAdresse("rue des Fantomes");
    adresse3.setNum("25");
    adresse3.setPays("France");
    adresse3.setVille("Paris");
    adresse3.setVoie("rue");
    adresseService.save(adresse3);
    Adresse adresse4 = new Adresse();
    adresse4.setCodePostal((long) 92000);
    adresse4.setComplementVoie("une adresse complementVoie");
    adresse4.setNomAdresse("rue des champs bleu");
    adresse4.setNum("25");
    adresse4.setPays("France");
    adresse4.setVille("Evry");
    adresse4.setVoie("rue");
    adresseService.save(adresse4);
    Adresse adresse5 = new Adresse();
    adresse5.setCodePostal((long) 92000);
    adresse5.setComplementVoie("rue");
    adresse5.setNomAdresse("rue d/ listes d'articleses comptines bleu");
    adresse5.setNum("25");
    adresse5.setPays("France");
    adresse5.setVille("Evry");
    adresse5.setVoie("rue");
    adresseService.save(adresse5);
    Adresse adresse6 = new Adresse();
    adresse6.setCodePostal((long) 91000);
    adresse6.setComplementVoie("une adresse complementVoie");
    adresse6.setNomAdresse("rue des champs bleu");
    adresse6.setNum("25");
    adresse6.setPays("France");
    adresse6.setVille("Corbeilles-essones");
    adresse6.setVoie("rue");
    adresseService.save(adresse6);

    /********************************************************************/

    Article article1 = new Article();
    article1.setDateAjout(new GregorianCalendar(2020, 7, 20));
    article1.setDescription(" cesi est une description de l'article ");
    article1.setName("the name of this article");
    article1.setNom("the name  of/ listes d'articles this article");
    article1.setPrixBase((float) 200);
    articleService.save(article1);
    /* LIstes d'articles */

    Article article2 = new Article();
    article2.setDateAjout(new GregorianCalendar(2020, 7, 20));
    article2.setDescription(" cesi est une description de l'article ");
    article2.setName("the name of this article");
    article2.setNom("the name  of this article");
    //article2.setPrixBase(300f);
    articleService.save(article2);
    Article article3 = new Article();
    article3.setDateAjout(new GregorianCalendar(2020, 7, 20));
    article3.setDescription(" cesi est une description de l'article ");
    article3.setName("the name of this article");
    article3.setNom("the name  of this article");
    //article3.setPrixBase(200f);
    articleService.save(article3);
    Article article4 = new Article();
    article4.setDateAjout(new GregorianCalendar(2020, 7, 20));
    article4.setDescription(" cesi est une description de l'article ");
    article4.setName("the name of this article");
    article4.setNom("the name  of this article");
    //article4.setPrixBase( 150f);
    articleService.save(article4);
    Article article5 = new Article();
    article5.setDateAjout(new GregorianCalendar(2020, 7, 20));
    article5.setDescription(" cesi est une description de l'article ");
    article5.setName("the name of this article");
    article5.setNom("the name  of this article");
    //article5.setPrixBase( 110f);
    articleService.save(article5);
    Article article6 = new Article();
    article6.setDateAjout(new GregorianCalendar(2020, 7, 20));
    article6.setDescription(" cesi est une description de l'article ");
    article6.setName("the name of this article");
    article6.setNom("the name  of this article");
    //article6.setPrixBase(300f);
    articleService.save(article6);

    /*****************************************************************************************/

    Artiste artiste1 = new Artiste();
    artiste1.setBiographie("ceci est la biographie de l'artiste");
    artiste1.setNationalite("Fraç/ listes d'articlesaise");
    artiste1.setNom("Lecoq");
    artiste1.setPrenom("Charles");
    artiste1.setArticles(new ArrayList<Article>(Arrays.asList(article1))); // listes d'articles

    artisteService.save(artiste1);

    /** Liiste d'artistes ***************/
    Artiste artiste2 = new Artiste();
    artiste2.setBiographie(
        " Elle fut l'élève de Charles Chaplin, de Jean-Jacques Henner et de Carolus-Duran. Elle accède à la notoriété grâce à un portrait de Sarah Bernhardt, réalisé en 1875 et conservé au musée Carnavalet. Sarah Bernhardt (qui sera sa compagne de vie4,5) fera un buste en");
    artiste2.setNationalite("Fraçaise");
    artiste2.setNom("Abbéma");
    artiste2.setPrenom("Louise ");
    artiste2.setArticles(new ArrayList<Article>(Arrays.asList(article1)));
    artisteService.save(artiste2);
    Artiste artiste3 = new Artiste();
    artiste3.setBiographie(
        " Elle fut l'élève de Charles Chaplin, de Jean-Jacques Henner et de Carolus-Duran. Elle accède à la notoriété grâce à un portrait de Sarah Bernhardt, réalisé en 1875 et conservé au musée Carnavalet. Sarah Bernhardt (qui sera sa compagne de vie4,5) fera un buste en");
    artiste3.setNationalite("Fraçaise");
    artiste3.setNom(" Abélanet");
    artiste3.setPrenom("Sylvie");
    artiste3.setArticles(new ArrayList<Article>(Arrays.asList(article1)));
    artisteService.save(artiste3);
    Artiste artiste4 = new Artiste();
    artiste4.setBiographie(
        " Elle fut l'élève de Charles Chaplin, de Jean-Jacques Henner et de Carolus-Duran. Elle accède à la notoriété grâce à un portrait de Sarah Bernhardt, réalisé en 1875 et conservé au musée Carnavalet. Sarah Bernhardt (qui sera sa compagne de vie4,5) fera un buste en");
    artiste4.setNationalite("Fraçaise");
    artiste4.setNom("Edmond ");
    artiste4.setPrenom("Aman-Jean ");
    artiste4.setArticles(new ArrayList<Article>(Arrays.asList(article1)));
    artisteService.save(artiste4);
    Artiste artiste5 = new Artiste();
    artiste5.setBiographie(
        " Elle fut l'élève de Charles Chaplin, de Jean-Jacques Henner et de Carolus-Duran. Elle accède à la notoriété grâce à un portrait de Sarah Bernhardt, réalisé en 1875 et conservé au musée Carnavalet. Sarah Bernhardt (qui sera sa compagne de vie4,5) fera un buste en");
    artiste5.setNationalite("Fraçaise");
    artiste5.setNom("Amaury");
    artiste5.setPrenom("Duval");
    artiste5.setArticles(new ArrayList<Article>(Arrays.asList(article1)));
    artisteService.save(artiste5);

    /**********************************************************************/

    UserType userType1 = new UserType();
    userType1.setUserEnum(RoleUtilisateur.UTILISATEUR);
    userType1.setUserEnum(RoleUtilisateur.ADMIN);
    // userType1.setUser(new ArrayList<Utilisateur>(Arrays.asList(utilisateur1)));

    userTypeService.save(userType1);

    /*****************************************************************************/

    Utilisateur utilisateur1 = new Utilisateur();
    utilisateur1.setAdresse(adresse1);
    utilisateur1.setArtiste(artiste1);
    utilisateur1.setCivilite("Monsieur");
    utilisateur1.setEmail("amir@amir");
    utilisateur1.setNom("Baziz");
    utilisateur1.setPassword("the password");
    utilisateur1.setPasswordHash("passwordHash");
    utilisateur1.setPrenom("moussa");
    utilisateur1.setSalt("salt");
    utilisateur1.setTelephone("060654812");
    utilisateur1.setRole(userType1);

    utilisateurService.save(utilisateur1);
    /* LIST D'UTILISATEURS */

    Utilisateur utilisateur4 = new Utilisateur();
    utilisateur4.setAdresse(adresse1);
    utilisateur4.setArtiste(artiste1);
    utilisateur4.setCivilite("Monsieur");
    utilisateur4.setEmail("imad@imad");
    utilisateur4.setNom("imadNom");
    utilisateur4.setPassword("the password");
    utilisateur4.setPasswordHash("passwordHash");
    utilisateur4.setPrenom("imad");
    utilisateur4.setSalt("salt");
    utilisateur4.setTelephone("060654812");
    utilisateur4.setRole(userType1);
    utilisateurService.save(utilisateur4);
    Utilisateur utilisateur2 = new Utilisateur();
    utilisateur2.setAdresse(adresse2);
    utilisateur2.setArtiste(artiste2);
    utilisateur2.setCivilite("Monsieur");
    utilisateur2.setEmail("eric@eric");
    utilisateur2.setNom("ericNom");
    utilisateur2.setPassword("the password");
    utilisateur2.setPasswordHash("passwordHash");
    utilisateur2.setPrenom("eric");
    utilisateur2.setSalt("salt");
    utilisateur2.setTelephone("060654812");
    utilisateur2.setRole(userType1);
    utilisateurService.save(utilisateur2);
    Utilisateur utilisateur3 = new Utilisateur();
    utilisateur3.setAdresse(adresse3);
    utilisateur3.setArtiste(artiste4);
    utilisateur3.setCivilite("Monsieur");
    utilisateur3.setEmail("mantoine@mantoine");
    utilisateur3.setNom("mantoineNom");
    utilisateur3.setPassword("the password");
    utilisateur3.setPasswordHash("passwordHash");
    utilisateur3.setPrenom("m antoine");
    utilisateur3.setSalt("salt");
    utilisateur3.setTelephone("060654812");
    utilisateur3.setRole(userType1);
    utilisateurService.save(utilisateur3);


    /*****************************************************************/
    codePromotionnel1.setDescription("ceci est la description de l'article");
    codePromotionnel1.setDateLimite(new GregorianCalendar(2020, 7, 10));
    codePromotionnelService.save(codePromotionnel1);

    /*****************************************************************/

    Commande commande1 = new Commande();
    commande1.setTVA(20);
    commande1.setDate(new GregorianCalendar(2020, 7, 20));
    commande1.setDateLivraison(new GregorianCalendar(2020, 7, 26));
    commande1.setDatePaiement(new GregorianCalendar(2020, 7, 29));
    commande1.setPrixTotalHt(150);
    commande1.setCodePromotionnel(codePromotionnel1);
    commande1.setUser(utilisateur1);
    commandeService.save(commande1);

    /*****************************************************************/

    DetailCommande detailCommande1 = new DetailCommande();
    detailCommande1.setQuantiteArticle(8);
    detailCommande1.setArticle(article1);
    detailCommande1.setCommande(commande1);

    /*****************************************************************/

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

    

    /******* Liste de facture ********/
    Facture facture2 = new Facture();
    facture2.setTVA(20);
    facture2.setDateLivraison(new GregorianCalendar(2020, 7, 20));
    facture2.setDatePaiement(new GregorianCalendar(2020, 7, 20));
    facture2.setDate(new GregorianCalendar(2020, 7, 10));
    facture2.setDescription("cesi est une description de la facture ");
    facture2.setPaiementId("paiementId"); // le id du paiment
    facture2.setPrixHt(150);
    facture2.setUserEmail("userEmail@gmail.com");
    facture2.setUserForname("userForname");
    facture2.setUserName("userName");
    factureService.save(facture2);
    Facture facture3 = new Facture();
    facture3.setTVA(20);
    facture3.setDateLivraison(new GregorianCalendar(2020, 7, 20));
    facture3.setDatePaiement(new GregorianCalendar(2020, 7, 20));
    facture3.setDate(new GregorianCalendar(2020, 7, 10));
    facture3.setDescription("cesi est une description de la facture ");
    facture3.setPaiementId("paiementId"); // le id du paiment
    facture3.setPrixHt(190);
    facture3.setUserEmail("userEmail@gmail.com");
    facture3.setUserForname("userForname");
    facture3.setUserName("userName");
    factureService.save(facture3);

    /*****************************************************************/

    finition1.setFinitionEnum(FinitionEnum.BLACKOUT);
    /*****************************************************************/

    cadre1.setCadreEnum(CadreEnum.ALUMINIUM_BROSSE);
    /*****************************************************************/

    cadreService.save(cadre1);
    /*****************************************************************/

    format1.setFormatEnum(FormatEnum.CLASSIQUE);
    /*****************************************************************/

    tag1.setNom("un nom de ce tag ");
    tag1.setArticles(new ArrayList<Article>(Arrays.asList(article1)));// 
    /*****************************************************************/

    theme1.setNom("ceci est un theme ");
    theme1.setArticles(new ArrayList<Article>(Arrays.asList(article1)));
    

    Orientation orientation1 = new Orientation();
    orientation1.setNom(OrientationEnun.PAYSAGE);
    orientation1.setArticles(new ArrayList<Article>(Arrays.asList(article1))); 

    image1.setNom("ceci est le nom de l'article");
    image1.setUrl("ceci est l'url de l'article");
    image1.setLargeur((long) 800.00);
    image1.setHauteur((long) 400);
    image1.setArticle(article1); // le nom de l'article

    /* Les services */



    finitionService.save(finition1);
    formatService.save(format1);
    tagService.save(tag1);
    themeService.save(theme1);
    orientationService.save(orientation1);
    imageService.save(image1);

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
      UserTypeService userTypeService, JointureArticleFormatService jointureArticleFormatService,
      JointureFinitionCadreService jointureFinitionCadreService,
      JointureFormatFinitionService jointureFormatFinitionService) {
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
    this.jointureFinitionCadreService = jointureFinitionCadreService;
    this.jointureFormatFinitionService = jointureFormatFinitionService;

  }

}
