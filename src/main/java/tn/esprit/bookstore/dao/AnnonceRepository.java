package tn.esprit.bookstore.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    Page<Annonce> findAll(Pageable p);

    @Query(
            value = "SELECT * FROM Annonce where DATE(date_debut)=CURDATE()\n",
            nativeQuery = true)
    List<Annonce> findNewAnnonce();

    @Query(
            value = "SELECT * FROM Annonce where DATE(date_debut)<=CURDATE() and CURDATE()<=DATE(date_debut) and etat=true\n",
            nativeQuery = true)
    List<Annonce> findDispo();

}
