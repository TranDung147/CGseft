package Views;

import Controllers.CustomersController;
import com.mycompany.carshowroommanagement.CarShowroomManagement;
import java.util.Scanner;

public class CustomersMenu extends Menu{
    private Scanner sc = new Scanner(System.in);
    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                if (CarShowroomManagement.getCs().getCustomers().size() == 0) {
                    System.out.println("-----------NULL-----------");
                } else {
                    System.out.println("-----------------");
                }
                CustomersController.viewCustomers();
                break;
            case 2:
                String[] choice = {"Search by ID", "Search by name", "Search by phone number", "Back"};
                new SearchCustomersMenu().run("SEARCH CUSTOMER", choice);
                break;
        }
    }
    
}
