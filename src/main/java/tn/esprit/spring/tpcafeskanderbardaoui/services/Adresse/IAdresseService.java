package tn.esprit.spring.tpcafeskanderbardaoui.services.Adresse;

import tn.esprit.spring.tpcafeskanderbardaoui.dto.AdresseDTO.AdresseRequest;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.AdresseDTO.AdresseResponse;

import java.util.List;

public interface IAdresseService {

    AdresseResponse addAdresse(AdresseRequest request);

    List<AdresseResponse> saveAdresses(List<AdresseRequest> requests);

    AdresseResponse selectAdresseById(long id);

    List<AdresseResponse> selectAllAdresses();

    void deleteAdresse(long id);

    void deleteAllAdresses();

    long countingAdresses();

    boolean verifAdresseById(long id);
}
