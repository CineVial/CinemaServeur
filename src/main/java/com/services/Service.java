package com.services;

import com.DAO.HibernateSession;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.TypedQuery;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
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

    public <T> T getByID(Class<T> type, String... Id) {
        String[] tentityName = type.getName().split("\\.");
        String entityName = tentityName[tentityName.length-1];
        String className = entityName.substring(0, entityName.length() - "Entity".length());

        Method[] methods = type.getMethods();
        List<String> clePrimaire = new ArrayList<>();
        List<Annotation> annotations;
        for (Method method : methods) {
            annotations = Arrays.asList(method.getAnnotations());
            int bool = 0;
            String idColumn = "";
            for (int i = 0; i < annotations.size(); i++) {
                if (annotations.get(i).annotationType().equals(Id.class)) {
                    bool = 1;
                }
                if (annotations.get(i).annotationType().equals(Column.class)) {
                    Column column = (Column) annotations.get(i);
                    idColumn = column.name();
                }
            }
            if(bool==1)
                clePrimaire.add(idColumn);
        }

        String request = "SELECT " + className + " FROM " + entityName + " " + className;

        if(clePrimaire.size()!=Id.length)
            return null;
        else {
            request = request.concat(" WHERE " + clePrimaire.get(0)+ " = '" + Id[0] + "'");
            for (int i = 1; i < clePrimaire.size(); i++) {
                request = request.concat(" AND " + clePrimaire.get(i)+ " = '" + Id[i] + "'");
            }

            return this.execute(request, type).get(0);
        }
    }
}
