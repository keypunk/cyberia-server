package com.cyberiashop.models.business_logic.registration;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Registration extends Remote {
    void register(String username, String password) throws RemoteException;
}
