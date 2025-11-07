package tn.esprit.spring.tpcafeskanderbardaoui.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.tpcafeskanderbardaoui.entities.Adresse;

public interface AdresseRepository extends JpaRepository<Adresse, Long> {
    // Optional custom queries can be added here later
}
