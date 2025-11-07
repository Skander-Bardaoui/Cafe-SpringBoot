package tn.esprit.spring.tpcafeskanderbardaoui.dto.DetailCommandeDTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetailCommandeResponce {
    private Long idDetailCommande;
    private Integer quantiteArticle;
    private Double sousTotalDetailArticle;
    private Double sousTotalDetailArticleApresPromo;

    private Long articleId; // instead of full Article object
}
