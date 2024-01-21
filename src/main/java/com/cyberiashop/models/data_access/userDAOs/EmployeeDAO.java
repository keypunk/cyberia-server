package com.cyberiashop.models.data_access.userDAOs;

import com.cyberiashop.models.utils.HibernateUtil;
import com.cyberiashop.models.data_models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeDAO implements UserDAO {
    private SessionFactory sessionFactory;

    public EmployeeDAO() {
        sessionFactory = HibernateUtil.INSTANCE.getSessionFactory();
    }

    public void save(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            session.persist(user);

            transaction.commit();
        }
    }

       public void deleteByUsername(String username) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Query<User> query = session.createQuery("DELETE FROM Employee WHERE username = :username");

            query.setParameter("username", username);
            query.executeUpdate();
            transaction.commit();
        }
    }

    public List<User> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Employee", User.class).list();
        }
    }

    public User getByUsername(String username) {
        try (Session session = sessionFactory.openSession()) {
            String queryString = "SELECT e FROM Employee e WHERE e.username = :username";
            Query<User> query = session.createQuery(queryString, User.class);
            query.setParameter("username", username);
            return query.uniqueResult();
        }
    }

    public User getByUsernameAndPassword(String username, String password) {
        try (Session session = sessionFactory.openSession()) {
            String queryString = "SELECT e FROM Employee e WHERE e.username = :username AND e.password = :password";
            Query<User> query = session.createQuery(queryString, User.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
            return query.uniqueResult();
        }
    }
}
