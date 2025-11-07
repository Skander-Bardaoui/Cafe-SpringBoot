package tn.esprit.spring.tpcafeskanderbardaoui.restControllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.PromotionDTO.PromotionRequest;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.PromotionDTO.PromotionResponce;
import tn.esprit.spring.tpcafeskanderbardaoui.services.Promotion.PromotionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/promotions")
public class PromotionRestController {

    private final PromotionService promotionService;

    // ✅ Add one promotion
    @PostMapping
    public PromotionResponce addPromotion(@RequestBody PromotionRequest request) {
        return promotionService.addPromotion(request);
    }

    // ✅ Add multiple promotions
    @PostMapping("/batch")
    public List<PromotionResponce> savePromotions(@RequestBody List<PromotionRequest> requests) {
        return promotionService.savePromotions(requests);
    }

    // ✅ Get all promotions
    @GetMapping
    public List<PromotionResponce> selectAllPromotions() {
        return promotionService.selectAllPromotions();
    }

    // ✅ Get promotion by ID
    @GetMapping("/{id}")
    public PromotionResponce selectPromotionById(@PathVariable long id) {
        return promotionService.selectPromotionById(id);
    }

    // ✅ Delete promotion by ID
    @DeleteMapping("/{id}")
    public void deletePromotionById(@PathVariable long id) {
        promotionService.deletePromotionById(id);
    }

    // ✅ Delete all promotions
    @DeleteMapping("/all")
    public void deleteAllPromotions() {
        promotionService.deleteAllPromotions();
    }

    // ✅ Count promotions
    @GetMapping("/count")
    public long countPromotions() {
        return promotionService.countingPromotions();
    }

    // ✅ Check if promotion exists
    @GetMapping("/exists/{id}")
    public boolean verifPromotionById(@PathVariable long id) {
        return promotionService.verifPromotionById(id);
    }
}
