package tn.esprit.spring.tpcafeskanderbardaoui.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idAdresse;

    String rue;

    String ville;

    private int codePostal;


    @OneToOne(mappedBy = "adresse", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private Client clients;
}
