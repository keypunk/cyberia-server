package com.cyberiashop.models.data_access.productDAOs;

import static org.junit.jupiter.api.Assertions.*;

import com.cyberiashop.models.data_models.Category;
import com.cyberiashop.models.data_models.Product;
import com.cyberiashop.models.utils.HibernateUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ProductDAOTest {

    private static ProductDAO productDAO;
    private static Product product;

    @BeforeAll
    static void setUp() {
        product = new Product();
        product.setName("Apple Watch");
        product.setPrice(3000.00);
        product.setCategory(Category.ACCESSORIES);
        product.setQuantity(34);

        productDAO = new ProductDAO();
    }

    @Test
    void addProduct_validProduct_DoesNotThrow() {
        // Arrange
        Product persistedProduct = product;

        // Act & Assert
        assertDoesNotThrow(() -> productDAO.addProduct(persistedProduct));
    }

    @Test
    void addProduct_invalidProduct_DoesThrowIllegalArgumentException() {
        // Arrange
        Product persistedProduct = null;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> productDAO.addProduct(persistedProduct));
    }

    @Test
    void getAllProducts_validState_ReturnsListOfAllProductsInDB() {
        // Arrange
        List<Product> expectedResult = List.of(product);

        // Act
        List<Product> actualResult = productDAO.getAllProducts();

        // Assert
        // (Test equality of product names, since a new object will be created once we call the read operation)
        assertEquals(expectedResult.get(0).getName(), actualResult.get(0).getName());
    }

    @Test
    void getProductByName_validProduct_ReturnListOfNameMatchingProducts() {
        // Arrange
        List<Product> expectedResult = List.of(product);
        productDAO.addProduct(product);

        // Act
        List<Product> actualResult = productDAO.getProductByName(product.getName());

        // Assert
        // (Again asserting the names since the objects are not equal due to Hibernate behaviour)
        assertEquals(expectedResult.get(0).getName(), actualResult.get(0).getName());

    }

    @Test
    void getProductByName_unknownProduct_ReturnEmptyList() {
        // Arrange
        List<Product> expectedResult = new ArrayList<>();

        // Act
        List<Product> actualResult = productDAO.getProductByName("Dell");

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void removeProductByName_validProduct_DoesNotThrow() {
        // Arrange
        String productToRemove = product.getName();

        // Act & Assert
        assertDoesNotThrow(() -> productDAO.removeProductByName(productToRemove));
    }

    @Test
    void removeProductByName_unknownProduct_DoesThrowIllegalStateException() {
        // Arrange
        String productToRemove = "Dell Latitude 7400";

        // Act & Assert
        assertThrows(IllegalStateException.class, () -> productDAO.removeProductByName(productToRemove));
    }

    @AfterAll
    static void tearDown() {
        product = null;
    }

}