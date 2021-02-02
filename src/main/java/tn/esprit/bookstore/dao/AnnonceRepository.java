package tn.esprit.bookstore.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.bookstore.entities.Annonce;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce,Long> {
    Annonce findById(long id);
    List<Annonce> findByEtat(boolean b);
    @Query(
            value = "SELECT * FROM Annonce",
            nativeQuery = true)
    List<Annonce> findAllAnnonce();

}
