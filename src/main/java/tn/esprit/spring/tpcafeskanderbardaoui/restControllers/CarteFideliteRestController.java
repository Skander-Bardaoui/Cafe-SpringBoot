package tn.esprit.spring.tpcafeskanderbardaoui.restControllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.CarteFideliteDTO.CarteFideliteRequest;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.CarteFideliteDTO.CarteFideliteResponce;
import tn.esprit.spring.tpcafeskanderbardaoui.services.CarteFidelite.ICarteFideliteService;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cartes-fidelite")
public class CarteFideliteRestController {

    private final ICarteFideliteService carteFideliteService;

    // ✅ Get all cartes
    @GetMapping
    public List<CarteFideliteResponce> selectAllCartesFidelite() {
        return carteFideliteService.selectAllCartesFidelite();
    }

    // ✅ Get carte by ID
    @GetMapping("/{id}")
    public CarteFideliteResponce selectCarteFideliteById(@PathVariable long id) {
        return carteFideliteService.selectCarteFideliteById(id);
    }

    // ✅ Add one carte
    @PostMapping
    public CarteFideliteResponce addCarteFidelite(@RequestBody CarteFideliteRequest request) {
        return carteFideliteService.addCarteFidelite(request);
    }

    // ✅ Add multiple cartes
    @PostMapping("/batch")
    public List<CarteFideliteResponce> saveCartesFidelite(@RequestBody List<CarteFideliteRequest> requests) {
        return carteFideliteService.saveCartesFidelite(requests);
    }

    // ✅ Delete one carte by ID
    @DeleteMapping("/{id}")
    public void deleteCarteFidelite(@PathVariable long id) {
        carteFideliteService.deleteCarteFidelite(id);
    }

    // ✅ Delete all cartes
    @DeleteMapping
    public void deleteAllCartesFidelite() {
        carteFideliteService.deleteAllCartesFidelite();
    }

    // ✅ Count all cartes
    @GetMapping("/count")
    public long countCartesFidelite() {
        return carteFideliteService.countingCartesFidelite();
    }

    // ✅ Check if carte exists by ID
    @GetMapping("/exists/{id}")
    public boolean verifCarteFideliteById(@PathVariable long id) {
        return carteFideliteService.verifCarteFideliteById(id);
    }
}
