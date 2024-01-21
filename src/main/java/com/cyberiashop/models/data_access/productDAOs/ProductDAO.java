package com.cyberiashop.models.data_access.productDAOs;

import com.cyberiashop.models.data_models.Product;
import com.cyberiashop.models.utils.HibernateUtil;
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

    public Product getProductByName(String productName) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Product> query = session.createQuery("FROM Product WHERE name LIKE :productName", Product.class);
        query.setParameter("productName", "%" + productName + "%");
        Product product = query.uniqueResult();
        transaction.commit();
        session.close();
        return product;
    }
}