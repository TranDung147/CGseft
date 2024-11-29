package Controllers;

import Models.Employee;
import com.mycompany.carshowroommanagement.CarShowroomManagement;
import java.util.ArrayList;
import java.util.function.Predicate;

public class EmployeesController {
    
    public static void addEmployee(String msnv, String name, String dob, String address, String cccd, String phoneNum, int salary) {
        CarShowroomManagement.getCs().getEmployees().add(new Employee(msnv, name, dob, address, cccd, phoneNum, salary));
        CarShowroomController.saveEmployeeData();
    }
    
    public static void viewEmployees() {
        System.out.println("----------------------");
        for (int i = 0; i < CarShowroomManagement.getCs().getEmployees().size(); i++) {
            System.out.println((i + 1) + ". " + CarShowroomManagement.getCs().getEmployees().get(i));
        }
    }
    
    public static boolean checkExistence(String msnv) {
        ArrayList<Employee> employees = CarShowroomManagement.getCs().getEmployees();
        for (int i = 0; i < employees.size(); i++) {
            if (msnv.equals(employees.get(i).getMsnv())) {
                return true;
            }
        }
        return false;
    }
    
    public static void editEmployee(String msnv, String name, String dob, String address, String cccd, String phoneNum, int salary, int numCarsSold) {
        for (int i = 0; i < CarShowroomManagement.getCs().getEmployees().size(); i++) {
            if (msnv.equals(CarShowroomManagement.getCs().getEmployees().get(i).getMsnv())) {
                CarShowroomManagement.getCs().getEmployees().get(i).changeInfor(msnv, name, dob, address, cccd, phoneNum, salary, numCarsSold);
                break;
            }
        }
        CarShowroomController.saveEmployeeData();
    }
    
    public static void removeEmployee(String msnv) {
        for (int i = 0; i < CarShowroomManagement.getCs().getEmployees().size(); i++) {
            if (msnv.equals(CarShowroomManagement.getCs().getEmployees().get(i).getMsnv())) {
                CarShowroomManagement.getCs().getEmployees().remove(i);
            }
        }
        CarShowroomController.saveEmployeeData();
    }
    
    private static ArrayList<Employee> search(Predicate<Employee> p) {
        ArrayList<Employee> employees = new ArrayList<>();
        for (Employee e : CarShowroomManagement.getCs().getEmployees()) {
            if (p.test(e)) {
                employees.add(e);
            }
        }
        return employees;
    }
    
    public static void searchByMsnv(String msnv) {
        ArrayList<Employee> employees = search(p -> p.getMsnv().equals(msnv));
        if (employees.size() == 0) {
            System.out.println("---------NULL---------");
        } else {
            System.out.println("----------------------");
            employees.get(0).display();
        }
    }
    
    public static void searchByName(String name) {
        ArrayList<Employee> employees = search(p -> p.getName().contains(name));
        if (employees.size() == 0) {
            System.out.println("---------NULL---------");
        } else {
            System.out.println("----------------------");
            for (int i = 0; i < employees.size(); i++) {
                System.out.println((i + 1) + ". " + employees.get(i));
            }
        }
    }
    
    public static void searchByCccd(String cccd) {
        ArrayList<Employee> employees = search(p -> p.getCccd().equals(cccd));
        if (employees.size() == 0) {
            System.out.println("---------NULL---------");
        } else {
            System.out.println("----------------------");
            employees.get(0).display();
        }
    }
}
