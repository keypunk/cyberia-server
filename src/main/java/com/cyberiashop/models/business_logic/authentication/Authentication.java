package com.cyberiashop.models.business_logic.authentication;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Authentication extends Remote {
    boolean authenticate(String username, String password) throws RemoteException;
}
