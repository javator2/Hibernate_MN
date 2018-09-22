package com.sda.hibernate.service;

import com.sda.hibernate.dao.AuthorDao;
import com.sda.hibernate.dao.CategoryDao;
import com.sda.hibernate.entity.Author;
import com.sda.hibernate.entity.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryServiceTest {

    private static CategoryDao categoryDao;
    private static AuthorDao authorDao;

    @BeforeEach
    public void beforeTests(){
        categoryDao = new CategoryDao();
        categoryDao.openCurrentSession();
    }

    @Test
    void saveCategory() {
        Category category = new Category();
        category.setName("TestowaKategoria");
        assertNotNull(categoryDao.save(category));
    }

    @Test
    void updateCategory() {
        Category category = new Category();
        category.setName("TestowaKategoria2");
       //assertNotNull(categoryDao.update(category));
    }
}