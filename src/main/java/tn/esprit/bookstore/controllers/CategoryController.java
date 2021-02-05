package tn.esprit.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.bookstore.entities.Book;
import tn.esprit.bookstore.entities.Category;
import tn.esprit.bookstore.exceptions.ResourceNotFoundException;
import tn.esprit.bookstore.services.CategoryService;
import tn.esprit.bookstore.views.ICategoryService;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

@RestController
@RequestMapping(path = "Category")

public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/getAll")
    public ResponseEntity<?> retrieveAllCategories() {
        try {
            Collection<Category> categories =categoryService.retrieveAllCategories();
            return ResponseEntity.ok(categories);
        }
     catch(Exception e)
     {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
     }
    }

    @PostMapping("/newCategory")
    public ResponseEntity<Category> addCategory(@Valid @RequestBody Category category) throws URISyntaxException {

            Category result = categoryService.addCategory(category);
            return ResponseEntity.created(new URI("/newCategory" + result.getId())).body(result);
        }

    @PutMapping("/updateCategory/{id}")
    public ResponseEntity<?> updateCategory(@Valid @RequestBody Category newCategory, @PathVariable("id") String id) {
        try {
            Category category = categoryService.retrieveCategoryById(id);
            category.setName(newCategory.getName());
            category.setDescription(newCategory.getDescription());
            Category result = categoryService.addCategory(category);
            return ResponseEntity.ok().body(result);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while updating category"+ex.getMessage());
        }
    }

    @DeleteMapping("/removeCategory/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") String id) {
        try {
            categoryService.deleteCategory(id);
            return ResponseEntity.ok().body("Deleted Category with id: "+id);
        }
        catch (Exception ex)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error while deleting category !");
        }
    }


    @GetMapping("/getCategoryByName/{categoryName}")
    public ResponseEntity<?> retrieveCategoryByName( @PathVariable(name="categoryName") String name) {
        List <Category> categories;
        try {
            categories = categoryService.retrieveCategoryByName(name);
            return ResponseEntity.ok().body(categories);
        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().body("Error while retrieveing categories with name :" +name);
        }
    }



}
