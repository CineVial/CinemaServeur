package com.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSession {
    private static SessionFactory sessionFactory;
    private static ThreadLocal<Session> session;
    static {
        Configuration configuration = new Configuration();
        Configuration configure = configuration.configure("static/hibernate.cfg.xml");
        sessionFactory = configure.buildSessionFactory();
        session = new ThreadLocal<>();
    }

    public static Session currentSession() {
        Session s = session.get();
        if(s == null) {
            s = sessionFactory.openSession();
            session.set(s);
        }
        return s;
    }

    public static void closeSession() {
        Session s = session.get();
        if(s != null) {
            s.close();
        }
        session.set(null);
    }
}
