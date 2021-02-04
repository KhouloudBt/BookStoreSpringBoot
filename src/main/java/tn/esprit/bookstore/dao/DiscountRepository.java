package tn.esprit.bookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.bookstore.entities.Discount;

@Repository
public interface DiscountRepository extends JpaRepository<Discount,Long> {
}
