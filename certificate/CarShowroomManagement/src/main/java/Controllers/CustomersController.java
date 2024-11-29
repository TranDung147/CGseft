package Controllers;

import Models.Customer;
import com.mycompany.carshowroommanagement.CarShowroomManagement;
import java.util.ArrayList;
import java.util.function.Predicate;

public class CustomersController {
    public static boolean checkExistence(String mkh) {
        ArrayList<Customer> c = CarShowroomManagement.getCs().getCustomers();
        for (int i = 0; i < c.size(); i++) {
            if (mkh.equals(c.get(i).getMkh())) {
                return false;
            }
            break;
        }
        return true;
    }
    
    public static void viewCustomers() {
        for (int i = 0; i < CarShowroomManagement.getCs().getCustomers().size(); i++) {
            System.out.println((i + 1) + ". " + CarShowroomManagement.getCs().getCustomers().get(i));
        }
    }
    
    private static ArrayList<Customer> search(Predicate<Customer> p) {
        ArrayList<Customer> c = new ArrayList<>();
        for (Customer customer : CarShowroomManagement.getCs().getCustomers()) {
            if (p.test(customer)) {
                c.add(customer);
            }
        }
        return c;
    }
    
    public static void searchByMkh(String mkh) {
        ArrayList<Customer> c = search(p -> p.getMkh().equals(mkh));
        if (c.size() == 0) {
            System.out.println("---------NULL----------");
        } else {
            System.out.println("------------------------");
            c.get(0).display();
        }
    } 
    
    public static void searchByName(String name) {
        ArrayList<Customer> c = search(p -> p.getName().contains(name));
        if (c.size() == 0) {
            System.out.println("---------NULL----------");
        } else {
            System.out.println("-----------------------");
            for (int i = 0; i < c.size(); i++) {
                System.out.println((i + 1) + ". " + c.get(i));
            }
        }
    }
    
    public static void searchByPhoneNum(String pn) {
        ArrayList<Customer> c = search(p -> p.getPhoneNum().equals(pn));
        if (c.size() == 0) {
            System.out.println("---------NULL----------");
        } else {
            System.out.println("-----------------------");
            c.get(0).display();
        }
    }
}
