package com.formation.kartina_spring.controllers.admin;

import java.util.Calendar;
import java.util.Optional;

import javax.validation.Valid;

import com.formation.kartina_spring.models.Article;
import com.formation.kartina_spring.services.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/articles")
public class AdminArticleController {

    private final ArticleService articleService;

    @Autowired
    public AdminArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("articles", articleService.findAll());
        model.addAttribute("fragment", "article/index");
        return "admin/index";
    }

    @GetMapping("add")
    public String getCreateArticle(Model model, Article article) {
        model.addAttribute("action", "/add");
        model.addAttribute("fragment", "article/formajout");
        return "admin/index";
    }

    @PostMapping("add")
    public String postCreateArticle(Model model, @Valid @ModelAttribute(name = "article") Article article,
            BindingResult articleBinding, RedirectAttributes attributes) {
        if (!articleBinding.hasErrors()) {
            article.setDateAjout(Calendar.getInstance());
            article.setNom(article.getName());
            System.out.println(article);
            articleService.save(article);
            attributes.addFlashAttribute("message", "L'article " + article.getName() + " a bien été enregistré");
            return "redirect:/admin/articles";
        }
        model.addAttribute("action", "/add");
        model.addAttribute("fragment", "article/formajout");
        return "/admin/index";
    }

   /* @GetMapping("{ref}")
    public String oneArticle(@PathVariable Long ref, @RequestParam String action, Model model) {
        Optional<Article> article = articleService.findById(ref);
        if (action.equals("delete")) {

            if (article.isPresent()) {
                // File file = new
                // File("src/main/resources/static/img/"+article.get().getLink());
                // file.delete();
                articleService.delete(ref);
            }

            return "redirect:/admin/articles";
        }

        if (action.equals("update") && article.isPresent()) {
            model.addAttribute("article", article.get());
            model.addAttribute("action", "/" + ref + "?action=update");
            model.addAttribute("fragment", "article/form");
        }

        return "admin/index";
    }

    /*
     * @PostMapping("{ref}") public String update(
     * 
     * @Valid @ModelAttribute(name = "article") Article article, BindingResult
     * articleBinding,
     * 
     * @PathVariable Long ref,
     * 
     * @RequestParam String action,
     * 
     * @RequestParam(name = "image") MultipartFile image, Model model,
     * RedirectAttributes attributes ) {
     * 
     * if (!articleBinding.hasErrors()) {
     * 
     * 
     * boolean isValid = true;
     * 
     * if (!image.isEmpty() && image.getContentType().equals("image/jpeg") ||
     * image.getContentType().equals("image/webp") ||
     * image.getContentType().equals("image/heic") ||
     * image.getContentType().equals("image/png") ) {
     * 
     * File img = new File("src/main/resources/static/img/" +
     * image.getOriginalFilename()); try (BufferedOutputStream bos = new
     * BufferedOutputStream(new FileOutputStream(img))) {
     * bos.write(image.getBytes()); if (new File("src/main/resources/static/img/" +
     * article.getArticleRef().delete()) {
     * article.setLink(image.getOriginalFilename()); } } catch (IOException e) {
     * isValid = false; model.addAttribute("action", "/" + ref + "?action=update");
     * model.addAttribute("fragment", "article/form");
     * model.addAttribute("errorMessage", "Un problème de sauvegarde est survenu");
     * } }
     * 
     * if (isValid) { articleService.save(article);
     * attributes.addFlashAttribute("message", "L'article " + ref +
     * " a bien été mis à jour"); return "redirect:/admin/articles"; } }
     * model.addAttribute("action", "/" + ref + "?action=update");
     * model.addAttribute("fragment", "article/form"); return "/admin/index"; }
     */

}
