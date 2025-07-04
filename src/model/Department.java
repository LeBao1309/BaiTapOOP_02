package model;
import java.util.ArrayList;
import java.util.List;

public class Department {
    private int departmentId;
    private String departmentName;
    private String departmentAddress;
    private List<Employee> employees = new ArrayList<>();

    public Department(int departmentId, String departmentName, String departmentAddress) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentAddress = departmentAddress;
    }
    public int getDepartmentId() { return departmentId; }
    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }
    public void setDepartmentAddress(String address) { this.departmentAddress = address; }
    public List<Employee> getEmployees() { return employees; }
    public void addEmployee(Employee e ){employees.add(e);}
    public void showEmployees(){
        if(employees.isEmpty()){
            System.out.println("No employees in this department.");
        } else {
            System.out.printf("Employees in Department %s:\n", departmentName);
            for (Employee e : employees) {
                e.showInfo();
            }
        }
    }
    public double totalSalary(){
        double sum = 0;
        for (Employee e : employees) sum += e.calculateSalary();
        return sum;
    }
}
