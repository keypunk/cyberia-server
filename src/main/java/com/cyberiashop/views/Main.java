package com.cyberiashop.views;

import com.cyberiashop.models.dao.HibernateInit;

public class Main {
    public static void main(String[] args) {
        HibernateInit.INSTANCE.getSessionFactory();
    }
}