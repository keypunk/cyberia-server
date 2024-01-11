package com.cyberiashop.models.business_logic;

import com.cyberiashop.models.data_access.EmployeeDAO;
import com.cyberiashop.models.data_access.UserDAO;
import com.cyberiashop.models.data_models.User;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class EmployeeAuthentication extends UnicastRemoteObject implements Authentication {
    private UserDAO userDAO;
    public EmployeeAuthentication() throws RemoteException {
        userDAO = new EmployeeDAO();
    }

    public boolean authenticate(String username, String password) {
        return userDAO.getByUsernameAndPassword(username, password) != null;
    }

    @Override
    public String toString() {
        return "employeeAuthentication";
    }
}
