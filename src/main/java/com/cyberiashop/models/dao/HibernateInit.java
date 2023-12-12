package com.cyberiashop.models.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

// Singleton-Pattern for SessionFactory using enum 'HibernateInit'
public enum HibernateInit {
    INSTANCE;

    private SessionFactory sessionFactory;

    private HibernateInit() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        sessionFactory = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
