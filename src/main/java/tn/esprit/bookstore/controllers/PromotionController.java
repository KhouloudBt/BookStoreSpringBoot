package tn.esprit.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.bookstore.entities.*;
import tn.esprit.bookstore.services.*;

import java.util.List;

@RestController
@RequestMapping(path = "News")
public class PromotionController {
    @Autowired
    private PromotionService proService;
    @Autowired
    private CategoryDesireService categoryDesireService;
    @Autowired
    private WriterDesireService writerDesireService;

    @GetMapping("/promotions")
    public List<Promition> getPros(){
        return proService.getPromotions();

    }
    @GetMapping("/CategoryDesires")
    public List<CategoryDesire> getCats(){
        return categoryDesireService.getCategoryDesires();

    }

    @GetMapping("/WriterDesires")
    public List<WriterDesire> getWriters(){
        return writerDesireService.getWriterDesires();
    }


}
