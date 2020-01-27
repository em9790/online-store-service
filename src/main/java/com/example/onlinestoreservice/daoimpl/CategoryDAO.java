package com.example.onlinestoreservice.daoimpl;

import com.example.onlinestoreservice.dto.Category;
import com.example.onlinestoreservice.dao.ICategoryDAO;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("categoryDAO")
@Transactional
public class CategoryDAO extends BaseDAO<Category> implements ICategoryDAO {

    @Override
    protected Class<Category> getEntityClass() {
        return Category.class;
    }

}
