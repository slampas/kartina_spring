package com.formation.kartina_spring.utils;

import java.util.*;

import com.formation.kartina_spring.enums.*;
import com.formation.kartina_spring.models.*;
import com.formation.kartina_spring.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemplissageBDDParcoursPhoto {

    private final ArticleService articleService;
    private final ImageService imageService;
    private final CadreService cadreService;
    private final FinitionService finitionService;
    private final FormatService formatService;

    private final JointureArticleFormatService articleFormatService;

    @Autowired
    public RemplissageBDDParcoursPhoto(
            ArticleService articleService,
            ImageService imageService,
            CadreService cadreService,
            FinitionService finitionService,
            FormatService formatService,
            JointureArticleFormatService articleFormatService
    ) {
        this.articleService = articleService;
        this.imageService = imageService;
        this.cadreService = cadreService;
        this.finitionService = finitionService;
        this.formatService = formatService;

        this.articleFormatService = articleFormatService;
    }


    public void saveDBArticle() {
        Article article1 = new Article();
        Format format1 = new Format();
        Cadre cadre1 = new Cadre();
        Finition finition1 = new Finition();

        //***ARTICLE -IMAGE***

        //Pour update tjr le meme article
        //article1.setArticleRef(8L);

        article1.setNom("Article1_nom");
        article1.setDescription("Article1_description");
        article1.setDateAjout(new GregorianCalendar(2020, Calendar.SEPTEMBER, 30));
        article1.setPrixBase(20.50f);

//        //Article sans image associé
//        articleService.save(article1);

        Image image1 = new Image();

        //Pour update tjr la meme image
        // image1.setImageId(10L);

        image1.setNom("Image1_nom");
        image1.setHauteur(500L);
        image1.setLargeur(500L);
        image1.setUrl("image1.jpg");

        Image image2 = new Image();

        //Pour update tjr la meme image
        //image2.setImageId(10L);

        image2.setNom("Image2_nom");
        image2.setHauteur(500L);
        image2.setLargeur(500L);
        image2.setUrl("image2.jpg");

        //Liaison des deux images avec l'article
        image1.setArticle(article1);
        image2.setArticle(article1);

        imageService.save(image1);
        imageService.save(image2);

        // ARTICLE - FORMAT / FINITION / CADRE
        cadre1.setCadreEnum(CadreEnum.BOIS_BLANC);
        cadre1.setCoefficientPrix(5.0f);
        format1.setFormatEnum(FormatEnum.COLLECTOR);
        format1.setCoefficientPrix(1.5f);
        finition1.setFinitionEnum(FinitionEnum.BLACKOUT);
        finition1.setCoefficientPrix(2.0f);

        cadreService.save(cadre1);

        // Jointure Cadre - Finition
        List<Cadre> cadres = new ArrayList<>();
        cadres.add(cadre1);
        finition1.setCadres(cadres);
        finitionService.save(finition1);

        // Jointure Fintion-Format
        List<Finition> finitions = new ArrayList<>();
        finitions.add(finition1);
        format1.setFinitions(finitions);
        formatService.save(format1);

        articleService.save(article1);

        //Generation de la clé
        JointureArticleFormatId articleFormatId = new JointureArticleFormatId();
        articleFormatId.setArticleId(article1.getArticleRef());
        articleFormatId.setFormatId(format1.getFormatId());


        JointureArticleFormat articleFormat = new JointureArticleFormat();
        articleFormat.setId(articleFormatId);
        articleFormat.setFormat(format1);
        articleFormat.setArticle(article1);
        articleFormat.setQuantiteDispo(33);

        articleFormatService.save(articleFormat);
    }

}
