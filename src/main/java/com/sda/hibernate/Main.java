package com.sda.hibernate;

import com.sda.hibernate.config.HibernateUtils;
import com.sda.hibernate.entity.Author;
import com.sda.hibernate.entity.Category;
import com.sda.hibernate.service.AuthorService;
import com.sda.hibernate.service.CategoryService;

public class Main {
    public static void main(String[] args) {
        CategoryService categoryService = new CategoryService();
        AuthorService authorService = new AuthorService();

        Category category = new Category();
        category.setName("Nowy3");

        categoryService.save(category);

        Author author = new Author();
        author.setName("Nowy Autor3");

        authorService.save(author);


        HibernateUtils.closeConnection();




    }
}
