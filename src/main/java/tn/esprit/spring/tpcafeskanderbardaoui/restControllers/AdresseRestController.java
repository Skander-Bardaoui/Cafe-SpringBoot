package tn.esprit.spring.tpcafeskanderbardaoui.restControllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.AdresseDTO.AdresseRequest;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.AdresseDTO.AdresseResponse;
import tn.esprit.spring.tpcafeskanderbardaoui.services.Adresse.IAdresseService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/adresse")
public class AdresseRestController {

    private final IAdresseService adresseService;

    // ✅ Get all addresses
    @GetMapping
    public List<AdresseResponse> selectAllAdresses() {
        return adresseService.selectAllAdresses();
    }

    // ✅ Get address by ID
    @GetMapping("/{id}")
    public AdresseResponse selectAdresseById(@PathVariable long id) {
        return adresseService.selectAdresseById(id);
    }

    // ✅ Add one address
    @PostMapping
    public AdresseResponse addAdresse(@RequestBody AdresseRequest adresseRequest) {
        return adresseService.addAdresse(adresseRequest);
    }

    // ✅ Add multiple addresses
    @PostMapping("/batch")
    public List<AdresseResponse> saveAdresses(@RequestBody List<AdresseRequest> adresseRequests) {
        return adresseService.saveAdresses(adresseRequests);
    }

    // ✅ Delete by ID
    @DeleteMapping("/{id}")
    public void deleteAdresseById(@PathVariable long id) {
        adresseService.deleteAdresse(id);
    }

    // ✅ Delete all
    @DeleteMapping
    public void deleteAllAdresses() {
        adresseService.deleteAllAdresses();
    }

    // ✅ Count
    @GetMapping("/count")
    public long countAdresses() {
        return adresseService.countingAdresses();
    }

    // ✅ Exists by ID
    @GetMapping("/exists/{id}")
    public boolean verifAdresseById(@PathVariable long id) {
        return adresseService.verifAdresseById(id);
    }
}
