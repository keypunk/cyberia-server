package com.cyberiashop.models.business_logic.management_logic;

import com.cyberiashop.models.data_access.userDAOs.EmployeeDAO;
import com.cyberiashop.models.data_access.userDAOs.UserDAO;
import com.cyberiashop.models.data_models.User;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class EmployeeSearch extends UnicastRemoteObject implements UserSearch {
    private UserDAO userDAO;

    public EmployeeSearch() throws RemoteException {
        userDAO = new EmployeeDAO();
    }

    public List<User> emptySearch() {
        return userDAO.getAll();
    }

    @Override
    public String toString() {
        return "employeeSearch";
    }
}