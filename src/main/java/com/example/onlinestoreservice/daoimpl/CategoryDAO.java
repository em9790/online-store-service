package com.example.onlinestoreservice.daoimpl;

import com.example.onlinestoreservice.dto.Category;
import com.example.onlinestoreservice.dao.ICategoryDAO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("categoryDAO")
public class CategoryDAO implements ICategoryDAO {
    public CategoryDAO(){
        System.out.println("category dao was created");
    }
    private static List<Category> cats = new ArrayList<>();

    static {
        Category c = new Category();
        c.setId(1);
        c.setName("Monitor");
        c.setDescription("this is just a test of category");
        c.setImageURL("https://www.cbronline.com/wp-content/uploads/2016/06/what-is-URL-770x503.jpg");


        Category c1 = new Category();
        c1.setId(2);
        c1.setName("Mobile");
        c1.setDescription("this is just a test of category");
        c1.setImageURL("https://www.cbronline.com/wp-content/uploads/2016/06/what-is-URL-770x503.jpg");

        Category c2 = new Category();
        c2.setId(3);
        c2.setName("Home appliance");
        c2.setDescription("this is just a test of category");
        c2.setImageURL("https://www.cbronline.com/wp-content/uploads/2016/06/what-is-URL-770x503.jpg");


        cats.add(c);
        cats.add(c1);
        cats.add(c2);
    }


    @Override
    public List<Category> list() {
        return cats;
    }

    @Override
    public Category get(int id) {
        Optional<Category> category = cats.stream().filter(c -> c.getId() == id).findFirst();
       return category.isPresent() ? category.get() : null;
    }
}
