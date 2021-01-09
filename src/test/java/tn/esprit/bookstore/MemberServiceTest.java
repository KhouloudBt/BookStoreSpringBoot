package tn.esprit.bookstore;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.bookstore.entities.Member;
import tn.esprit.bookstore.entities.Role;
import tn.esprit.bookstore.views.IMemberService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberServiceTest {
    @Autowired
    IMemberService memberService;

    public void addMember(){
        Member m = new Member("Khouloud","benTaoues","mail@khouloud.tn","pwd1236","12365478",Role.Administrator);
        memberService.addMember(m);
    }



}
