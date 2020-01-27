package com.example.onlinestoreservice.dao;

import com.example.onlinestoreservice.dto.Product;

import java.util.List;

public interface IProductDAO extends IBaseDAO<Product> {

    List<Product> listActiveProductsByCategory(int categoryId);
    List<Product> getLatestActiveProducts(int count);
}
