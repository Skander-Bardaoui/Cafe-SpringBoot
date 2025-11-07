package tn.esprit.spring.tpcafeskanderbardaoui.services.Detail_Commande;

import tn.esprit.spring.tpcafeskanderbardaoui.dto.DetailCommandeDTO.DetailCommandeRequest;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.DetailCommandeDTO.DetailCommandeResponce;

import java.util.List;

public interface IDetail_CommandeService {

    // ✅ Add one detail commande (from DTO)
    DetailCommandeResponce addDetailCommande(DetailCommandeRequest request);

    // ✅ Add multiple details commande
    List<DetailCommandeResponce> saveDetailsCommande(List<DetailCommandeRequest> requests);

    // ✅ Get one detail commande by ID
    DetailCommandeResponce selectDetailCommandeById(long id);

    // ✅ Get all details commande
    List<DetailCommandeResponce> selectAllDetailsCommande();

    // ✅ Delete one detail commande by ID
    void deleteDetailCommandeById(long id);

    // ✅ Delete all details commande
    void deleteAllDetailsCommande();

    // ✅ Count total details commande
    long countingDetailsCommande();

    // ✅ Verify if a detail commande exists
    boolean verifDetailCommandeById(long id);
}
