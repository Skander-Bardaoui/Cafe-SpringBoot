package tn.esprit.spring.tpcafeskanderbardaoui.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.tpcafeskanderbardaoui.entities.Detail_Commande;

public interface DetailCommandeRepository extends JpaRepository<Detail_Commande, Long> {
}
