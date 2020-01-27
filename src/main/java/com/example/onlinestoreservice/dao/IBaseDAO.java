package com.example.onlinestoreservice.dao;

import com.example.onlinestoreservice.dto.Category;
import com.example.onlinestoreservice.dto.EntityBase;

import java.util.List;

public interface IBaseDAO <T extends EntityBase>{
    List<T> listActive();
    T get(int id);
    int add(T entity);
    boolean update(T entity);
    boolean delete(T entity);
}
