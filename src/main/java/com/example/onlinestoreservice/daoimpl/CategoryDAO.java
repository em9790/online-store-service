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
public class CategoryDAO implements ICategoryDAO {


    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Category> list() {
        String selectQuery = "FROM Category WHERE active =:active";
        Query query = sessionFactory.getCurrentSession().createQuery(selectQuery);
        query.setParameter("active",true);
        return query.getResultList();
    }

    @Override
    public Category get(int id) {
       return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
    }

    @Override
    @Transactional
    public boolean add(Category category) {
        try {
          sessionFactory.getCurrentSession().persist(category);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Category category) {
        try {
            sessionFactory.getCurrentSession().update(category);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Category category) {
        try {
            category.setActive(false);
            sessionFactory.getCurrentSession().update(category);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
}
