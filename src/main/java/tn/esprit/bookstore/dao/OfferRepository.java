package tn.esprit.bookstore.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.bookstore.entities.Offer;
@Repository
public interface OfferRepository extends CrudRepository<Offer,Long> {
}
