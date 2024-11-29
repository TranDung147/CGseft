package Views;

import Controllers.CarsController;
import Controllers.CheckInput;
import java.util.Scanner;

public class SearchCarsMenu extends Menu{
    private Scanner sc = new Scanner(System.in);
        
    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                System.out.println("-------------------");
                System.out.print("ID: ");
                String id = sc.nextLine();
                CarsController.searchByID(id);
                break;
            case 2:
                System.out.println("-------------------");
                System.out.print("Brand: ");
                String brand = sc.nextLine();
                CarsController.searchByBrand(brand);
                break;
            case 3:
                System.out.println("-------------------");
                String price = "";
                do {                    
                    System.out.print("Price (MIL): ");
                    price = sc.nextLine();
                    if (CheckInput.checkInputNumber(price)) {
                        System.out.println("-----------------");
                        System.out.println("Invalid!!");
                        System.out.println("-----------------");
                    } else {
                        break;
                    }
                } while (true);
                CarsController.searchByPrice(Integer.parseInt(price));
                break;
            case 4:
                System.out.println("-------------------");
                String year = "";
                do {                    
                    System.out.print("Year: ");
                    year = sc.nextLine();
                    if (CheckInput.checkInputNumber(year)) {
                        System.out.println("-----------------");
                        System.out.println("Invalid!!");
                        System.out.println("-----------------");
                    } else {
                        break;
                    }
                } while (true);
                CarsController.searchByYear(Integer.parseInt(year));
                break;
        }
    }
    
}
