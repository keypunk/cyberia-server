package com.cyberiashop.models.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public interface RMIRegistry {
    void registerRemoteObject(UnicastRemoteObject remoteObject, String resourceName) throws RemoteException;
    void unbindRemoteObject(String resourceName) throws Exception;
}
