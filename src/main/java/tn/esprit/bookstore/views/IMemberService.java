package tn.esprit.bookstore.views;


import tn.esprit.bookstore.entities.Member;

import java.util.List;

public interface IMemberService {
    List<Member> retrieveAllMembers();
    void deleteMember(String id);
    Member updateMember(Member u);
    Member retrieveMemberById(String id);
    List<Member> retrieveMemberByRole(String role);
}
