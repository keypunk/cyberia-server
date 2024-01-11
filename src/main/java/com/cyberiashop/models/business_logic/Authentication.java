package com.cyberiashop.models.business_logic;

import com.cyberiashop.models.data_models.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Authentication extends Remote {
    boolean authenticate(String username, String password) throws RemoteException;
}
