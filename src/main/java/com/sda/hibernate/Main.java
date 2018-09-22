package com.sda.hibernate;

import com.sda.hibernate.entity.Category;
import com.sda.hibernate.service.CategoryService;

public class Main {
    public static void main(String[] args) {
        CategoryService categoryService = new CategoryService();

        Category category = new Category();
        category.setName("Nowy");

        categoryService.save(category);
    }
}
