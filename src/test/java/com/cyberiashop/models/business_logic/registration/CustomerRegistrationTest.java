package com.cyberiashop.models.business_logic.registration;

import com.cyberiashop.models.data_access.userDAOs.CustomerDAO;
import com.cyberiashop.models.data_access.userDAOs.UserDAO;
import com.cyberiashop.models.data_models.Customer;
import com.cyberiashop.models.data_models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.rmi.RemoteException;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRegistrationTest {
    private static User user;
    private static UserDAO userDAO;

    @BeforeAll
    static void setUp() {
        user = new Customer("guest", "1234");
        userDAO = new CustomerDAO();
    }

    @Test
    void register_ValidUser_DoesNotThrow() throws RemoteException {
        // Arrange
        CustomerRegistration customerRegistration = new CustomerRegistration();

        // Act & Assert
        assertDoesNotThrow(() -> customerRegistration.register(user.getUsername(), user.getPassword()));
    }

    @AfterEach
    void tearDown() {
        userDAO.deleteByUsername(user.getUsername());
    }
}