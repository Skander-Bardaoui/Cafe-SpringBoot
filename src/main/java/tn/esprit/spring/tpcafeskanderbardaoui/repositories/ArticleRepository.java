package tn.esprit.spring.tpcafeskanderbardaoui.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.tpcafeskanderbardaoui.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
