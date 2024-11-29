
package Views;

import Controllers.CarShowroomController;
import Controllers.LoginController;
import java.util.Scanner;

public class MainMenu extends Menu{

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                String[] choice1 = {"Add new employee", "View employess", "Edit employee", "Remove employee", "Search employee", "Back"};
                new EmployeeMenu().run("EMPLOYEES", choice1);
                break;
            case 2:
                String[] choice2 = {"Add new car", "View cars", "Edit car", "Search car", "Sell car", "Back"};
                new CarsMenu().run("CARS", choice2);
                break;
            case 3:
                String[] choice3 = {"View customers", "Search customers", "Back"};
                new CustomersMenu().run("CUSTOMERS", choice3);
                break;
            case 4:
                CarShowroomController.viewLog();
                break;
            case 5:
                editAccount();
                break;
        }
    }   

    private void editAccount() {
        Scanner sc = new Scanner(System.in);
        String loginName, password;
        System.out.println("-----EDIT ACCOUNT-----");
        System.out.print("Old password: ");
        password = sc.nextLine();
        if (password.equals(LoginController.getPassword())) {
            System.out.print("New login name: ");
            loginName = sc.nextLine();
            System.out.print("New password: ");
            password = sc.nextLine();
            String s = loginName + " " + password;
            LoginController.editAccount(s);
            System.out.println("-----------------");
            System.out.println("Edit success!!");
        } else {
            System.out.println("-----------------");
            System.out.println("Incorect!!");
        }
    }
}
