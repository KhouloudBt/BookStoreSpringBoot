package tn.esprit.bookstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.bookstore.dao.CategoryDesireRepository;
import tn.esprit.bookstore.entities.CategoryDesire;

import java.util.List;

    @Service
    public class CategoryDesireService {

        @Autowired
        CategoryDesireRepository CategoryDesireRep;

        public List<CategoryDesire> getCategoryDesires(){
            return CategoryDesireRep.findAll();
        }


        public void deleting(long id) {
            CategoryDesireRep.deleteById(id);
        }

    }
