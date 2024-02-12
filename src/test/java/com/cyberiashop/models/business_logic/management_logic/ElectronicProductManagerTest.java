package com.cyberiashop.models.business_logic.management_logic;

import com.cyberiashop.models.data_models.Category;
import com.cyberiashop.models.data_models.Product;
import org.junit.jupiter.api.*;

import java.rmi.Remote;
import java.rmi.RemoteException;

import static org.junit.jupiter.api.Assertions.*;

class ElectronicProductManagerTest {
    static Product product;

    @BeforeAll
    static void setUp() {
        product = new Product();
        product.setName("Apple Watch");
        product.setPrice(3000.00);
        product.setQuantity(34);
        product.setCategory(Category.ACCESSORIES);
    }

    @Test
    void addProduct_ValidProduct_DoesNotThrow() throws RemoteException {
        // Arrange
        Product productToAdd = product;
        ElectronicProductManager electronicProductManager = new ElectronicProductManager();

        // Act & Assert
        assertDoesNotThrow(() -> electronicProductManager.addProduct(productToAdd));
    }

    @Test
    void addProduct_InvalidProduct_ThrowsIllegalArgumentException() throws RemoteException {
        // Arrange
        Product productToAdd = null;
        ElectronicProductManager electronicProductManager = new ElectronicProductManager();

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> electronicProductManager.addProduct(productToAdd));
    }

    @Test
    void removeProduct_KnownProduct_DoesNotThrow() throws RemoteException {
        // Arrange
        ElectronicProductManager electronicProductManager = new ElectronicProductManager();
        electronicProductManager.addProduct(product);

        // Act & Assert
        assertDoesNotThrow(() -> electronicProductManager.removeProduct(product.getName()));
    }

    @Test
    void removeProduct_UnknownProduct_ThrowsIllegalStateException() throws RemoteException {
        // Arrange
        ElectronicProductManager electronicProductManager = new ElectronicProductManager();

        // Act & Assert
        assertThrows(IllegalStateException.class,
                () -> electronicProductManager.removeProduct("Dell Latitude 7400"));
    }

    @AfterAll
    static void tearDown() throws RemoteException {
        ElectronicProductManager electronicProductManager = new ElectronicProductManager();
        electronicProductManager.removeProduct(product.getName());
    }
}