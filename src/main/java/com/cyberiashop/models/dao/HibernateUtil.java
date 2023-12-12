package com.cyberiashop.models.dao;

import org.hibernate.SessionFactory;

public interface HibernateUtil {
    SessionFactory sessionFactory = HibernateInit.INSTANCE.getSessionFactory();
}
