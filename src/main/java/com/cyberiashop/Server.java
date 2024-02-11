package com.cyberiashop;

import com.cyberiashop.models.business_logic.authentication.CustomerAuthentication;
import com.cyberiashop.models.business_logic.authentication.EmployeeAuthentication;
import com.cyberiashop.models.business_logic.management_logic.ElectronicProductManager;
import com.cyberiashop.models.business_logic.management_logic.EmployeeSearch;
import com.cyberiashop.models.business_logic.registration.CustomerRegistration;
import com.cyberiashop.models.business_logic.shop_logic.ElectronicProductSearch;
import com.cyberiashop.models.data_access.productDAOs.ProductDAO;
import com.cyberiashop.models.data_access.userDAOs.EmployeeDAO;
import com.cyberiashop.models.data_models.Employee;
import com.cyberiashop.models.data_models.Product;
import com.cyberiashop.models.rmi.RMIRegistrar;
import com.cyberiashop.models.rmi.RMIServer;
import com.cyberiashop.models.utils.MockProductDB;

import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class Server {
    public static void main(String[] args) throws Exception {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.save(new Employee("admin", "1234"));

        ProductDAO productDAO = new ProductDAO();
        List<Product> products = MockProductDB.getMockProductList();
        for (Product product : products) {
            productDAO.addProduct(product);
        }

        RMIServer rmiServer = new RMIServer(Registry.REGISTRY_PORT);
        List<UnicastRemoteObject> remoteObjects = List.of(
                new EmployeeAuthentication(),
                new CustomerAuthentication(),
                new ElectronicProductSearch(),
                new CustomerRegistration(),
                new ElectronicProductManager(),
                new EmployeeSearch()
        );
        RMIRegistrar rmiRegistrar = new RMIRegistrar(rmiServer, remoteObjects);
        rmiRegistrar.bindRemoteObjects();
    }
}