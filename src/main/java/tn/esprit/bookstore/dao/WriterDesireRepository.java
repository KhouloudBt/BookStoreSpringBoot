package tn.esprit.bookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.bookstore.entities.WriterDesire;

@Repository
public interface WriterDesireRepository extends JpaRepository<WriterDesire,Long> {
}
