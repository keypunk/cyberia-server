package com.cyberiashop.models.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer implements RMIRegistry {
    private Registry registry;

    public RMIServer(int port) throws RemoteException {
        registry = LocateRegistry.createRegistry(port);
    }
    public void registerRemoteObject(UnicastRemoteObject remoteObject, String resourceName) throws RemoteException {
        registry.rebind(resourceName, remoteObject);
    }

    public void unbindRemoteObject(String resourceName) throws Exception {
        registry.unbind(resourceName);
    }

}
