package tn.esprit.spring.tpcafeskanderbardaoui.services.Client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.ClientDTO.ClientRequest;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.ClientDTO.ClientResponce;
import tn.esprit.spring.tpcafeskanderbardaoui.entities.Client;
import tn.esprit.spring.tpcafeskanderbardaoui.mapper.IClientMapper;
import tn.esprit.spring.tpcafeskanderbardaoui.repositories.ClientRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService implements IClientService {

    private final ClientRepository clientRepo;
    private final IClientMapper clientMapper;

    @Override
    public ClientResponce addClient(ClientRequest request) {
        Client client = clientMapper.toEntity(request);
        Client saved = clientRepo.save(client);
        return clientMapper.toResponse(saved);
    }

    @Override
    public List<ClientResponce> saveClients(List<ClientRequest> requests) {
        List<Client> clients = requests.stream()
                .map(clientMapper::toEntity)
                .collect(Collectors.toList());
        return clientRepo.saveAll(clients).stream()
                .map(clientMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ClientResponce selectClientById(long id) {
        Optional<Client> client = clientRepo.findById(id);
        return client.map(clientMapper::toResponse)
                .orElse(null);
    }

    @Override
    public List<ClientResponce> selectAllClients() {
        return clientRepo.findAll().stream()
                .map(clientMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteClientById(long id) {
        clientRepo.deleteById(id);
    }

    @Override
    public void deleteAllClients() {
        clientRepo.deleteAll();
    }

    @Override
    public long countingClients() {
        return clientRepo.count();
    }

    @Override
    public boolean verifClientById(long id) {
        return clientRepo.existsById(id);
    }
}
