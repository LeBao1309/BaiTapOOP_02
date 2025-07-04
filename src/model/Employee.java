package model;

public abstract class Employee {
    private String id;
    private String name;
    private int age;
    private String address;
    private double baseSalary;
    private String position;
    private int departmentId;

    public Employee(String id, String name, int age, String address, double baseSalary, String position, int departmentId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.baseSalary = baseSalary;
        this.position = position;
        this.departmentId = departmentId;
    }

    public String getId() { return id; }
    public int getDepartmentId() { return departmentId; }
    public String getPosition() { return position; }
    public void setAddress(String address) { this.address = address; }
    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }
    public double getBaseSalary() { return baseSalary; }

    public abstract double calculateSalary();

    public void showInfo() {
        System.out.printf("ID: %s | Name: %s | Age: %d | Address: %s | BaseSalary: %.2f | Position: %s | DeptID: %d\n",
                id, name, age, address, baseSalary, position, departmentId);
    }
}
