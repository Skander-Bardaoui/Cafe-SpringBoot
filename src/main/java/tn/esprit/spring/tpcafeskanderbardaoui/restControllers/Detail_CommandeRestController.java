package tn.esprit.spring.tpcafeskanderbardaoui.restControllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.DetailCommandeDTO.DetailCommandeRequest;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.DetailCommandeDTO.DetailCommandeResponce;
import tn.esprit.spring.tpcafeskanderbardaoui.services.Detail_Commande.Detail_CommandeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/detail-commandes")
public class Detail_CommandeRestController {

    private final Detail_CommandeService detailService;

    // ✅ Get all detail commandes
    @GetMapping
    public List<DetailCommandeResponce> getAllDetails() {
        return detailService.selectAllDetailsCommande();
    }

    // ✅ Get detail commande by ID
    @GetMapping("/{id}")
    public DetailCommandeResponce getDetailById(@PathVariable long id) {
        return detailService.selectDetailCommandeById(id);
    }

    // ✅ Add one detail commande
    @PostMapping
    public DetailCommandeResponce addDetail(@RequestBody DetailCommandeRequest request) {
        return detailService.addDetailCommande(request);
    }

    // ✅ Add multiple detail commandes
    @PostMapping("/batch")
    public List<DetailCommandeResponce> addDetailsBatch(@RequestBody List<DetailCommandeRequest> requests) {
        return detailService.saveDetailsCommande(requests);
    }

    // ✅ Delete detail commande by ID
    @DeleteMapping("/{id}")
    public void deleteDetailById(@PathVariable long id) {
        detailService.deleteDetailCommandeById(id);
    }

    // ✅ Delete all detail commandes
    @DeleteMapping
    public void deleteAllDetails() {
        detailService.deleteAllDetailsCommande();
    }

    // ✅ Count all detail commandes
    @GetMapping("/count")
    public long countDetails() {
        return detailService.countingDetailsCommande();
    }

    // ✅ Check if detail commande exists by ID
    @GetMapping("/exists/{id}")
    public boolean existsById(@PathVariable long id) {
        return detailService.verifDetailCommandeById(id);
    }
}
