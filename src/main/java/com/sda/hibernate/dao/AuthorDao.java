package com.sda.hibernate.dao;

import com.sda.hibernate.entity.Author;


import com.sda.hibernate.config.HibernateUtils;
import com.sda.hibernate.entity.Author;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AuthorDao implements DaoInterface<Author> {

    private Session currentSession;
    private Transaction currentTransaction;

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
    public Author save(Author entity) {

            getCurrentSession().save(entity);

        return entity;
    }

    @Override
    public void update(Author entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Author findById(int id) {
        //TODO zabezpieczenie przed nullpointer
        Author author = getCurrentSession().get(Author.class, id);
        return author;
    }

    @Override
    public void delete(Author entity) {
        //TODO zabezpieczenie przed usuwaniem rekordu ktory nie istnieje
        getCurrentSession().delete(entity);
    }

    @Override
    public void deleteAll() {
        String sql = "delete from Author ";
        Query query = getCurrentSession().createQuery(sql);
        query.executeUpdate();
    }

    @Override
    public List<Author> findAll() {
        List<Author> authorList = getCurrentSession().createQuery(
                "FROM " + Author.class.getName()
        ).list();

        return authorList;
    }
}