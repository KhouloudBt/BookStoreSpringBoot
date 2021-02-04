package tn.esprit.bookstore.controllers;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tn.esprit.bookstore.dao.MemberRepository;
import tn.esprit.bookstore.dao.RoleRepository;
import tn.esprit.bookstore.entities.ERole;
import tn.esprit.bookstore.entities.Member;
import tn.esprit.bookstore.entities.Role;
import tn.esprit.bookstore.entities.Session;
import tn.esprit.bookstore.payload.request.LoginRequest;
import tn.esprit.bookstore.payload.request.SignupRequest;
import tn.esprit.bookstore.payload.response.JwtResponse;
import tn.esprit.bookstore.security.TokenProvider;
import tn.esprit.bookstore.services.UserDetailsImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth/members")
public class MemberAuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtUtils;

    @Autowired
    private MemberRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        Session.getInstance(userDetails.getUsername());
        System.out.println( Session.getInstance().getUserName());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));

    }

    @GetMapping("/current")
    public Member getCurrentUser(){
       return userRepository.findByUsername(Session.getInstance().getUserName());
    }

    @GetMapping("/currentUserName")
    public String getCurrentUserName(){
        return Session.getInstance().getUserName();
    }

    @PostMapping("/logout")
    public void Logout(){
        Session.getInstance().cleanUserSession();
        System.out.println("user logged out ");
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Username is already taken!");
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Email is already in use!");
        }

        // Create new user's account
        Member user = new Member(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            try{
            Role userRole = roleRepository.findByName(ERole.Role_Membre);
            roles.add(userRole);
            }catch( RuntimeException e ) {
                System.out.println("Error: Role is not found.");}

        } else {
            strRoles.forEach(role -> {
                if ("admin".equals(role)) {
                    try{
                        Role adminRole = roleRepository.findByName(ERole.Role_Administrator);
                        roles.add(adminRole);
                    }catch( RuntimeException e ) {
                        System.out.println("Error: Role is not found.");}
                } else if ("pre".equals(role)) {
                    Role premiumRole = roleRepository.findByName(ERole.Role_premium);
                    //.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(premiumRole);
                } else {
                    Role userRole = roleRepository.findByName(ERole.Role_Membre);
                    //.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok("User registered successfully!");
    }
}
