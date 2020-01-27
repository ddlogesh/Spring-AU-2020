package config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class DBConfig {
    private static SessionFactory sessionFactory;
    private static Session session;

    public static void initiateDB() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        session = sessionFactory.openSession();
        session.beginTransaction();
    }

    public static Session getSession() {
        return session;
    }

    public static void insert(Object object) {
        session.save(object);
    }

    public static void delete(Object object) {
        session.delete(object);
    }

    public static void update(Object object) {
        session.update(object);
    }

    public static List<Object> getAllValues(String tableName){
        String queryStr = "select val from " + tableName + " val";
        Query query = session.createQuery(queryStr);
        return query.list();
    }

    public static void close(){
        session.getTransaction().commit();
        session.close();
    }
}
