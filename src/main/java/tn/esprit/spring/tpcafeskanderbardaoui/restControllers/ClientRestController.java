package tn.esprit.spring.tpcafeskanderbardaoui.restControllers;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.ClientDTO.ClientRequest;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.ClientDTO.ClientResponce;
import tn.esprit.spring.tpcafeskanderbardaoui.services.Client.IClientService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clients")
public class ClientRestController {

    private final IClientService clientService;

    // =============================
    //        CRUD ENDPOINTS
    // =============================

    @GetMapping
    public List<ClientResponce> selectAllClients() {
        return clientService.selectAllClients();
    }

    @GetMapping("/{id}")
    public ClientResponce selectClientById(@PathVariable long id) {
        return clientService.selectClientById(id);
    }

    @PostMapping
    public ClientResponce addClient(@RequestBody ClientRequest request) {
        return clientService.addClient(request);
    }

    @PostMapping("/batch")
    public List<ClientResponce> saveClients(@RequestBody List<ClientRequest> requests) {
        return clientService.saveClients(requests);
    }

    @DeleteMapping("/{id}")
    public void deleteClientById(@PathVariable long id) {
        clientService.deleteClientById(id);
    }

    @DeleteMapping
    public void deleteAllClients() {
        clientService.deleteAllClients();
    }

    @GetMapping("/count")
    public long countClients() {
        return clientService.countingClients();
    }

    @GetMapping("/exists/{id}")
    public boolean verifClientById(@PathVariable long id) {
        return clientService.verifClientById(id);
    }

    // =============================
    //    JPQL QUERY ENDPOINTS
    // =============================

    // 1. Rechercher par nom
    @GetMapping("/search/nom")
    public List<ClientResponce> findByNom(@RequestParam String nom) {
        return clientService.findClientsByNom(nom);
    }

    // 2. Rechercher par prénom
    @GetMapping("/search/prenom")
    public List<ClientResponce> findByPrenom(@RequestParam String prenom) {
        return clientService.findClientsByPrenom(prenom);
    }

    // 3. Rechercher par nom ET prénom
    @GetMapping("/search/nom-prenom")
    public ResponseEntity<ClientResponce> findByNomAndPrenom(
            @RequestParam String nom,
            @RequestParam String prenom) {
        ClientResponce client = clientService.findClientByNomAndPrenom(nom, prenom);
        return client != null ? ResponseEntity.ok(client) : ResponseEntity.notFound().build();
    }

    // 4. Vérifier si un client existe par nom
    @GetMapping("/exists/nom")
    public boolean existsByNom(@RequestParam String nom) {
        return clientService.existsClientByNom(nom);
    }

    // 5. Compter les clients nés après une date
    @GetMapping("/count/born-after")
    public long countByDateNaissanceAfter(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return clientService.countClientsByDateNaissanceAfter(date);
    }

    // 6. Rechercher par nom OU prénom contenant
    @GetMapping("/search/nom-or-prenom-containing")
    public List<ClientResponce> findByNomOrPrenomContaining(@RequestParam String str) {
        return clientService.findClientsByNomOrPrenomContaining(str);
    }

    // 7. Rechercher par nom ET prénom contenant
    @GetMapping("/search/nom-and-prenom-containing")
    public List<ClientResponce> findByNomAndPrenomContaining(@RequestParam String str) {
        return clientService.findClientsByNomAndPrenomContaining(str);
    }

    // 8. Rechercher par date de naissance entre deux dates
    @GetMapping("/search/born-between")
    public List<ClientResponce> findByDateNaissanceBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return clientService.findClientsByDateNaissanceBetween(start, end);
    }

    // 9. Rechercher par nom commençant par ET né avant
    @GetMapping("/search/nom-starts-born-before")
    public List<ClientResponce> findByNomStartingWithAndDateNaissanceBefore(
            @RequestParam String prefix,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return clientService.findClientsByNomStartingWithAndDateNaissanceBefore(prefix, date);
    }

    // 10. Rechercher par ville
    @GetMapping("/search/ville")
    public List<ClientResponce> findByAdresseVille(@RequestParam String ville) {
        return clientService.findClientsByAdresseVille(ville);
    }

    // 11. Rechercher par nom contenant, triés par prénom ASC
    @GetMapping("/search/nom-containing-sort-asc")
    public List<ClientResponce> findByNomContainingOrderByPrenomAsc(@RequestParam String str) {
        return clientService.findClientsByNomContainingOrderByPrenomAsc(str);
    }

    // 12. Rechercher par nom contenant, triés par prénom DESC
    @GetMapping("/search/nom-containing-sort-desc")
    public List<ClientResponce> findByNomContainingOrderByPrenomDesc(@RequestParam String str) {
        return clientService.findClientsByNomContainingOrderByPrenomDesc(str);
    }

    // 13. Rechercher par nom commençant par
    @GetMapping("/search/nom-starts-with")
    public List<ClientResponce> findByNomStartingWith(@RequestParam String letter) {
        return clientService.findClientsByNomStartingWith(letter);
    }

    // 14. Rechercher par prénom se terminant par
    @GetMapping("/search/prenom-ends-with")
    public List<ClientResponce> findByPrenomEndingWith(@RequestParam String suffix) {
        return clientService.findClientsByPrenomEndingWith(suffix);
    }

    // 15. Clients sans date de naissance
    @GetMapping("/search/no-birthdate")
    public List<ClientResponce> findByDateNaissanceIsNull() {
        return clientService.findClientsByDateNaissanceIsNull();
    }

    // 16. Clients avec adresse renseignée
    @GetMapping("/search/with-address")
    public List<ClientResponce> findByAdresseIsNotNull() {
        return clientService.findClientsByAdresseIsNotNull();
    }

    // 17. Rechercher par plusieurs villes
    @GetMapping("/search/villes")
    public List<ClientResponce> findByAdresseVilleIn(@RequestParam List<String> villes) {
        return clientService.findClientsByAdresseVilleIn(villes);
    }

    // 18. Clients avec points > valeur
    @GetMapping("/search/points-greater-than")
    public List<ClientResponce> findByPtsAccumulesGreaterThan(@RequestParam int pts) {
        return clientService.findClientsByPtsAccumulesGreaterThan(pts);
    }

    // 19. Clients avec points >= valeur
    @GetMapping("/search/points-greater-equal")
    public List<ClientResponce> findByPtsAccumulesGreaterThanOrEqual(@RequestParam int pts) {
        return clientService.findClientsByPtsAccumulesGreaterThanOrEqual(pts);
    }

    // 20. Clients avec points entre deux valeurs
    @GetMapping("/search/points-between")
    public List<ClientResponce> findByPtsAccumulesBetween(
            @RequestParam int min,
            @RequestParam int max) {
        return clientService.findClientsByPtsAccumulesBetween(min, max);
    }

    // 21. Clients ayant commandé un article spécifique
    @GetMapping("/search/by-article")
    public List<ClientResponce> findByCommandeArticleNom(@RequestParam String nomArticle) {
        return clientService.findClientsByCommandeArticleNom(nomArticle);
    }

    // 22. Clients par nom contenant ET type d'article commandé
    @GetMapping("/search/nom-and-article-type")
    public List<ClientResponce> findByNomContainingAndArticleType(
            @RequestParam String nomStr,
            @RequestParam String typeArticle) {
        return clientService.findClientsByNomContainingAndArticleType(nomStr, typeArticle);
    }
}