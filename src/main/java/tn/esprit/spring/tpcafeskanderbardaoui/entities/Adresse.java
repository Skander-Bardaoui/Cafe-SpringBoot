package tn.esprit.spring.tpcafeskanderbardaoui.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "adresse")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdresse;

    private String rue;

    private String ville;

    private int codePostal;


    @OneToMany(mappedBy = "adresse")
    private List<Client> clients;
}
