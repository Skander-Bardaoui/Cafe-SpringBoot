package tn.esprit.spring.tpcafeskanderbardaoui.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.ClientDTO.ClientRequest;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.ClientDTO.ClientResponce;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.CarteFideliteDTO.CarteFideliteRequest;
import tn.esprit.spring.tpcafeskanderbardaoui.entities.Client;
import tn.esprit.spring.tpcafeskanderbardaoui.entities.CarteFidelite;

@Mapper(componentModel = "spring")
public interface IClientMapper {

    Client toEntity(ClientRequest request);

    @Mapping(source = "carteFidelite.pointsAcumules", target = "ptsAccumules")
    ClientResponce toResponse(Client client);

    // ✅ Add this method to map CarteFidelite entity to CarteFideliteRequest DTO
    CarteFideliteRequest toCarteFideliteRequest(CarteFidelite carteFidelite);

    // ✅ Add this method to map CarteFideliteRequest DTO to CarteFidelite entity
    CarteFidelite toCarteFideliteEntity(CarteFideliteRequest carteFideliteRequest);
}