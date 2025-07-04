package model;

public class Staff extends Employee {
    public Staff(String id, String name, int age, String address, double baseSalary, int departmentId) {
        super(id, name, age, address, baseSalary, "Staff", departmentId);
    }
    @Override
    public double calculateSalary() {
        return getBaseSalary();
    }
}
