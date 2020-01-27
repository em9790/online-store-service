package com.example.onlinestoreservice;

import com.example.onlinestoreservice.dao.ICategoryDAO;
import com.example.onlinestoreservice.dao.IProductDAO;
import com.example.onlinestoreservice.dto.Category;
import com.example.onlinestoreservice.dto.Product;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class ProductTestCase {
    private static IProductDAO productDAO;
    private static Product product;
    private static int addedId =9;

    @BeforeClass
    public static void init() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.example.*");
        context.refresh();
        productDAO = context.getBean("productDAO", IProductDAO.class);
    }

//    @Test
//    public void testAddProduct() {
//        product = new Product();
//        product.setName("Samsung Galaxy");
//        product.setBrand("samsung");
//        product.setDescription("Samsung Galaxy S10e 128GB blue with 1 & 1 all-net-flat. Flat telephony, flat cell phone networks (all-net-flat), flat internet with up to 20 GB LTE max high-speed volume, international flat rate");
//        product.setUnitPrice(29.90F);
//        product.setCategoryId(3);
//        product.setSupplierId(2);
//        product.setQuantity(100);
//        addedId = productDAO.add(product);
//
//        assertNotEquals("Successfully added a product inside the table!", 0, addedId);
//    }

    @Test
    public void testGetProduct() {
        try {
            String code = product.getCode();
            product = productDAO.get(addedId);
            assertEquals("Successfully fetched a product from the table!", code, product.getCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateCategory() {
        product = productDAO.get(addedId);
        product.setQuantity(200);
        boolean result =productDAO.update(product);
        assertTrue("Successfully updated a product",result );
    }

    @Test
    public void testListCategory() {
        assertEquals("Successfully fetched all products", 4, productDAO.listActive().size());
    }

    @Test
    public void testListActiveProductsByCategory() {
        int categoryId = product == null ? 3 : product.getCategoryId();
        assertEquals("Successfully fetched active products by categoryId", 4, productDAO.listActiveProductsByCategory(categoryId).size());
    }

    @Test
    public void testGetLatestActiveProducts() {
        assertEquals("Successfully fetched latest active products", 4, productDAO.getLatestActiveProducts(2).size());
    }

//    @Test
//    public void testDeleteCategory() {
//        product = productDAO.get(addedId);
//        assertTrue("Successfully deleted a product", productDAO.delete(product));
//    }

}
