package tn.esprit.spring.tpcafeskanderbardaoui.dto.ArticleDTO;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import tn.esprit.spring.tpcafeskanderbardaoui.entities.TypeArticle;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleResponse {
    private Long idArticle;
    private String nomArticle;
    private Double prixArticle;
    private TypeArticle typeArticle;

}
