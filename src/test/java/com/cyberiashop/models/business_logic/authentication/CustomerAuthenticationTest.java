package com.cyberiashop.models.business_logic.authentication;

import com.cyberiashop.models.data_access.userDAOs.CustomerDAO;
import com.cyberiashop.models.data_models.Customer;
import com.cyberiashop.models.data_models.User;
import org.junit.jupiter.api.*;

import java.rmi.RemoteException;

import static org.junit.jupiter.api.Assertions.*;

class CustomerAuthenticationTest {
    private static User user;
    private static CustomerDAO customerDAO;

    @BeforeAll
    static void setUp() {
        customerDAO = new CustomerDAO();
        user = new Customer("guest", "1234");
        customerDAO.save(user);
    }

    @Test
    void authenticate_ValidCustomer_ReturnBooleanValueTrue() throws RemoteException {
        // Arrange
        CustomerAuthentication customerAuthentication = new CustomerAuthentication();

        // Act
        boolean actualResult = customerAuthentication.authenticate(user.getUsername(), user.getPassword());

        // Assert
        assertTrue(actualResult);
    }

    @Test
    void authenticate_InvalidCustomer_ReturnBooleanValueFalse() throws RemoteException {
        // Arrange
        User unkownUser = new Customer("unkown", "1234");
        CustomerAuthentication customerAuthentication = new CustomerAuthentication();

        // Act
        boolean actualResult = customerAuthentication.authenticate(unkownUser.getUsername(), unkownUser.getPassword());

        // Assert
        assertFalse(actualResult);
    }

    @AfterAll
    static void tearDown() {
        customerDAO.deleteByUsername("guest");
    }
}