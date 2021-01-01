package tn.esprit.bookstore.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.bookstore.entities.Member;

@Repository
public interface MemberRepository extends CrudRepository<Member,Long> {
}
