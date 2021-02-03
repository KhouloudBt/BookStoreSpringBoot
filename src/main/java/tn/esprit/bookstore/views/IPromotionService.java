package tn.esprit.bookstore.views;

import tn.esprit.bookstore.entities.Promition;

import java.util.List;

public interface IPromotionService {

    public List<Promition> getPromotions();
    public void deleting(long id);
}
