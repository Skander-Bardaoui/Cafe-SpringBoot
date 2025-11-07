package tn.esprit.spring.tpcafeskanderbardaoui.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.tpcafeskanderbardaoui.entities.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
