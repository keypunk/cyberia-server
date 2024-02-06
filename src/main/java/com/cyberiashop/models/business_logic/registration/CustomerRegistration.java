package com.cyberiashop.models.business_logic.registration;

import com.cyberiashop.models.data_access.userDAOs.CustomerDAO;
import com.cyberiashop.models.data_access.userDAOs.UserDAO;
import com.cyberiashop.models.data_models.Customer;
import com.cyberiashop.models.data_models.User;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CustomerRegistration extends UnicastRemoteObject implements Registration {
    private UserDAO userDAO;
    private User user;

    public CustomerRegistration() throws RemoteException {
        userDAO = new CustomerDAO();
        user = new Customer();
    }

    public void register(String username, String password) {
        user.setUsername(username);
        user.setPassword(password);
        userDAO.save(user);
    }

    @Override
    public String toString() {
        return "customerRegistration";
    }
}
