package tn.esprit.spring.tpcafeskanderbardaoui.dto.ArticleDTO;

import lombok.*;
import tn.esprit.spring.tpcafeskanderbardaoui.entities.TypeArticle;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleRequest {
    private String nomArticle;
    private Double prixArticle;
    private TypeArticle typeArticle;
}
