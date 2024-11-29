package Views;

import Controllers.EmployeesController;
import java.util.Scanner;

public class SearchEmployeesMenu extends Menu{
    private Scanner sc = new Scanner(System.in);

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                System.out.println("----------------------");
                System.out.print("Enter msnv: ");
                String msnv = sc.nextLine();
                EmployeesController.searchByMsnv(msnv);
                break;
            case 2:
                System.out.println("----------------------");
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                EmployeesController.searchByName(name);
                break;
            case 3:
                System.out.println("----------------------");
                System.out.print("Enter cccd: ");
                String cccd = sc.nextLine();
                EmployeesController.searchByCccd(cccd);
                break;
        }
    }
    
}
