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
    private Category category;
    private static int addedId=4;

    @BeforeClass
    public static void init(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.example.*");
        context.refresh();
        categoryDAO = context.getBean("categoryDAO" , ICategoryDAO.class);
    }

    @Test
    public void testAddCategory(){
        category = new Category();
        category.setName("Kitchen Appliance");
        category.setDescription("this is just a test of category");
        category.setImageURL("KitchenAppliance.jpeg");
        addedId = categoryDAO.add(category);

        assertNotEquals("Successfully added a category inside the table!" , 0, addedId);
    }

    @Test
    public void testGetCategory(){
        try{
            category = categoryDAO.get(addedId);
            assertEquals("Successfully fetched a category from the table!" , "Laptop", category.getName());
        }
       catch (Exception e){
            e.printStackTrace();
       }
    }

    @Test
    public void testUpdateCategory(){
        category = categoryDAO.get(addedId);
        category.setName("Home Appliance");
        assertTrue("Successfully updated a category", categoryDAO.update(category));
    }

    @Test
    public void testListCategory(){
        assertEquals("Successfully fetched all categories", 4, categoryDAO.listActive().size());
    }

    @Test
    public void testDeleteCategory(){
        category = categoryDAO.get(addedId);
        assertTrue("Successfully deleted a category", categoryDAO.delete(category));
    }

}
