
package Views;

import Controllers.CustomersController;
import java.util.Scanner;

public class SearchCustomersMenu extends Menu{
    private Scanner sc = new Scanner(System.in);

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                System.out.println("---------------------");
                System.out.print("ID: ");
                CustomersController.searchByMkh(sc.nextLine());
                break;
            case 2:
                System.out.println("---------------------");
                System.out.print("Name: ");
                CustomersController.searchByName(sc.nextLine());
                break;
            case 3:
                System.out.println("---------------------");
                System.out.print("Phone number: ");
                CustomersController.searchByPhoneNum(sc.nextLine());
                break;
        }
    }
    
    
}
