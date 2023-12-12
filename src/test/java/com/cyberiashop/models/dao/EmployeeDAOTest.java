package com.cyberiashop.models.dao;

import com.cyberiashop.models.pojo.Employee;
import org.hibernate.PropertyValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDAOTest {

    private EmployeeDAO employeeDAO;

    @BeforeEach
    void init() {
        employeeDAO = new EmployeeDAO();
    }


    @Test
    void saveEmployee_validEmployee_True() {
        // Arrange
        String username = "employee";
        String password = "abc123";
        Employee employee = new Employee(username, password);

        // Act
        employeeDAO.saveEmployee(employee);

        // Assert
        String queriedUsername = employeeDAO.getEmployeeByUsernameAndPassword(username, password).getUsername();
        String queriedPassword = employeeDAO.getEmployeeByUsernameAndPassword(username, password).getPassword();
        assertTrue((queriedUsername + " " + queriedPassword).equals(username + " " + password));
    }

    @Test
    void saveEmployee_EmployeeWithNullAsUsername_HibernateException() {
        // Arrange
        String username = null;
        String password = "123";
        Employee employee = new Employee(username, password);

        // Act & Assert
        assertThrows(PropertyValueException.class,() -> {
            employeeDAO.saveEmployee(employee);
        });
    }

    @Test
    void saveEmployee_EmployeeWithNullAsPassword_HibernateException() {
        // Arrange
        String username = "employee";
        String password = null;
        Employee employee = new Employee(username, password);

        // Act & Assert
        assertThrows(PropertyValueException.class, () -> {
            employeeDAO.saveEmployee(employee);
        });
    }

    @Test
    void saveEmployee_NullObject_IllegalArgumentException() {
        // Arrange
        Employee employee = null;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            employeeDAO.saveEmployee(employee);
        });
    }

    @Test
    void getEmployeeByUsernameAndPassword() {
    }
}