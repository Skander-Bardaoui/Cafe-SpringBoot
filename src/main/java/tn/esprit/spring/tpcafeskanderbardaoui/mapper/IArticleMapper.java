package tn.esprit.spring.tpcafeskanderbardaoui.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.ArticleDTO.ArticleRequest;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.ArticleDTO.ArticleResponse;
import tn.esprit.spring.tpcafeskanderbardaoui.entities.Article;

@Mapper(componentModel = "spring") // 🔥 MapStruct auto-generates the implementation
public interface IArticleMapper {

    @Mapping(source = "typeArticle", target = "typeArticle")
    ArticleResponse toResponse(Article article);

    @Mapping(source = "typeArticle", target = "typeArticle")
    Article toEntity(ArticleRequest request);
}
