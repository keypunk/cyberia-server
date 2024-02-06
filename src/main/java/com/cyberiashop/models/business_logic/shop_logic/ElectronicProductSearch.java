package com.cyberiashop.models.business_logic.shop_logic;

import com.cyberiashop.models.data_access.productDAOs.ProductDAO;
import com.cyberiashop.models.data_models.Product;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ElectronicProductSearch extends UnicastRemoteObject implements ProductSearch {
    private ProductDAO productDAO;

    public ElectronicProductSearch() throws RemoteException {
        productDAO = new ProductDAO();
    }

    public List<Product> emptySearch() {
        return productDAO.getAllProducts();
    }

    public List<Product> searchByProductName(String productName) {
        return productDAO.getProductByName(productName);
    }

    @Override
    public String toString() {
        return "electronicProductSearch";
    }
}
