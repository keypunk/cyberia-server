package com.cyberiashop.models.dao;

import com.cyberiashop.models.pojo.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class EmployeeDAO implements HibernateUtil {

    public void saveEmployee(Employee employee) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(employee);
            transaction.commit();
        }
    }
    public Employee getEmployeeByUsernameAndPassword(String username, String password) {
        try (Session session = sessionFactory.openSession()) {
            String queryString = "SELECT e.username, e.password FROM Employee e WHERE e.username = :username AND " +
                    "e.password = :password";
            Query<Employee> query = session.createQuery(queryString, Employee.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
            return query.uniqueResult();
        }
    }
}
