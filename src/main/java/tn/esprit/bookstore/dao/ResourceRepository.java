package tn.esprit.bookstore.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.bookstore.entities.Resource;

@Repository
public interface ResourceRepository extends CrudRepository<Resource,String> {
}
