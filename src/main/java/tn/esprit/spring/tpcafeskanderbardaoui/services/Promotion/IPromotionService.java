package tn.esprit.spring.tpcafeskanderbardaoui.services.Promotion;

import tn.esprit.spring.tpcafeskanderbardaoui.dto.PromotionDTO.PromotionRequest;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.PromotionDTO.PromotionResponce;

import java.util.List;

public interface IPromotionService {

    // ✅ Add one promotion
    PromotionResponce addPromotion(PromotionRequest request);

    // ✅ Add multiple promotions
    List<PromotionResponce> savePromotions(List<PromotionRequest> requests);

    // ✅ Get one promotion by ID
    PromotionResponce selectPromotionById(long id);

    // ✅ Get all promotions
    List<PromotionResponce> selectAllPromotions();

    // ✅ Delete one promotion by ID
    void deletePromotionById(long id);

    // ✅ Delete all promotions
    void deleteAllPromotions();

    // ✅ Count all promotions
    long countingPromotions();

    // ✅ Check if a promotion exists
    boolean verifPromotionById(long id);
}
