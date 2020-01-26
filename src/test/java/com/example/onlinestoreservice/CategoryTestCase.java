package com.example.onlinestoreservice;

import com.example.onlinestoreservice.dao.ICategoryDAO;
import com.example.onlinestoreservice.daoimpl.CategoryDAO;
import com.example.onlinestoreservice.dto.Category;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.junit.Assert.*;

public class CategoryTestCase {

    private static ICategoryDAO categoryDAO;

    @BeforeClass
    public static void init(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.example.*");
        context.refresh();
        categoryDAO = context.getBean("categoryDAO" , ICategoryDAO.class);
    }

  /*  @Test
    public void testAddCategory(){
        Category category = new Category();
        category.setName("Monitor");
        category.setDescription("this is just a test of category");
        category.setImageURL("https://www.cbronline.com/wp-content/uploads/2016/06/what-is-URL-770x503.jpg");
        boolean result = categoryDAO.add(category);

        assertEquals("Successfully added a category inside the table!" , true, result);
    }*/

    @Test
    public void testGetCategory(){
        Category category = categoryDAO.get(1);
        assertEquals("Successfully fetched a category from the table!" , "Home Appliance", category.getName());
    }

    @Test
    public void testUpdateCategory(){
        Category category = categoryDAO.get(1);
        category.setName("Home Appliance");
        assertTrue("Successfully updated a category", categoryDAO.update(category));
    }

    @Test
    public void testDeleteCategory(){
        Category category = categoryDAO.get(1);
        assertTrue("Successfully deleted a category", categoryDAO.delete(category));
    }

    @Test
    public void testListCategory(){
        assertEquals("Successfully fetched all categories", 1, categoryDAO.list().size());
    }

}
