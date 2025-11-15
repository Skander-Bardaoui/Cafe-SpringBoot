package tn.esprit.spring.tpcafeskanderbardaoui.services.Client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.ClientDTO.ClientRequest;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.ClientDTO.ClientResponce;
import tn.esprit.spring.tpcafeskanderbardaoui.entities.Client;
import tn.esprit.spring.tpcafeskanderbardaoui.mapper.IClientMapper;
import tn.esprit.spring.tpcafeskanderbardaoui.repositories.ClientRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService implements IClientService {

    private final ClientRepository clientRepo;
    private final IClientMapper clientMapper;

    // =============================
    //        CRUD METHODS
    // =============================

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
        return client.map(clientMapper::toResponse).orElse(null);
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

    // =============================
    //    JPQL QUERY METHODS
    // =============================

    @Override
    public List<ClientResponce> findClientsByNom(String nom) {
        return clientRepo.findByNom(nom)
                .stream()
                .map(clientMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientResponce> findClientsByPrenom(String prenom) {
        return clientRepo.findByPrenom(prenom)
                .stream()
                .map(clientMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ClientResponce findClientByNomAndPrenom(String nom, String prenom) {
        Client client = clientRepo.findByNomAndPrenom(nom, prenom);
        return client != null ? clientMapper.toResponse(client) : null;
    }

    @Override
    public boolean existsClientByNom(String nom) {
        return clientRepo.existsByNom(nom);
    }

    @Override
    public long countClientsByDateNaissanceAfter(LocalDate date) {
        return clientRepo.countByDateNaissanceAfter(date);
    }

    @Override
    public List<ClientResponce> findClientsByNomOrPrenomContaining(String str) {
        return clientRepo.findByNomOrPrenomContaining(str)
                .stream()
                .map(clientMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientResponce> findClientsByNomAndPrenomContaining(String str) {
        return clientRepo.findByNomAndPrenomContaining(str)
                .stream()
                .map(clientMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientResponce> findClientsByDateNaissanceBetween(LocalDate start, LocalDate end) {
        return clientRepo.findByDateNaissanceBetween(start, end)
                .stream()
                .map(clientMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientResponce> findClientsByNomStartingWithAndDateNaissanceBefore(String prefix, LocalDate date) {
        return clientRepo.findByNomStartingWithAndDateNaissanceBefore(prefix, date)
                .stream()
                .map(clientMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientResponce> findClientsByAdresseVille(String ville) {
        return clientRepo.findByAdresseVille(ville)
                .stream()
                .map(clientMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientResponce> findClientsByNomContainingOrderByPrenomAsc(String str) {
        return clientRepo.findByNomContainingOrderByPrenomAsc(str)
                .stream()
                .map(clientMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientResponce> findClientsByNomContainingOrderByPrenomDesc(String str) {
        return clientRepo.findByNomContainingOrderByPrenomDesc(str)
                .stream()
                .map(clientMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientResponce> findClientsByNomStartingWith(String letter) {
        return clientRepo.findByNomStartingWith(letter)
                .stream()
                .map(clientMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientResponce> findClientsByPrenomEndingWith(String suffix) {
        return clientRepo.findByPrenomEndingWith(suffix)
                .stream()
                .map(clientMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientResponce> findClientsByDateNaissanceIsNull() {
        return clientRepo.findByDateNaissanceIsNull()
                .stream()
                .map(clientMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientResponce> findClientsByAdresseIsNotNull() {
        return clientRepo.findByAdresseIsNotNull()
                .stream()
                .map(clientMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientResponce> findClientsByAdresseVilleIn(List<String> villes) {
        return clientRepo.findByAdresseVilleIn(villes)
                .stream()
                .map(clientMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientResponce> findClientsByPtsAccumulesGreaterThan(int pts) {
        return clientRepo.findByPtsAccumulesGreaterThan(pts)
                .stream()
                .map(clientMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientResponce> findClientsByPtsAccumulesGreaterThanOrEqual(int pts) {
        return clientRepo.findByPtsAccumulesGreaterThanOrEqual(pts)
                .stream()
                .map(clientMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientResponce> findClientsByPtsAccumulesBetween(int min, int max) {
        return clientRepo.findByPtsAccumulesBetween(min, max)
                .stream()
                .map(clientMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientResponce> findClientsByCommandeArticleNom(String nomArticle) {
        return clientRepo.findByCommandeArticleNom(nomArticle)
                .stream()
                .map(clientMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientResponce> findClientsByNomContainingAndArticleType(String nomStr, String typeArticle) {
        return clientRepo.findByNomContainingAndArticleType(nomStr, typeArticle)
                .stream()
                .map(clientMapper::toResponse)
                .collect(Collectors.toList());
    }
}