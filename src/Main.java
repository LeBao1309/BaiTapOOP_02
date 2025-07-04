import model.*;
import service.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        EmployeeManagement management = new EmployeeManagementImpl();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("=== MENU ===");
            System.out.println("1. Thêm phòng ban");
            System.out.println("2. Cập nhật thông tin phòng ban");
            System.out.println("3. Thêm nhân viên");
            System.out.println("4. Cập nhật thông tin nhân viên");
            System.out.println("5. Hiển thị danh sách phòng ban");
            System.out.println("6. Hiển thị nhân viên theo phòng ban");
            System.out.println("7. Hiển thị tất cả nhân viên");
            System.out.println("8. Hiển thị phó phòng, trưởng phòng");
            System.out.println("9. Tính tổng lương từng phòng");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1: {
                    System.out.print("Nhập mã phòng: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Nhập tên phòng: ");
                    String name = sc.nextLine();
                    System.out.print("Nhập địa chỉ phòng: ");
                    String addr = sc.nextLine();
                    management.addDepartment(new Department(id, name, addr));
                    break;
                }
                case 2: {
                    System.out.print("Nhập mã phòng cần sửa: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Tên mới: ");
                    String name = sc.nextLine();
                    System.out.print("Địa chỉ mới: ");
                    String addr = sc.nextLine();
                    management.updateDepartment(id, name, addr);
                    break;
                }
                case 3: {
                    System.out.print("Chọn loại nhân viên (1.Staff, 2.ViceManager, 3.Manager): ");
                    int t = sc.nextInt(); sc.nextLine();
                    System.out.print("ID: ");
                    String eid = sc.nextLine();
                    System.out.print("Tên: ");
                    String ename = sc.nextLine();
                    System.out.print("Tuổi: ");
                    int age = sc.nextInt(); sc.nextLine();
                    System.out.print("Địa chỉ: ");
                    String eaddr = sc.nextLine();
                    System.out.print("Lương cơ bản: ");
                    double baseSalary = sc.nextDouble(); sc.nextLine();
                    System.out.print("Mã phòng: ");
                    int depId = sc.nextInt(); sc.nextLine();
                    Employee emp = null;
                    if (t == 1)
                        emp = new Staff(eid, ename, age, eaddr, baseSalary, depId);
                    else if (t == 2)
                        emp = new ViceManager(eid, ename, age, eaddr, baseSalary, depId);
                    else if (t == 3)
                        emp = new Manager(eid, ename, age, eaddr, baseSalary, depId);
                    if (emp != null) {
                        management.addEmployee(emp);
                    }
                    break;
                }
                case 4: {
                    System.out.print("Nhập ID nhân viên: ");
                    String eid = sc.nextLine();
                    System.out.print("Địa chỉ mới: ");
                    String eaddr = sc.nextLine();
                    System.out.print("Lương cơ bản mới: ");
                    double baseSalary = sc.nextDouble(); sc.nextLine();
                    management.updateEmployee(eid, eaddr, baseSalary);
                    break;
                }
                case 5:
                    management.showDepartments();
                    break;
                case 6: {
                    System.out.print("Nhập mã phòng: ");
                    int depId = sc.nextInt(); sc.nextLine();
                    management.showEmployeesByDepartment(depId);
                    break;
                }
                case 7:
                    management.showAllEmployees();
                    break;
                case 8:
                    management.showManagers();
                    break;
                case 9: {
                    System.out.print("Nhập mã phòng: ");
                    int depId = sc.nextInt(); sc.nextLine();
                    management.showTotalSalaryByDepartment(depId);
                    break;
                }
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }
}
