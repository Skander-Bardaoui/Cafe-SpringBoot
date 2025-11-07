package tn.esprit.spring.tpcafeskanderbardaoui.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.IterableMapping;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.DetailCommandeDTO.DetailCommandeRequest;
import tn.esprit.spring.tpcafeskanderbardaoui.dto.DetailCommandeDTO.DetailCommandeResponce;
import tn.esprit.spring.tpcafeskanderbardaoui.entities.Detail_Commande;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IDetailCommandeMapper {

    // Map DetailCommandeRequest DTO to entity
    Detail_Commande toEntity(DetailCommandeRequest request);

    // Map DetailCommande entity to DetailCommandeResponce DTO
    @Mapping(source = "article.idArticle", target = "articleId") // map only article ID
    DetailCommandeResponce toResponse(Detail_Commande detailCommande);


}
