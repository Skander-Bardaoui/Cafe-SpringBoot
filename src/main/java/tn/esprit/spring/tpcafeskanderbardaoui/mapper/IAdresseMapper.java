package tn.esprit.spring.tpcafeskanderbardaoui.mapper;

import org.mapstruct.Mapper;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.AdresseDTO.AdresseRequest;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.AdresseDTO.AdresseResponse;
import tn.esprit.spring.tpcafeskanderbardaoui.entities.Adresse;

@Mapper(componentModel = "spring")
public interface IAdresseMapper {
    Adresse toEntity(AdresseRequest request);
    AdresseResponse toResponse(Adresse adresse);
}
