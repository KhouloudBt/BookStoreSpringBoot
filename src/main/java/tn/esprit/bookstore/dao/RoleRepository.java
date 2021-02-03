package tn.esprit.bookstore.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.bookstore.entities.ERole;
import tn.esprit.bookstore.entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(ERole name);
}
