package tn.esprit.spring.tpcafeskanderbardaoui.mapper;

import org.mapstruct.Mapper;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.ClientDTO.ClientRequest;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.ClientDTO.ClientResponce;
import tn.esprit.spring.tpcafeskanderbardaoui.entities.Client;

@Mapper(componentModel = "spring")
public interface IClientMapper {
    Client toEntity(ClientRequest request);
    ClientResponce toResponse(Client client);
}
