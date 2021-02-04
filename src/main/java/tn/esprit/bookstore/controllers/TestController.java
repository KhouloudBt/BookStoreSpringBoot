package tn.esprit.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.bookstore.security.JwtAuthenticationFilter;
import tn.esprit.bookstore.security.TokenProvider;
import tn.esprit.bookstore.services.UserDetailsImpl;

@RestController
@RequestMapping("/api/test")
public class TestController {
    @Autowired
    private TokenProvider token;

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('Role_Membre') or hasAuthority('Role_Membre_premium') or hasAuthority('Role_Administrator')")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/pre")
    @PreAuthorize("hasAuthority('Role_premium')")
    public String moderatorAccess() {
        return "premium Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('Role_Administrator')")
    public String adminAccess() {
        return "Admin Board.";
    }
}
