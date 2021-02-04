package tn.esprit.bookstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.bookstore.dao.RoleRepository;
import tn.esprit.bookstore.entities.ERole;
import tn.esprit.bookstore.entities.Role;
import tn.esprit.bookstore.views.IRoleService;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findByName(ERole name) {
        Role role = roleRepository.findByName(name);
        return role;
    }
}
