package model;

public class ViceManager extends Employee {
    private static final double ALLOWANCE = 3000000;
    public ViceManager(String id, String name, int age, String address, double baseSalary, int departmentId) {
        super(id, name, age, address, baseSalary, "ViceManager", departmentId);
    }
    @Override
    public double calculateSalary() {
        return getBaseSalary() + ALLOWANCE;
    }
}
