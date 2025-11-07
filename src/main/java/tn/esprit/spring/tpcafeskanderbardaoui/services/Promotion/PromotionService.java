package tn.esprit.spring.tpcafeskanderbardaoui.services.Promotion;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.PromotionDTO.PromotionRequest;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.PromotionDTO.PromotionResponce;
import tn.esprit.spring.tpcafeskanderbardaoui.entities.Article;
import tn.esprit.spring.tpcafeskanderbardaoui.entities.Promotion;
import tn.esprit.spring.tpcafeskanderbardaoui.mapper.IPromotionMapper;
import tn.esprit.spring.tpcafeskanderbardaoui.repositories.ArticleRepository;
import tn.esprit.spring.tpcafeskanderbardaoui.repositories.PromotionRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PromotionService implements IPromotionService {

    private final PromotionRepository promoRepo;
    private final IPromotionMapper promoMapper;
    private final ArticleRepository articleRepo;

    // ✅ Add one promotion (DTO version)
    @Override
    public PromotionResponce addPromotion(PromotionRequest request) {
        Promotion promotion = promoMapper.toEntity(request);

        // Attach related articles (if provided)
        if (request.getArticleIds() != null && !request.getArticleIds().isEmpty()) {
            List<Article> articles = articleRepo.findAllById(request.getArticleIds());
            promotion.setArticles(articles);
        }

        Promotion saved = promoRepo.save(promotion);
        return promoMapper.toResponse(saved);
    }

    // ✅ Add multiple promotions
    @Override
    public List<PromotionResponce> savePromotions(List<PromotionRequest> requests) {
        List<Promotion> promotions = requests.stream()
                .map(dto -> {
                    Promotion p = promoMapper.toEntity(dto);
                    if (dto.getArticleIds() != null && !dto.getArticleIds().isEmpty()) {
                        List<Article> articles = articleRepo.findAllById(dto.getArticleIds());
                        p.setArticles(articles);
                    }
                    return p;
                })
                .collect(Collectors.toList());

        return promoRepo.saveAll(promotions).stream()
                .map(promoMapper::toResponse)
                .collect(Collectors.toList());
    }

    // ✅ Get one promotion by ID
    @Override
    public PromotionResponce selectPromotionById(long id) {
        Optional<Promotion> promotionOpt = promoRepo.findById(id);
        return promotionOpt.map(promoMapper::toResponse).orElse(null);
    }

    // ✅ Get all promotions
    @Override
    public List<PromotionResponce> selectAllPromotions() {
        return promoRepo.findAll().stream()
                .map(promoMapper::toResponse)
                .collect(Collectors.toList());
    }

    // ✅ Delete one promotion by ID
    @Override
    public void deletePromotionById(long id) {
        promoRepo.deleteById(id);
    }

    // ✅ Delete all promotions
    @Override
    public void deleteAllPromotions() {
        promoRepo.deleteAll();
    }

    // ✅ Count promotions
    @Override
    public long countingPromotions() {
        return promoRepo.count();
    }

    // ✅ Verify if promotion exists
    @Override
    public boolean verifPromotionById(long id) {
        return promoRepo.existsById(id);
    }
}
