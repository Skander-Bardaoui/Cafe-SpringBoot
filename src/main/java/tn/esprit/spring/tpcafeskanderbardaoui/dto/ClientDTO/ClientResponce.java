package tn.esprit.spring.tpcafeskanderbardaoui.dto.ClientDTO;

import lombok.*;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.AdresseDTO.AdresseRequest;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientResponce {
    private Long idClient;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;

}
