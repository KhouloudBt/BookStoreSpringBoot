package tn.esprit.bookstore.dao;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.bookstore.entities.BookImage;

public interface BookImageRepository extends CrudRepository<BookImage,String> {
}
