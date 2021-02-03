package tn.esprit.bookstore.views;

import tn.esprit.bookstore.entities.ERole;
import tn.esprit.bookstore.entities.Role;

public interface IRoleService {
    Role findByName(ERole name);
}
