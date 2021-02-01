package tn.esprit.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.bookstore.entities.Book;
import tn.esprit.bookstore.entities.Category;
import tn.esprit.bookstore.exceptions.ResourceNotFoundException;
import tn.esprit.bookstore.services.CategoryService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "Category")

public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/getAll")
    public ResponseEntity<Collection<Category>> retrieveAllCategories() {
        Collection<Category> categories =categoryService.retrieveAllCategories();
        return ResponseEntity.ok(categories);
    }


    @PostMapping("/newCategory")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) throws URISyntaxException {
        Category result = categoryService.addCategory(category);
        return ResponseEntity.created(new URI("/newCategory" + result.getId())).body(result);
    }


   /*@DeleteMapping("/deleteCategories/{id}")
    public Map<String, Boolean> deleteCategory(@PathVariable(value = "id") String id)
            throws ResourceNotFoundException {
        Optional<Category> category = categoryService.retrieveCategoryById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

        categoryService.deleteCategory(category.get());
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }*/

}
