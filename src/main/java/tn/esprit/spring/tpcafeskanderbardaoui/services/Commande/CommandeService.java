package tn.esprit.spring.tpcafeskanderbardaoui.services.Commande;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.CommandeDTO.CommandeRequest;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.CommandeDTO.CommandeResponce;
import tn.esprit.spring.tpcafeskanderbardaoui.entities.Commande;
import tn.esprit.spring.tpcafeskanderbardaoui.mapper.ICommandeMapper;
import tn.esprit.spring.tpcafeskanderbardaoui.repositories.CommandeRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommandeService implements ICommandeService {

    private final CommandeRepository commandeRepo;
    private final ICommandeMapper commandeMapper;

    @Override
    public CommandeResponce addCommande(CommandeRequest request) {
        Commande commande = commandeMapper.toEntity(request);
        Commande saved = commandeRepo.save(commande);
        return commandeMapper.toResponse(saved);
    }

    @Override
    public List<CommandeResponce> saveCommandes(List<CommandeRequest> requests) {
        List<Commande> commandes = requests.stream()
                .map(commandeMapper::toEntity)
                .collect(Collectors.toList());
        return commandeRepo.saveAll(commandes).stream()
                .map(commandeMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CommandeResponce selectCommandeById(long id) {
        Optional<Commande> commande = commandeRepo.findById(id);
        return commande.map(commandeMapper::toResponse)
                .orElse(null);
    }

    @Override
    public List<CommandeResponce> selectAllCommandes() {
        return commandeRepo.findAll().stream()
                .map(commandeMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCommandeById(long id) {
        commandeRepo.deleteById(id);
    }

    @Override
    public void deleteAllCommandes() {
        commandeRepo.deleteAll();
    }

    @Override
    public long countingCommandes() {
        return commandeRepo.count();
    }

    @Override
    public boolean verifCommandeById(long id) {
        return commandeRepo.existsById(id);
    }
}
