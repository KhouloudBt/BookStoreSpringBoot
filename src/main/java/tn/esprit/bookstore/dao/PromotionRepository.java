package tn.esprit.bookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.bookstore.entities.Promition;

@Repository
public interface PromotionRepository extends JpaRepository<Promition,Long> {
}
