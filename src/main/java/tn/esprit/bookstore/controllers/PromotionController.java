package tn.esprit.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.bookstore.entities.Promition;
import tn.esprit.bookstore.services.PromotionService;

import java.util.List;

@RestController
@RequestMapping(path = "News")
public class PromotionController {
    @Autowired
    private PromotionService proService;

    @GetMapping("/")
    public List<Promition> getPros(){
        return proService.getPromotions();

    }
}
