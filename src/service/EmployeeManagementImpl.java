package service;

import model.Department;
import model.Employee;
import java.util.*;

public class EmployeeManagementImpl implements EmployeeManagement {
    private List<Department> departments = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();

    @Override
    public void addDepartment(Department d) {
        // Check trùng mã phòng ban nếu cần
        for (Department dep : departments)
            if (dep.getDepartmentId() == d.getDepartmentId()) {
                System.out.println("Phòng ban đã tồn tại!");
                return;
            }
        departments.add(d);
    }

    @Override
    public void updateDepartment(int id, String name, String address) {
        for (Department d : departments) {
            if (d.getDepartmentId() == id) {
                d.setDepartmentName(name);
                d.setDepartmentAddress(address);
            }
        }
    }

    @Override
    public void addEmployee(Employee e) {
        // Check trùng mã nhân viên nếu cần
        for (Employee emp : employees)
            if (emp.getId().equals(e.getId())) {
                System.out.println("Nhân viên đã tồn tại!");
                return;
            }
        employees.add(e);
        // Thêm nhân viên vào phòng ban tương ứng
        for (Department d : departments) {
            if (d.getDepartmentId() == e.getDepartmentId()) {
                d.addEmployee(e);
                return;
            }
        }
        System.out.println("Không tìm thấy phòng ban phù hợp!");
    }

    @Override
    public void updateEmployee(String id, String address, double salary) {
        for (Employee e : employees) {
            if (e.getId().equals(id)) {
                e.setAddress(address);
                e.setBaseSalary(salary);
                break;
            }
        }
    }

    @Override
    public void showDepartments() {
        for (Department d : departments) {
            System.out.println("DepartmentID: " + d.getDepartmentId() +
                    ", Name: " + d.getDepartmentName());
        }
    }

    @Override
    public void showEmployeesByDepartment(int depId) {
        for (Department d : departments) {
            if (d.getDepartmentId() == depId) {
                d.showEmployees();
                return;
            }
        }
        System.out.println("Không tìm thấy phòng ban!");
    }

    @Override
    public void showAllEmployees() {
        for (Employee e : employees) e.showInfo();
    }

    @Override
    public void showManagers() {
        for (Employee e : employees) {
            if (e.getPosition().equals("Manager") || e.getPosition().equals("ViceManager")) {
                e.showInfo();
            }
        }
    }

    @Override
    public void showTotalSalaryByDepartment(int depId) {
        for (Department d : departments) {
            if (d.getDepartmentId() == depId) {
                System.out.println("Tổng lương phòng: " + d.totalSalary());
                return;
            }
        }
        System.out.println("Không tìm thấy phòng ban!");
    }
}
