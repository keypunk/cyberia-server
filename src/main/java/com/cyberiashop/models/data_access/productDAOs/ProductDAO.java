package com.cyberiashop.models.data_access.productDAOs;

import com.cyberiashop.models.data_models.Product;
import com.cyberiashop.models.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;


public class ProductDAO {
    private final SessionFactory sessionFactory;

    public ProductDAO() {
        sessionFactory = HibernateUtil.INSTANCE.getSessionFactory();
    }

    public void addProduct(Product product) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(product);
        transaction.commit();
        session.close();
    }

    public void updateProduct(Product product) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(product);
        transaction.commit();
        session.close();
    }

    public List<Product> getAllProducts() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Product> query = session.createQuery("FROM Product", Product.class);
        List<Product> products = query.list();
        transaction.commit();
        session.close();
        return products;
    }

    public List<Product> getProductByName(String productName) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Product> query = session.createQuery("FROM Product WHERE LOWER(name) LIKE LOWER(:productName)", Product.class);
        query.setParameter("productName", "%" + productName + "%");
        List<Product> products = query.list();
        transaction.commit();
        session.close();
        return products;
    }

    public void removeProductByName(String productName) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            try {
                Query query = session.createQuery("DELETE FROM Product WHERE LOWER(name) = LOWER(:productName)");
                query.setParameter("productName", productName);
                int deletedRows = query.executeUpdate();

                if (deletedRows == 0) {
                    throw new IllegalStateException("Product with name '" + productName + "' not found");
                }
            } catch (HibernateException e) {
                transaction.rollback();
                throw e; // Rethrow the exception for proper handling
            }

            transaction.commit();
        } catch (HibernateException e) {
            // Handle any other Hibernate exceptions that might occur outside the transaction block
            throw e;
        }
    }
}