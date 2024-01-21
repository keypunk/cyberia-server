package com.cyberiashop.models.business_logic.authentication;

import com.cyberiashop.models.data_access.userDAOs.CustomerDAO;
import com.cyberiashop.models.data_access.userDAOs.UserDAO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CustomerAuthentication extends UnicastRemoteObject implements Authentication {
    private UserDAO userDAO;

    public CustomerAuthentication() throws RemoteException {
        userDAO = new CustomerDAO();
    }

    public boolean authenticate(String username, String password) {
        return userDAO.getByUsernameAndPassword(username, password) != null;
    }

    @Override
    public String toString() {
        return "customerAuthentication";
    }
}
