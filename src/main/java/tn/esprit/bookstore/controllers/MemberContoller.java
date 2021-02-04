package tn.esprit.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.bookstore.dao.MemberRepository;
import tn.esprit.bookstore.entities.Member;
import tn.esprit.bookstore.entities.Role;
import tn.esprit.bookstore.services.MemberService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin/members")
public class MemberContoller {
    @Autowired
    MemberService memberRepository;

    @GetMapping("/allMembers")
    @PreAuthorize("hasAuthority('Role_Administrator')")
    public ResponseEntity<List<Member>> getAllMembers(){
        List<Member> memberList = memberRepository.retrieveAllMembers();
        if (memberList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(memberList, HttpStatus.OK);
    }

   // @GetMapping("/premiums")
   // @PreAuthorize("hasAuthority('Role_Membre')")
   /* public ResponseEntity<List<Member>> getAllPremiums(@RequestParam(required = false)Role role) {
        try {
            List<Member> premiums = new ArrayList<Member>();

            if (role == null)
              //  memberRepository.findAll().forEach(premiums::add);
            //else
             //   memberRepository.findByRole(role).forEach(premiums::add);

            if (premiums.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(premiums, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/


}
