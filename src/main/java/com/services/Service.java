package com.services;

import com.DAO.HibernateSession;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Robin on 18/10/2017.
 */
public class Service {

    List execute(String request) {
        return execute(request, Object.class);
    }

    <T> List<T> execute(String request, Class<T> type) {
        List<T> result;
        Session session = HibernateSession.currentSession();
        TypedQuery<T> query = session.createQuery(request, type);
        result = query.getResultList();
        HibernateSession.closeSession();
        return result;
    }

    void saveOrUpdate(Object o) {
        Session session = HibernateSession.currentSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(o);
        transaction.commit();
        HibernateSession.closeSession();
    }

    void remove(Object o) {
        Session session = HibernateSession.currentSession();
        Transaction transaction = session.beginTransaction();
        session.remove(o);
        transaction.commit();
        HibernateSession.closeSession();
    }

    public <T> List<T> getAll(Class<T> type) {
        String[] tentityName = type.getName().split("\\.");
        String entityName = tentityName[tentityName.length-1];
        String className = entityName.substring(0, entityName.length() - "Entity".length());
        String request = "SELECT " + className + " FROM " + entityName + " " + className;
        return this.execute(request, type);
    }
}
