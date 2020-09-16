package com.formation.kartina_spring.services;

import com.formation.kartina_spring.models.Article;
import com.formation.kartina_spring.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    private ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public void save(Article article) {
        articleRepository.save(article);
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }
}
