package tn.esprit.spring.tpcafeskanderbardaoui.services.Article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.ArticleDTO.ArticleRequest;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.ArticleDTO.ArticleResponse;
import tn.esprit.spring.tpcafeskanderbardaoui.entities.Article;
import tn.esprit.spring.tpcafeskanderbardaoui.mapper.IArticleMapper;
import tn.esprit.spring.tpcafeskanderbardaoui.repositories.ArticleRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleService implements IArticleService {

    private final ArticleRepository articleRepo;
    private final IArticleMapper articleMapper;

    @Override
    public ArticleResponse addArticle(ArticleRequest request) {
        Article article = articleMapper.toEntity(request);
        Article saved = articleRepo.save(article);
        return articleMapper.toResponse(saved);
    }

    @Override
    public List<ArticleResponse> saveArticles(List<ArticleRequest> requests) {
        List<Article> articles = requests.stream()
                .map(articleMapper::toEntity)
                .collect(Collectors.toList());

        List<Article> saved = articleRepo.saveAll(articles);
        return saved.stream()
                .map(articleMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ArticleResponse selectArticleById(long id) {
        return articleRepo.findById(id)
                .map(articleMapper::toResponse)
                .orElseGet(() -> ArticleResponse.builder()
                        .idArticle(null)
                        .nomArticle("default nom")
                        .prixArticle(0.0)
                        .build());
    }

    @Override
    public List<ArticleResponse> selectAllArticles() {
        return articleRepo.findAll().stream()
                .map(articleMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteArticle(long id) {
        articleRepo.deleteById(id);
    }

    @Override
    public void deleteAllArticles() {
        articleRepo.deleteAll();
    }

    @Override
    public long countingArticles() {
        return articleRepo.count();
    }

    @Override
    public boolean verifArticleById(long id) {
        return articleRepo.existsById(id);
    }
}
