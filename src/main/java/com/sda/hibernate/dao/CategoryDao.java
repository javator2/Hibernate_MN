package com.sda.hibernate.dao;

import com.sda.hibernate.config.HibernateUtils;
import com.sda.hibernate.entity.Category;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CategoryDao implements DaoInterface<Category> {

    private Session currentSession;
    private Transaction currentTransaction;

    public CategoryDao(){
        //currentSession = HibernateUtils.getSession();
        //currentTransaction = currentSession.beginTransaction();
    }

    public Session getCurrentSession(){
        return currentSession;
    }

    public void openCurrentSession(){
        currentSession = HibernateUtils.getSession();
        currentTransaction = currentSession.beginTransaction();

    }

    public void closeCurrentSession(){
        currentTransaction.commit();
        currentSession.close();
    }


    @Override
    public Category save(Category entity) {
            getCurrentSession().save(entity);
        return entity;
    }

    @Override
    public void update(Category entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Category findById(int id) {
        //TODO zabezpieczyć przed NullPointedExeption
        Category category = getCurrentSession().get(Category.class, id);
        return category;
    }

    @Override
    public void delete(Category entity) {
        //TODO zabezpieczenie przed usunięciem nieistniejącego rekordu
        getCurrentSession().delete(entity);

    }

    @Override
    public void deleteAll() {
        String sql = "delete from category";
        Query query = getCurrentSession().createQuery(sql);
        query.executeUpdate();

    }

    @Override
    public List<Category> findAll() {
        List <Category> categoryList = getCurrentSession().createQuery(
                "FROM" + Category.class.getName()
        ).list();
        return categoryList;
    }
}
