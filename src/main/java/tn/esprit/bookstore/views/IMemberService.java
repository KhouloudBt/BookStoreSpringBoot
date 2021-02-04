package tn.esprit.bookstore.views;


import org.springframework.security.core.GrantedAuthority;
import tn.esprit.bookstore.entities.Member;

import java.util.Collection;
import java.util.List;

public interface IMemberService {
    List<Member> retrieveAllMembers();
    Member addMember(Member m);
    void deleteMember(String id);
    Member updateMember(Member u);
    Member retrieveMemberById(String id);
    List<Member> retrieveMemberByRole(String role);

    Collection<? extends GrantedAuthority> getAuthorities();
}
