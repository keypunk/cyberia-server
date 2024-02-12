package com.cyberiashop.models.business_logic.shop_logic;

import com.cyberiashop.models.data_access.productDAOs.ProductDAO;
import com.cyberiashop.models.data_models.Category;
import com.cyberiashop.models.data_models.Product;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ElectronicProductSearchTest {
    private static Product product;
    private static ProductDAO productDAO;

    @BeforeAll
    static void setUp() {
        product = new Product();
        product.setName("Apple Watch");
        product.setPrice(3000.00);
        product.setQuantity(36);
        product.setCategory(Category.ACCESSORIES);
        productDAO = new ProductDAO();
        productDAO.addProduct(product);
    }

    @Test
    void emptySearch_NonEmptyProductDB_ReturnListWithAllProducts() throws RemoteException {
        // Arrange
        List<Product> expectedResult = List.of(product);
        ElectronicProductSearch electronicProductSearch = new ElectronicProductSearch();

        // Act
        List<Product> actualResult = electronicProductSearch.emptySearch();

        // Assert
        // (Assert via product names due to Hibernate behaviour of creating new objects when using crud operations)
        assertEquals(expectedResult.get(0).getName(), actualResult.get(0).getName());
    }

    @Test
    void searchByProductName_ValidProductName_ReturnListWithMatchingProductNames() throws RemoteException {
        // Arrange
        List<Product> expectedResult = List.of(product);
        ElectronicProductSearch electronicProductSearch = new ElectronicProductSearch();

        // Act
        List<Product> actualResult = electronicProductSearch.searchByProductName(product.getName());

        // Assert
        // (Assert via product names due to Hibernate behaviour of creating new objects when using crud operations)
        assertEquals(expectedResult.get(0).getName(), actualResult.get(0).getName());
    }

    @Test
    void searchByProductName_InvalidProductName_ReturnEmptyList() throws RemoteException {
        // Arrange
        List<Product> expectedResult = new ArrayList<>();
        ElectronicProductSearch electronicProductSearch = new ElectronicProductSearch();

        // Act
        List<Product> actualResult = electronicProductSearch.searchByProductName("Dell Latitude 7400");

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @AfterAll
    static void tearDown() {
        productDAO.removeProductByName(product.getName());
    }
}