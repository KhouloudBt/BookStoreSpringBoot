package tn.esprit.bookstore.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.bookstore.dao.CategoryRepository;
import tn.esprit.bookstore.entities.Category;
import tn.esprit.bookstore.utilities.RegexTests;
import tn.esprit.bookstore.views.ICategoryService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    private static final Logger logger = Logger.getLogger(CategoryService.class);



    @Override
    public List<Category> retrieveAllCategories() {
        List<Category> categories = new ArrayList<Category>();
        categoryRepository.findAll().forEach(categories::add);
        logger.info("Categories found with findAll():");
        logger.info("-------------------------------");
        logger.info(categories);
        return categories;
    }

    @Override
    public TreeMap<String, String> retrieveCategoriesToTreeMAp() {

        TreeMap<String, String>  treemap= new TreeMap<String,String>((c1,c2)->c1.compareTo(c2));
        for (Category category: retrieveAllCategories())
        {
            treemap.put(category.getName(), category.getDescription());
        }
        logger.info("Categories retirieved to a treemap <Name,Description>:");
        logger.info("-------------------------------");
        logger.info(treemap);
        return treemap;
    }

    @Override
    public Category addCategory(Category category) {
        if ((RegexTests.isAvalidCategory(category.getName())) && (categoryNameDoesntExist(category.getName()))) {
            logger.info("Adding Category " + category);
            return categoryRepository.save(category);
        }
        else
        {
           logger.warn("Invalid category name: " + category.getName());
            return null;

        }

    }

    @Override
    public void deleteCategory(String id) {
        Category category = retrieveCategoryById(id);
        if (category!=null) {
            categoryRepository.delete(category);
            logger.info("-------------------------------");
            logger.info("Deleted category  " + category);
        }
        else logger.warn("Couldn't find category with id "+ id );

    }

    @Override
    public Category updateCategory(Category u) {
        return null;

    }

    @Override
    public Category retrieveCategoryById(String id) {
        Optional<Category> cat= categoryRepository.findById(Long.parseLong(id));
        if (cat.get() ==null)
        logger.warn("Couldn't find category with id "+ id );
        else logger.info("Retrieved category "+cat.get());
        return cat.get();
    }

    @Override
    public List<Category> retrieveCategoryByName(String name) {
       List<Category> cat = this.retrieveAllCategories().stream()
               .filter(c->c.getName().toUpperCase().contains(name.toUpperCase()))
               .collect(Collectors.toList());
       if (cat==null)
        logger.warn("Couldn't find category with name "+ name );
       else
           logger.info("retrieved categories: "+cat);
       return cat;

    }

    @Override
    public boolean categoryNameDoesntExist(String name) {
        return this.retrieveAllCategories().stream()
                .map(c->c.getName().toUpperCase())
                .noneMatch(c->c.equals(name.toUpperCase()));
    }

}
