package tn.esprit.bookstore.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.bookstore.entities.Member;
import tn.esprit.bookstore.entities.Role;

import java.util.List;

@Repository
public interface MemberRepository extends CrudRepository<Member,Long> {
    Member findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

    //List<Member> findByRole(Role role);
}
