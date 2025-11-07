package tn.esprit.spring.tpcafeskanderbardaoui.services.Detail_Commande;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.DetailCommandeDTO.DetailCommandeRequest;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.DetailCommandeDTO.DetailCommandeResponce;
import tn.esprit.spring.tpcafeskanderbardaoui.entities.Detail_Commande;
import tn.esprit.spring.tpcafeskanderbardaoui.mapper.IDetailCommandeMapper;
import tn.esprit.spring.tpcafeskanderbardaoui.repositories.DetailCommandeRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class Detail_CommandeService implements IDetail_CommandeService {

    private final DetailCommandeRepository detailRepo;
    private final IDetailCommandeMapper detailMapper;

    // ✅ Add one detail commande
    @Override
    public DetailCommandeResponce addDetailCommande(DetailCommandeRequest request) {
        Detail_Commande detail = detailMapper.toEntity(request);
        Detail_Commande saved = detailRepo.save(detail);
        return detailMapper.toResponse(saved);
    }

    // ✅ Add multiple details commande
    @Override
    public List<DetailCommandeResponce> saveDetailsCommande(List<DetailCommandeRequest> requests) {
        List<Detail_Commande> details = requests.stream()
                .map(detailMapper::toEntity)
                .collect(Collectors.toList());

        return detailRepo.saveAll(details).stream()
                .map(detailMapper::toResponse)
                .collect(Collectors.toList());
    }

    // ✅ Get one detail commande by ID
    @Override
    public DetailCommandeResponce selectDetailCommandeById(long id) {
        Optional<Detail_Commande> detailOpt = detailRepo.findById(id);
        return detailOpt.map(detailMapper::toResponse).orElse(null);
    }

    // ✅ Get all details commande
    @Override
    public List<DetailCommandeResponce> selectAllDetailsCommande() {
        return detailRepo.findAll().stream()
                .map(detailMapper::toResponse)
                .collect(Collectors.toList());
    }

    // ✅ Delete one detail commande by ID
    @Override
    public void deleteDetailCommandeById(long id) {
        detailRepo.deleteById(id);
    }

    // ✅ Delete all details commande
    @Override
    public void deleteAllDetailsCommande() {
        detailRepo.deleteAll();
    }

    // ✅ Count total details commande
    @Override
    public long countingDetailsCommande() {
        return detailRepo.count();
    }

    // ✅ Verify if a detail commande exists
    @Override
    public boolean verifDetailCommandeById(long id) {
        return detailRepo.existsById(id);
    }
}
