package tn.esprit.bookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.bookstore.entities.CategoryDesire;

@Repository
public interface CategoryDesireRepository extends JpaRepository<CategoryDesire,Long> {
}
