package tn.esprit.spring.tpcafeskanderbardaoui.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.tpcafeskanderbardaoui.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
