package com.cyberiashop.models.business_logic.management_logic;

import com.cyberiashop.models.data_access.userDAOs.EmployeeDAO;
import com.cyberiashop.models.data_access.userDAOs.UserDAO;
import com.cyberiashop.models.data_models.Employee;
import com.cyberiashop.models.data_models.User;
import org.junit.jupiter.api.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeSearchTest {
    private static UserDAO userDAO;
    private static User user;

    @BeforeAll
    static void setUp() {
        userDAO = new EmployeeDAO();
        user = new Employee("employee", "1234");
        userDAO.save(user);
    }

    @Test
    void emptySearch_NonEmptyEmployeeDB_ReturnsListWithAllEmployees() throws RemoteException {
        // Arrange
        List<User> expectedResult = List.of(user);
        EmployeeSearch employeeSearch = new EmployeeSearch();

        // Act
        List<User> actualResult = employeeSearch.emptySearch();

        // Assert
        // (assert usernames since Hibernate creates new objects for read operations)
        assertEquals(expectedResult.get(0).getUsername(), actualResult.get(0).getUsername());
    }

    @Test
    void emptySearch_EmptyEmployeeDB_ReturnsEmptyList() throws RemoteException {
        // Arrange
        List<User> expectedResult = new ArrayList<>();
        EmployeeSearch employeeSearch = new EmployeeSearch();
        userDAO.deleteByUsername(user.getUsername());

        // Act
        List<User> actualResult = employeeSearch.emptySearch();

        // Assert
        assertEquals(expectedResult, actualResult);
    }

}