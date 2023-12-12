package com.cyberiashop.models.businesslogic;

public abstract class Authentication {
    public abstract boolean credentialsExist(String username, String password);
}
