package tn.esprit.spring.tpcafeskanderbardaoui.mapper;

import org.mapstruct.Mapper;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.ArticleDTO.ArticleRequest;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.ArticleDTO.ArticleResponse;
import tn.esprit.spring.tpcafeskanderbardaoui.entities.Article;

@Mapper(componentModel = "spring") // 🔥 MapStruct auto-generates the implementation
public interface IArticleMapper {
    ArticleResponse toResponse(Article article);
    Article toEntity(ArticleRequest request);
}
