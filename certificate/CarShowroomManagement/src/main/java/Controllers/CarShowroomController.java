package Controllers;

import Models.Car;
import Models.Customer;
import Models.Employee;
import com.mycompany.carshowroommanagement.CarShowroomManagement;
import java.io.FileWriter;

public class CarShowroomController {
    public static void viewLog() {
        for (String s: CarShowroomManagement.getCs().getLogs()) {
            System.out.println(s);
        }
        
        System.out.println("Revenue: " + CarShowroomManagement.getCs().getRevenue() + "MIL");
    }
    
    public static void saveEmployeeData() {
        try {
            FileWriter fw = new FileWriter("employeeoutput.txt");
            for (Employee e0 : CarShowroomManagement.getCs().getEmployees()) {
                String s = "ID=" + e0.getMsnv() + "; name=" + e0.getName() + "; dob=" + e0.getDob() 
                        + "; address=" + e0.getAddress() + "; cccd=" + e0.getCccd() + "; phone=" + e0.getPhoneNum() 
                        + "; salary=" + e0.getSalary() + "; carsold=" + e0.getNumCarSold();
                fw.write(s);
                fw.write("\n");
            }
            fw.close();
        } catch (Exception e) {
        }
    }
    
    public static void saveCustomerData() {
        try {
            FileWriter fw = new FileWriter("customerdata.txt");
            for (Customer c : CarShowroomManagement.getCs().getCustomers()) {
                String s = "mkh=" + c.getMkh() + "; name=" + c.getName() + "; address=" + c.getAddress() 
                        + "; email=" + c.getEmail() + "; phone=" + c.getPhoneNum();
                fw.write(s);
                fw.write("\n");
            }
            fw.close();
        } catch (Exception e) {
        }
    }
    
    public static void saveCarData() {
        try {
            FileWriter fw = new FileWriter("caroutput.txt");
            for (Car c : CarShowroomManagement.getCs().getCars()) {
                String s = "brand=" + c.getBrand() +"; name=" + c.getName() + "; color=" + c.getColor() 
                        + "; id=" + c.getId() + "; madeyear=" + c.getMadeYear() + "; price=" + c.getPrice() 
                        + "; seat=" + c.getSeat() + "; quantity=" + c.getQuantity();
                fw.write(s);
                fw.write("\n");
            }
            fw.close();
        } catch (Exception e) {
        }
    }
    
    public static void saveLog() {
        try {
            FileWriter fw = new FileWriter("logs.txt");
            for (String s : CarShowroomManagement.getCs().getLogs()) {
                fw.write(s);
                fw.write("\n");
            }
            fw.write("Revenue: " + CarShowroomManagement.getCs().getRevenue() + " MIL");
            fw.close();
        } catch (Exception e) {
        }
    }
}
