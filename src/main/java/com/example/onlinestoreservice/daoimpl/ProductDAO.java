package com.example.onlinestoreservice.daoimpl;

import com.example.onlinestoreservice.dao.IProductDAO;
import com.example.onlinestoreservice.dto.Category;
import com.example.onlinestoreservice.dto.Product;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("productDAO")
public class ProductDAO extends BaseDAO<Product> implements IProductDAO {

    @Override
    public List<Product> listActiveProductsByCategory(int categoryId) {
        String selectQuery = "FROM Product WHERE active =:active AND categoryId = :categoryId";
        return getSession()
                .createQuery(selectQuery)
                .setParameter("active", true)
                .setParameter("categoryId", categoryId)
                .getResultList();
    }

    @Override
    public List<Product> getLatestActiveProducts(int count) {
        String selectQuery = "FROM Product WHERE active =:active ORDER BY id";
        return getSession()
                .createQuery(selectQuery)
                .setParameter("active", true)
                .setFirstResult(0)
                .setMaxResults(count)
                .list();
    }

    @Override
    protected Class<Product> getEntityClass() {
        return Product.class;
    }
}
