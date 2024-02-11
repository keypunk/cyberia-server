package com.cyberiashop.models.business_logic.management_logic;

import com.cyberiashop.models.data_models.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface UserSearch extends Remote {
    List<User> emptySearch() throws RemoteException;
}
