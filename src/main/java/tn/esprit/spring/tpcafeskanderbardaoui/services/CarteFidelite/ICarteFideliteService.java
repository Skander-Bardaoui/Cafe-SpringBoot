package tn.esprit.spring.tpcafeskanderbardaoui.services.CarteFidelite;

import tn.esprit.spring.tpcafeskanderbardaoui.dto.CarteFideliteDTO.CarteFideliteRequest;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.CarteFideliteDTO.CarteFideliteResponce;

import java.util.List;

public interface ICarteFideliteService {

    // ✅ Add one loyalty card
    CarteFideliteResponce addCarteFidelite(CarteFideliteRequest request);

    // ✅ Add multiple loyalty cards
    List<CarteFideliteResponce> saveCartesFidelite(List<CarteFideliteRequest> requests);

    // ✅ Get one loyalty card by ID
    CarteFideliteResponce selectCarteFideliteById(long id);

    // ✅ Get all loyalty cards
    List<CarteFideliteResponce> selectAllCartesFidelite();

    // ✅ Delete one loyalty card by ID
    void deleteCarteFidelite(long id);

    // ✅ Delete all loyalty cards
    void deleteAllCartesFidelite();

    // ✅ Count all loyalty cards
    long countingCartesFidelite();

    // ✅ Check if a loyalty card exists by ID
    boolean verifCarteFideliteById(long id);
}
