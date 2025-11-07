package tn.esprit.spring.tpcafeskanderbardaoui.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "promotion")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPromotion;

    private Double pourcentagePromo;

    private LocalDate dateDebutPromo;

    private LocalDate dateFinPromo;

    // Relation ManyToMany avec Article
    @ManyToMany
    @JoinTable(
            name = "promotion_article",
            joinColumns = @JoinColumn(name = "promotion_id"),
            inverseJoinColumns = @JoinColumn(name = "article_id")
    )
    private List<Article> articles;
}
