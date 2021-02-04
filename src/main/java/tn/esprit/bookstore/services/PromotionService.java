package tn.esprit.bookstore.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.bookstore.dao.PromotionRepository;
import tn.esprit.bookstore.entities.Promition;
import tn.esprit.bookstore.views.IPromotionService;

@Service
public class PromotionService implements IPromotionService {

    @Autowired
    PromotionRepository PromotionRep;

    public List<Promition> getPromotions(){
        return PromotionRep.findAll();
    }


    public void deleting(long id) {
        PromotionRep.deleteById(id);
    }

}
