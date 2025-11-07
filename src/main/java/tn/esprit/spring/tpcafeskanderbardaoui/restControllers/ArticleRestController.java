package tn.esprit.spring.tpcafeskanderbardaoui.restControllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.ArticleDTO.ArticleRequest;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.ArticleDTO.ArticleResponse;
import tn.esprit.spring.tpcafeskanderbardaoui.services.Article.IArticleService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/articles")
public class ArticleRestController {

    private final IArticleService articleService;

    // ✅ Get all articles
    @GetMapping
    public List<ArticleResponse> selectAllArticles() {
        return articleService.selectAllArticles();
    }

    // ✅ Get article by ID
    @GetMapping("/{id}")
    public ArticleResponse selectArticleById(@PathVariable long id) {
        return articleService.selectArticleById(id);
    }

    // ✅ Add one article
    @PostMapping
    public ArticleResponse addArticle(@RequestBody ArticleRequest request) {
        return articleService.addArticle(request);
    }

    // ✅ Add multiple articles
    @PostMapping("/batch")
    public List<ArticleResponse> saveArticles(@RequestBody List<ArticleRequest> requests) {
        return articleService.saveArticles(requests);
    }

    // ✅ Delete article by ID
    @DeleteMapping("/{id}")
    public void deleteArticleById(@PathVariable long id) {
        articleService.deleteArticle(id);
    }

    // ✅ Delete all articles
    @DeleteMapping
    public void deleteAllArticles() {
        articleService.deleteAllArticles();
    }

    // ✅ Count all articles
    @GetMapping("/count")
    public long countArticles() {
        return articleService.countingArticles();
    }

    // ✅ Check if article exists by ID
    @GetMapping("/exists/{id}")
    public boolean verifArticleById(@PathVariable long id) {
        return articleService.verifArticleById(id);
    }
}
