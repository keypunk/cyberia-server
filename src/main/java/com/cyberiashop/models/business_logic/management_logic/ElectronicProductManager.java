package com.cyberiashop.models.business_logic.management_logic;

import com.cyberiashop.models.data_access.productDAOs.ProductDAO;
import com.cyberiashop.models.data_models.Product;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ElectronicProductManager extends UnicastRemoteObject implements ProductManager {
    private ProductDAO productDAO;

    public ElectronicProductManager() throws RemoteException {
        productDAO = new ProductDAO();
    }

    public void addProduct(Product product) {
        productDAO.addProduct(product);
    }

    public void removeProduct(String productName) {
        productDAO.removeProductByName(productName);
    }

    @Override
    public String toString() {
        return "electronicProductManager";
    }
}
