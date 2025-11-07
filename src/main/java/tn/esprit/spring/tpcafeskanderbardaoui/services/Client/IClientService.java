package tn.esprit.spring.tpcafeskanderbardaoui.services.Client;

import tn.esprit.spring.tpcafeskanderbardaoui.dto.ClientDTO.ClientRequest;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.ClientDTO.ClientResponce;

import java.util.List;

public interface IClientService {

    ClientResponce addClient(ClientRequest request);

    List<ClientResponce> saveClients(List<ClientRequest> requests);

    ClientResponce selectClientById(long id);

    List<ClientResponce> selectAllClients();

    void deleteClientById(long id);

    void deleteAllClients();

    long countingClients();

    boolean verifClientById(long id);
}
