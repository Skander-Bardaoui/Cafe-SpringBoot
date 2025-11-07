package tn.esprit.spring.tpcafeskanderbardaoui.dto.DetailCommandeDTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetailCommandeRequest {
    private Long idDetailCommande;
    private Integer quantiteArticle;

}
