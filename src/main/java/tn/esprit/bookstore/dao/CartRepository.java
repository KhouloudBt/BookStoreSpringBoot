package tn.esprit.bookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.bookstore.entities.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
	Cart findById(long id);
}
