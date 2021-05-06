package dao;

import entity.Log;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LogDAO extends SessionConnector implements LogDaoInterface<Log, String> {

    @Override
    public void persist(Log entity) {
        getCurrentSession().save(entity);
    }

    @Override
    SessionFactory getSessionFactory() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Log.class)
                .buildSessionFactory();

        return factory;
    }

}
