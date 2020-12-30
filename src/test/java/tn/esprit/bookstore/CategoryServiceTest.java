package tn.esprit.bookstore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.bookstore.entities.Category;
import tn.esprit.bookstore.views.ICategoryService;

import java.util.List;
import java.util.TreeMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    ICategoryService categoryService;

    @Test
    public void AddCategoryTest()
    {
        Category category = new Category("Romance-love", "Books who describe love stories with all their passion, hate, conflict and seprations");
        categoryService.addCategory(category);
        Category category3 = new Category("Action", "Action movies with several thrilling events, may contain violence");
        categoryService.addCategory(category3);
        Category category2 = new Category("Classics", "You may think of these books as the throwback readings you were assigned in English class.");
        categoryService.addCategory(category2);

    }

    @Test
    public void deleteCategoryTest()
    {
        categoryService.deleteCategory("9");

    }

    @Test
    public void retrieveCategoriesToTreeMAp()
    {
        TreeMap<String,String>  treeMap= categoryService.retrieveCategoriesToTreeMAp();
        System.out.println(treeMap);

    }

    @Test
    public void retrieveCategoryByName()
    {
        List list1=categoryService.retrieveCategoryByName("Action");
        System.out.println(list1);
        categoryService.retrieveCategoryByName("Horror");

    }

}
