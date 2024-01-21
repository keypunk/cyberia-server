package com.cyberiashop.models.business_logic.authentication;

import com.cyberiashop.models.data_access.userDAOs.EmployeeDAO;
import com.cyberiashop.models.data_access.userDAOs.UserDAO;

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
