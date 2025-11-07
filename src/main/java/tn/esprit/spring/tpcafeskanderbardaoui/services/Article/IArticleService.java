package tn.esprit.spring.tpcafeskanderbardaoui.services.Article;

import tn.esprit.spring.tpcafeskanderbardaoui.dto.ArticleDTO.ArticleRequest;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.ArticleDTO.ArticleResponse;

import java.util.List;

public interface IArticleService {

    ArticleResponse addArticle(ArticleRequest request);

    List<ArticleResponse> saveArticles(List<ArticleRequest> requests);

    ArticleResponse selectArticleById(long id);

    List<ArticleResponse> selectAllArticles();

    void deleteArticle(long id);

    void deleteAllArticles();

    long countingArticles();

    boolean verifArticleById(long id);
}
