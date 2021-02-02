package tn.esprit.bookstore.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.bookstore.entities.ArchiveBook;

@Repository
public interface ArchiveBookRepository extends CrudRepository<ArchiveBook, Long>{
}