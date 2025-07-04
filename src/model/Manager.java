package model;

public class Manager extends Employee {
    private static final double ALLOWANCE = 5000000;
    public Manager(String id, String name, int age, String address, double baseSalary, int departmentId) {
        super(id, name, age, address, baseSalary, "Manager", departmentId);
    }
    @Override
    public double calculateSalary() {
        return getBaseSalary() + ALLOWANCE;
    }
}
