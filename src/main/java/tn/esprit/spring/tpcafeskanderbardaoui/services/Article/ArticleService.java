package tn.esprit.spring.tpcafeskanderbardaoui.services.Article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.ArticleDTO.ArticleRequest;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.ArticleDTO.ArticleResponse;
import tn.esprit.spring.tpcafeskanderbardaoui.entities.Article;
import tn.esprit.spring.tpcafeskanderbardaoui.entities.TypeArticle;
import tn.esprit.spring.tpcafeskanderbardaoui.mapper.IArticleMapper;
import tn.esprit.spring.tpcafeskanderbardaoui.repositories.ArticleRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleService implements IArticleService {

    private final ArticleRepository articleRepo;
    private final IArticleMapper articleMapper;

    // =============================
    //        CRUD METHODS
    // =============================

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
        return articleRepo.saveAll(articles).stream()
                .map(articleMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ArticleResponse selectArticleById(long id) {
        Optional<Article> article = articleRepo.findById(id);
        return article.map(articleMapper::toResponse).orElse(null);
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

    // =============================
    //    JPQL QUERY METHODS
    // =============================

    @Override
    public List<ArticleResponse> findByNomArticleExact(String nom) {
        return articleRepo.findByNomArticleExact(nom).stream()
                .map(articleMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleResponse> findByTypeArticle(TypeArticle type) {
        return articleRepo.findByTypeArticle(type).stream()
                .map(articleMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleResponse> findByPrixArticleExact(Double prix) {
        return articleRepo.findByPrixArticleExact(prix).stream()
                .map(articleMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public boolean existsByNomArticle(String nom) {
        return articleRepo.existsByNomArticle(nom);
    }

    @Override
    public long countByTypeArticle(TypeArticle type) {
        return articleRepo.countByTypeArticle(type);
    }

    @Override
    public List<ArticleResponse> findByNomContainingAndType(String mot, TypeArticle type) {
        return articleRepo.findByNomContainingAndType(mot, type).stream()
                .map(articleMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleResponse> findByPrixInRangeAndTypeIn(Double minPrix, Double maxPrix, List<TypeArticle> types) {
        return articleRepo.findByPrixInRangeAndTypeIn(minPrix, maxPrix, types).stream()
                .map(articleMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleResponse> findByNomStartingWithIgnoreCaseOrderByPrix(String prefix) {
        return articleRepo.findByNomStartingWithIgnoreCaseOrderByPrix(prefix).stream()
                .map(articleMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleResponse> findByTypeAndPrixLessThanEqual(TypeArticle type, Double maxPrix) {
        return articleRepo.findByTypeAndPrixLessThanEqual(type, maxPrix).stream()
                .map(articleMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleResponse> findByNomOrTypeOrderByPrixDesc(String nom, TypeArticle type) {
        return articleRepo.findByNomOrTypeOrderByPrixDesc(nom, type).stream()
                .map(articleMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleResponse> findByNomStartingWith(String prefix) {
        return articleRepo.findByNomStartingWith(prefix).stream()
                .map(articleMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleResponse> findByNomEndingWith(String suffix) {
        return articleRepo.findByNomEndingWith(suffix).stream()
                .map(articleMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleResponse> findByTypeArticleIsNull() {
        return articleRepo.findByTypeArticleIsNull().stream()
                .map(articleMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleResponse> findByPrixArticleIsNotNull() {
        return articleRepo.findByPrixArticleIsNotNull().stream()
                .map(articleMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleResponse> findArticlesWithActivePromotions() {
        return articleRepo.findArticlesWithActivePromotions().stream()
                .map(articleMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleResponse> findByNomContainingAndPrixBetween(String nom, Double minPrix, Double maxPrix) {
        return articleRepo.findByNomContainingAndPrixBetween(nom, minPrix, maxPrix).stream()
                .map(articleMapper::toResponse)
                .collect(Collectors.toList());
    }
}