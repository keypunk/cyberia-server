package com.cyberiashop.models.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RMIRegistrar {
    private RMIRegistry registry;
    private List<UnicastRemoteObject> remoteObjects;

    public RMIRegistrar(RMIRegistry registry, List<UnicastRemoteObject> remoteObjects) {
        this.registry = registry;
        this.remoteObjects = remoteObjects;
    }

    public RMIRegistry getRegistry() {
        return registry;
    }

    public void setRegistry(RMIRegistry registry) {
        this.registry = registry;
    }

    public List<UnicastRemoteObject> getRemoteObjects() {
        return remoteObjects;
    }

    public void setRemoteObjects(List<UnicastRemoteObject> remoteObjects) {
        this.remoteObjects = remoteObjects;
    }

    public void bindRemoteObjects() throws RemoteException {
        for (UnicastRemoteObject remoteObject : remoteObjects) {
            registry.registerRemoteObject(remoteObject, remoteObject.toString());
        }
    }

    public void unbindRemoteObjects() throws Exception {
        for (UnicastRemoteObject remoteObject : remoteObjects) {
            registry.unbindRemoteObject(remoteObject.toString());
        }
    }
}
