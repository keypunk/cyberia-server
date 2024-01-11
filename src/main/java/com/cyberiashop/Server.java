package com.cyberiashop;

import com.cyberiashop.models.business_logic.EmployeeAuthentication;
import com.cyberiashop.models.data_access.EmployeeDAO;
import com.cyberiashop.models.data_models.Employee;
import com.cyberiashop.models.rmi.RMIRegistrar;
import com.cyberiashop.models.rmi.RMIServer;

import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class Server {
    public static void main(String[] args) throws Exception {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.save(new Employee("guest", "1234"));
        RMIServer rmiServer = new RMIServer(Registry.REGISTRY_PORT);
        List<UnicastRemoteObject> remoteObjects = List.of(new EmployeeAuthentication());
        RMIRegistrar rmiRegistrar = new RMIRegistrar(rmiServer, remoteObjects);
        rmiRegistrar.bindRemoteObjects();
    }
}