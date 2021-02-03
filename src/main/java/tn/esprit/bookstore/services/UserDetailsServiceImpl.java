package tn.esprit.bookstore.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.bookstore.dao.MemberRepository;
import tn.esprit.bookstore.entities.Member;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	MemberRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username)  {
		try {
			Member user = userRepository.findByUsername(username);
			return UserDetailsImpl.build(user);
		}catch(UsernameNotFoundException e){
			System.out.println("User Not Found with username: " + username);
		}


		return null;
	}

}
