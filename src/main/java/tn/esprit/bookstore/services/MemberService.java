package tn.esprit.bookstore.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.bookstore.dao.MemberRepository;
import tn.esprit.bookstore.entities.Category;
import tn.esprit.bookstore.entities.Member;
import tn.esprit.bookstore.views.IMemberService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class MemberService implements IMemberService {

    @Autowired
    MemberRepository memberRepository;

    private final Logger logger = LoggerFactory.getLogger(MemberService.class);


    @Override
    public List<Member> retrieveAllMembers() {
        List<Member> memberList = new ArrayList<>();
        memberRepository.findAll().forEach(memberList::add);
        logger.info("all members");
        return memberList;
    }

    @Override
    public Member addMember(Member m) {
        return memberRepository.save(m);
    }

    @Override
    public void deleteMember(String id) {
        memberRepository.deleteById(Long.parseLong(id));
    }

    @Override
    public Member updateMember(Member u) {

        return null;
    }



    @Override
    public Member retrieveMemberById(String id) {
       // memberRepository.existsById(Long.parseLong(id));
       Optional<Member> mb = memberRepository.findById(Long.parseLong(id));
       if(mb.get()==null)
           logger.error("this "+id+"dose not exist");
       else
           logger.info("the member is :" + mb.get());
       return mb.get();
    }

    @Override
    public List<Member> retrieveMemberByRole(String role) {
        List<Member> mb = this.retrieveAllMembers().stream()
               .filter(member -> member.getRole().toString().contains(role))
                .collect(Collectors.toList());
        if (mb==null)
            logger.warn("this member doesn't exist !");
        else
            logger.info("retrieved member: "+mb);
        return mb;

    }
}
