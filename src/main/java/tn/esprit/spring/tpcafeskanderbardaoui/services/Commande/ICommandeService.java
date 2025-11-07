package tn.esprit.spring.tpcafeskanderbardaoui.services.Commande;

import tn.esprit.spring.tpcafeskanderbardaoui.dto.CommandeDTO.CommandeRequest;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.CommandeDTO.CommandeResponce;

import java.util.List;

public interface ICommandeService {

    // ✅ Add one commande (from DTO)
    CommandeResponce addCommande(CommandeRequest request);

    // ✅ Add multiple commandes
    List<CommandeResponce> saveCommandes(List<CommandeRequest> requests);

    // ✅ Get one commande by ID
    CommandeResponce selectCommandeById(long id);

    // ✅ Get all commandes
    List<CommandeResponce> selectAllCommandes();

    // ✅ Delete one commande by ID
    void deleteCommandeById(long id);

    // ✅ Delete all commandes
    void deleteAllCommandes();

    // ✅ Count total commandes
    long countingCommandes();

    // ✅ Verify if a commande exists
    boolean verifCommandeById(long id);
}
