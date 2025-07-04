package service;

import model.Department;
import model.Employee;

public interface EmployeeManagement {
    void addDepartment(Department d);
    void updateDepartment(int id, String name, String address);
    void addEmployee(Employee e);
    void updateEmployee(String id, String address, double salary);
    void showDepartments();
    void showEmployeesByDepartment(int depId);
    void showAllEmployees();
    void showManagers();
    void showTotalSalaryByDepartment(int depId);
}
