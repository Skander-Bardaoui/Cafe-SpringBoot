package tn.esprit.spring.tpcafeskanderbardaoui.services.CarteFidelite;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.CarteFideliteDTO.CarteFideliteRequest;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.CarteFideliteDTO.CarteFideliteResponce;
import tn.esprit.spring.tpcafeskanderbardaoui.entities.CarteFidelite;
import tn.esprit.spring.tpcafeskanderbardaoui.mapper.ICarteFideliteMapper;
import tn.esprit.spring.tpcafeskanderbardaoui.repositories.CarteFideliteRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarteFideliteService implements ICarteFideliteService {

    private final CarteFideliteRepository carteRepo;
    private final ICarteFideliteMapper carteMapper;

    // ✅ Add one CarteFidelite (DTO-based)
    @Override
    public CarteFideliteResponce addCarteFidelite(CarteFideliteRequest request) {
        CarteFidelite carte = carteMapper.toEntity(request);
        CarteFidelite saved = carteRepo.save(carte);
        return carteMapper.toResponse(saved);
    }

    // ✅ Add multiple CarteFidelite (DTO-based)
    @Override
    public List<CarteFideliteResponce> saveCartesFidelite(List<CarteFideliteRequest> requests) {
        List<CarteFidelite> cartes = requests.stream()
                .map(carteMapper::toEntity)
                .collect(Collectors.toList());
        return carteRepo.saveAll(cartes).stream()
                .map(carteMapper::toResponse)
                .collect(Collectors.toList());
    }

    // ✅ Get CarteFidelite by ID
    @Override
    public CarteFideliteResponce selectCarteFideliteById(long id) {
        return carteRepo.findById(id)
                .map(carteMapper::toResponse)
                .orElseGet(() -> CarteFideliteResponce.builder()
                        .idCarteFidelite(0L)
                        .pointsAcumules(0)
                        .dateCreation(null)
                        .build());
    }

    // ✅ Get all CarteFidelite
    @Override
    public List<CarteFideliteResponce> selectAllCartesFidelite() {
        return carteRepo.findAll().stream()
                .map(carteMapper::toResponse)
                .collect(Collectors.toList());
    }

    // ✅ Delete one CarteFidelite by ID
    @Override
    public void deleteCarteFidelite(long id) {
        carteRepo.deleteById(id);
    }

    // ✅ Delete all CarteFidelite
    @Override
    public void deleteAllCartesFidelite() {
        carteRepo.deleteAll();
    }

    // ✅ Count CarteFidelite
    @Override
    public long countingCartesFidelite() {
        return carteRepo.count();
    }

    // ✅ Verify existence by ID
    @Override
    public boolean verifCarteFideliteById(long id) {
        return carteRepo.existsById(id);
    }
}
