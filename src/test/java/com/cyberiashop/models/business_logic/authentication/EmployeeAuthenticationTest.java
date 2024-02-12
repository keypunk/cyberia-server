package com.cyberiashop.models.business_logic.authentication;

import com.cyberiashop.models.data_access.userDAOs.EmployeeDAO;
import com.cyberiashop.models.data_models.Employee;
import com.cyberiashop.models.data_models.User;
import org.junit.jupiter.api.*;

import java.rmi.RemoteException;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeAuthenticationTest {
    private static User user;
    private static EmployeeDAO employeeDAO;

    @BeforeAll
    static void setUp() {
        employeeDAO = new EmployeeDAO();
        user = new Employee("employee", "1234");
        employeeDAO.save(user);
    }

    @Test
    void authenticate_ValidEmployee_ReturnBooleanValueTrue() throws RemoteException {
        // Arrange
        EmployeeAuthentication employeeAuthentication = new EmployeeAuthentication();

        // Act
        boolean actualResult = employeeAuthentication.authenticate(user.getUsername(), user.getPassword());

        // Assert
        assertTrue(actualResult);
    }

    @Test
    void authenticate_InvalidEmployee_ReturnBooleanValueFalse() throws RemoteException {
        // Arrange
        User unknownUser = new Employee("unknown", "1234");
        EmployeeAuthentication employeeAuthentication = new EmployeeAuthentication();

        // Act
        boolean actualResult = employeeAuthentication.authenticate(unknownUser.getUsername(), unknownUser.getPassword());

        // Assert
        assertFalse(actualResult);
    }

    @AfterAll
    static void tearDown() {
        employeeDAO.deleteByUsername("employee");
    }
}