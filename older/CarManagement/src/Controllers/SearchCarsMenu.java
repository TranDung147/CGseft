package Controllers;
import Views.Menu;


import java.util.Scanner;

public class SearchCarsMenu extends Menu {
    private Scanner sc;
    private CarsController carControl;
    private Validation val;

    public SearchCarsMenu() {
        sc = new Scanner(System.in);
        carControl = new CarsController();
        val = new Validation();
    }
    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                System.out.println("-------------------");
                System.out.print("ID: ");
                String id = sc.nextLine();
                carControl.searchByID(id);
                break;
            case 2:
                System.out.println("-------------------");
                System.out.print("Brand: ");
                String brand = sc.nextLine();
                carControl.searchByBrand(brand);
                break;
            case 3:
                System.out.println("-------------------");
                String price = "";
                do {
                    System.out.print("Price (MIL): ");
                    price = sc.nextLine();
                    if (val.checkInputNumber(price)) {
                        System.out.println("-----------------");
                        System.out.println("Invalid!!");
                        System.out.println("-----------------");
                    } else {
                        break;
                    }
                } while (true);
                carControl.searchByPrice(Integer.parseInt(price));
                break;
            case 4:
                System.out.println("-------------------");
                String year = "";
                do {
                    System.out.print("Year: ");
                    year = sc.nextLine();
                    if (val.checkInputNumber(year)) {
                        System.out.println("-----------------");
                        System.out.println("Invalid!!");
                        System.out.println("-----------------");
                    } else {
                        break;
                    }
                } while (true);
                carControl.searchByYear(Integer.parseInt(year));
                break;
        }
    }

}
