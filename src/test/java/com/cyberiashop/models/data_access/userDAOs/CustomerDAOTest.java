package com.cyberiashop.models.data_access.userDAOs;

import com.cyberiashop.models.data_models.Customer;
import com.cyberiashop.models.utils.HibernateUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerDAOTest {

    private static CustomerDAO customerDAO;
    private static Customer customer;

    @BeforeAll
    static void setUp() {
        customer = new Customer("guest", "1234");
        customerDAO = new CustomerDAO();
    }


    @Test
    void save_ValidCustomer_DoesNotThrow() {
        // Arrange
        Customer persistedCustomer = customer;

        // Act & Assert
        assertDoesNotThrow(() -> customerDAO.save(persistedCustomer));
    }

    @Test
    void save_InvalidCustomer_ThrowIllegalArgumentException() {
        // Arrange
        Customer customer = null;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> customerDAO.save(customer));
    }

    @Test
    void getByUsername_CustomerNotInDatabase_ReturnNull() {
        // Arrange
        Customer expectedCustomer = null;

        // Act
        Customer actualCustomer = (Customer) customerDAO.getByUsername("notInDatabase");

        // Assert
        assertEquals(expectedCustomer, actualCustomer);
    }

    @Test
    void getByUsernameAndPassword_CustomerInDatabase_ReturnCustomerObject() {
        // Arrange
        Customer expectedCustomer = customer;

        // Act
        Customer actualCustomer = (Customer) customerDAO.getByUsernameAndPassword("guest", "1234");

        // Assert
        assertEquals(expectedCustomer, actualCustomer);
    }
    @Test
    void getByUsernameAndPassword_CustomerNotInDatabase_ReturnNull() {
        // Arrange
        Customer expectedCustomer = null;

        // Act
        Customer actualCustomer = (Customer) customerDAO.
                getByUsernameAndPassword("notInDatabase", "1234");

        // Assert
        assertEquals(expectedCustomer, actualCustomer);
    }
    @AfterAll
    static void tearDown() {
        customer = null;
        customerDAO.deleteByUsername("guest");
    }
}
