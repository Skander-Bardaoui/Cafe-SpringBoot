package tn.esprit.spring.tpcafeskanderbardaoui.restControllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.CommandeDTO.CommandeRequest;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.CommandeDTO.CommandeResponce;
import tn.esprit.spring.tpcafeskanderbardaoui.services.Commande.ICommandeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/commandes")
public class CommandeRestController {

    private final ICommandeService commandeService;

    // ✅ Get all commandes
    @GetMapping
    public List<CommandeResponce> selectAllCommandes() {
        return commandeService.selectAllCommandes();
    }

    // ✅ Get commande by ID
    @GetMapping("/{id}")
    public CommandeResponce selectCommandeById(@PathVariable long id) {
        return commandeService.selectCommandeById(id);
    }

    // ✅ Add one commande
    @PostMapping
    public CommandeResponce addCommande(@RequestBody CommandeRequest request) {
        return commandeService.addCommande(request);
    }

    // ✅ Add multiple commandes
    @PostMapping("/batch")
    public List<CommandeResponce> saveCommandes(@RequestBody List<CommandeRequest> requests) {
        return commandeService.saveCommandes(requests);
    }

    // ✅ Delete commande by ID
    @DeleteMapping("/{id}")
    public void deleteCommandeById(@PathVariable long id) {
        commandeService.deleteCommandeById(id);
    }

    // ✅ Delete all commandes
    @DeleteMapping
    public void deleteAllCommandes() {
        commandeService.deleteAllCommandes();
    }

    // ✅ Count all commandes
    @GetMapping("/count")
    public long countCommandes() {
        return commandeService.countingCommandes();
    }

    // ✅ Check if commande exists by ID
    @GetMapping("/exists/{id}")
    public boolean verifCommandeById(@PathVariable long id) {
        return commandeService.verifCommandeById(id);
    }
}
