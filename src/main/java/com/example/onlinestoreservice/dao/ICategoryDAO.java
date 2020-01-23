package com.example.onlinestoreservice.dao;

import com.example.onlinestoreservice.dto.Category;

import java.util.List;

public interface ICategoryDAO {
    List<Category> list();
    Category get(int id);
}
