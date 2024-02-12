package com.cyberiashop.models.data_access.userDAOs;

import com.cyberiashop.models.data_models.Employee;
import com.cyberiashop.models.utils.HibernateUtil;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


class EmployeeDAOTest {

    private static EmployeeDAO employeeDAO;
    private static Employee employee;

    @BeforeAll
    static void setUp() {
        employee = new Employee("guest", "1234");
        employeeDAO = new EmployeeDAO();
    }


    @Test
    void save_ValidEmployee_DoesNotThrow() {
        // Arrange
        Employee persistedEmployee = employee;

        // Act & Assert
        assertDoesNotThrow(() -> employeeDAO.save(persistedEmployee));
    }

    @Test
    void save_InvalidEmployee_ThrowIllegalArgumentException() {
        // Arrange
        Employee employee = null;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> employeeDAO.save(employee));
    }

    @Test
    void getByUsername_EmployeeInDatabase_ReturnEmployeeObject() {
        // Arrange
        Employee expectedEmployee = employee;

        // Act
        Employee actualEmployee = (Employee) employeeDAO.getByUsername(employee.getUsername());

        // Assert
        assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    void getByUsername_EmployeeNotInDatabase_ReturnNull() {
        // Arrange
        Employee expectedEmployee = null;

        // Act
        Employee actualEmployee = (Employee) employeeDAO.getByUsername("notInDatabase");

        // Assert
        assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    void getByUsernameAndPassword_EmployeeInDatabase_ReturnEmployeeObject() {
        // Arrange
        Employee expectedEmployee = employee;

        // Act
        Employee actualEmployee = (Employee) employeeDAO.getByUsernameAndPassword("guest", "1234");

        // Assert
        assertEquals(expectedEmployee, actualEmployee);
    }
    @Test
    void getByUsernameAndPassword_EmployeeNotInDatabase_ReturnNull() {
        // Arrange
        Employee expectedEmployee = null;

        // Act
        Employee actualEmployee = (Employee) employeeDAO.
                getByUsernameAndPassword("notInDatabase", "1234");

        // Assert
        assertEquals(expectedEmployee, actualEmployee);
    }
    @AfterAll
    static void tearDown() {
        employee = null;
        employeeDAO.deleteByUsername("guest");
    }
}