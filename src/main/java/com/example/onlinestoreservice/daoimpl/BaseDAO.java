package com.example.onlinestoreservice.daoimpl;

import com.example.onlinestoreservice.dao.IBaseDAO;
import com.example.onlinestoreservice.dto.Category;
import com.example.onlinestoreservice.dto.EntityBase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.Table;
import java.lang.annotation.Annotation;
import java.util.List;

@Repository
@Transactional
public abstract class BaseDAO<T extends EntityBase> implements IBaseDAO<T> {
    private SessionFactory sessionFactory;
    private String tableName;

    protected String getTableName( ){
        if(tableName == null || tableName.isEmpty()) {
            Table tableAnnot = getEntityClass().getAnnotation(Table.class);
            this.tableName = tableAnnot != null ? tableAnnot.name() : getEntityClass().getSimpleName();
        }
        return tableName;
    }

    protected abstract Class<T> getEntityClass();

    @Autowired
    protected void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public List<T> listActive() {
        String selectQuery = String.format( "FROM %s WHERE active =:active", getTableName());
        Query query = getSession().createQuery(selectQuery);
        query.setParameter("active",true);
        return query.getResultList();
    }

    @Override
    public T get(int id) {
        return getSession().get(getEntityClass(),Integer.valueOf(id));
    }

    @Override
    public int add(T entity) {
        try {
            Session  session= getSession();
            session.persist(entity);
            session.flush();
            return entity.getId();
        }catch (Exception ex){
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public boolean update(T entity) {
        try {
            sessionFactory.getCurrentSession().update(entity);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(T entity) {
        try {
            entity.setActive(false);
            sessionFactory.getCurrentSession().update(entity);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
}
