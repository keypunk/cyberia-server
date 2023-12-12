package com.cyberiashop.models.businesslogic;

import com.cyberiashop.models.dao.EmployeeDAO;

public class EmployeeAuthentication extends Authentication {
    private EmployeeDAO employeeDAO;

    public EmployeeAuthentication() {
        employeeDAO = new EmployeeDAO();
    }

    public boolean credentialsExist(String username, String password) {
        return employeeDAO.getEmployeeByUsernameAndPassword(username, password) != null;
    }
}
