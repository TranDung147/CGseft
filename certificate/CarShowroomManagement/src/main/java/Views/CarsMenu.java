
package Views;

import Controllers.CarsController;
import Controllers.CheckInput;
import Controllers.CustomersController;
import Controllers.EmployeesController;
import java.util.Scanner;

public class CarsMenu extends Menu{
    private Scanner sc = new Scanner(System.in);

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                System.out.println("------------------");
                addCar();
                break;
            case 2:
                System.out.println("------------------");
                CarsController.viewCars();
                break;
            case 3:
                System.out.println("------------------");
                editCar();
                break;
            case 4:
                String[] choice = {"Search by ID", "Search by brand", "Search by price", "Search by year of manufacture", "Back"};
                new SearchCarsMenu().run("SEARCH CAR", choice);
                break;
            case 5:
                System.out.println("------------------");
                sellCar();
                break;
        }
    }
    
    private void addCar() {
        Scanner sc = new Scanner(System.in);
        String brand = "", name = "", color = "", id = "", temp = "";
        int madeYear = 0, price = 0, seat = 0, quantity = 0;
        
        do {            
            System.out.print("ID: ");
            id = sc.nextLine();
            if (CarsController.checkID(id)) {
                System.out.println("---------");
                System.out.println("ID must be formed: 'C**' (* is a number)");
                System.out.println("---------");
            }
        } while (CarsController.checkID(id));
        
        if (CarsController.checkExistence(id)) {
            System.out.print("Brand: ");
            brand = sc.nextLine();
            System.out.print("Name: ");
            name = sc.nextLine();
            System.out.print("Color: ");
            color = sc.nextLine();

            do {            
                System.out.print("Year of manufacture: ");
                temp = sc.nextLine();
                if (CheckInput.checkInputNumber(temp)) {
                    System.out.println("----------------");
                    System.out.println("Year just contain number!!");
                    System.out.println("----------------");
                }
            } while (CheckInput.checkInputNumber(temp));
            madeYear = Integer.parseInt(temp);

            do {            
                System.out.print("Price: ");
                temp = sc.nextLine();
                if (CheckInput.checkInputNumber(temp)) {
                    System.out.println("----------------");
                    System.out.println("Price just contain number!!");
                    System.out.println("----------------");
                }
            } while (CheckInput.checkInputNumber(temp));
            price = Integer.parseInt(temp);

            do {            
                System.out.print("Number of seats: ");
                temp = sc.nextLine();
                if (CheckInput.checkInputNumber(temp)) {
                    System.out.println("----------------");
                    System.out.println("Number of seats just contain number!!");
                    System.out.println("----------------");
                }
            } while (CheckInput.checkInputNumber(temp));
            seat = Integer.parseInt(temp);
        }
        
        do {            
            System.out.print("Quantity: ");
            temp = sc.nextLine();
            if (CheckInput.checkInputNumber(temp)) {
                System.out.println("----------------");
                System.out.println("Quantity just contain number!!");
                System.out.println("----------------");
            }
        } while (CheckInput.checkInputNumber(temp));
        quantity = Integer.parseInt(temp);
        
        CarsController.addCar(brand, name, color, madeYear, price, seat, quantity, id);
        System.out.println("--------------------");
        System.out.println("Add success!!");
    }
    
    private void editCar() {
        Scanner sc = new Scanner(System.in);
        String brand = "", name = "", color = "", id = "", temp = "";
        int madeYear = 0, price = 0, seat = 0, quantity = 0;
        
        do {            
            System.out.print("ID: ");
            id = sc.nextLine();
            if (CarsController.checkExistence(id)) {
                System.out.println("---------");
                System.out.println("Car does not exist!!");
                System.out.println("---------");
            }
        } while (CarsController.checkExistence(id));
        
        System.out.print("Brand: ");
        brand = sc.nextLine();
        System.out.print("Name: ");
        name = sc.nextLine();
        System.out.print("Color: ");
        color = sc.nextLine();

        do {            
            System.out.print("Year of manufacture: ");
            temp = sc.nextLine();
            if (CheckInput.checkInputNumber(temp)) {
                System.out.println("----------------");
                System.out.println("Year just contain number!!");
                System.out.println("----------------");
            }
        } while (CheckInput.checkInputNumber(temp));
        madeYear = Integer.parseInt(temp);

        do {            
            System.out.print("Price: ");
            temp = sc.nextLine();
            if (CheckInput.checkInputNumber(temp)) {
                System.out.println("----------------");
                System.out.println("Price just contain number!!");
                System.out.println("----------------");
            }
        } while (CheckInput.checkInputNumber(temp));
        price = Integer.parseInt(temp);

        do {            
            System.out.print("Number of seats: ");
            temp = sc.nextLine();
            if (CheckInput.checkInputNumber(temp)) {
                System.out.println("----------------");
                System.out.println("Number of seats just contain number!!");
                System.out.println("----------------");
            }
        } while (CheckInput.checkInputNumber(temp));
        seat = Integer.parseInt(temp);
        
        do {            
            System.out.print("Quantity: ");
            temp = sc.nextLine();
            if (CheckInput.checkInputNumber(temp)) {
                System.out.println("----------------");
                System.out.println("Quantity just contain number!!");
                System.out.println("----------------");
            }
        } while (CheckInput.checkInputNumber(temp));
        quantity = Integer.parseInt(temp);
        
        CarsController.editCar(brand, name, color, madeYear, price, seat, quantity, id);
        System.out.println("-------------------");
        System.out.println("Edit success!!");
    }   
    
    private void sellCar() {
        Scanner sc = new Scanner(System.in);
        String id, name = "", email = "", address = "", phoneNum = "", mkh, msnv, temp;
        int quantity;  
        
        System.out.print("MSNV seller: ");
        msnv = sc.nextLine();
        if (!EmployeesController.checkExistence(msnv)) {
            System.out.println("----------");
            System.out.println("Employee does not exist!!");
            return;
        }      
                  
        System.out.print("Enter ID car: ");
        id = sc.nextLine();
        if (CarsController.checkExistence(id)) {
            System.out.println("--------------");
            System.out.println("Car does not exist!!");
            return;
        }
                
        do {     
            do {                
                System.out.print("Enter quantity: ");
                temp = sc.nextLine();
                if (CheckInput.checkInputNumber(temp)) {
                System.out.println("----------");
                System.out.println("Quantity just contain number!!");
                System.out.println("----------");
                } 
            } while (CheckInput.checkInputNumber(temp));
            quantity = Integer.parseInt(temp);
            
            if (CarsController.checkQuantity(id, quantity)) {
                System.out.println("-----------");
                System.out.println("Invalid!!");
                System.out.println("-----------");
            }
        } while (CarsController.checkQuantity(id, quantity));
                    
        
        
        System.out.print("Customer's ID: ");
        mkh = sc.nextLine();
        
        if (CustomersController.checkExistence(mkh)) {
            System.out.print("Customer's name: ");
            name = sc.nextLine();
            System.out.print("Customer's email: ");
            email = sc.nextLine();
            System.out.print("Customer's address: ");
            address = sc.nextLine();
            
            do {                
                System.out.print("Customer's phone number: ");
                phoneNum = sc.nextLine();
                if (CheckInput.checkInputNumber(phoneNum)) {
                    System.out.println("-----------");
                    System.out.println("Phone number just contain number!!");
                    System.out.println("------------");         
                }
            } while (CheckInput.checkInputNumber(phoneNum));
            
            CarsController.sellCars(id, name, email, address, phoneNum, mkh, msnv, quantity);
        } else {
            CarsController.sellCars(id, mkh, msnv, quantity);
        }
        
        System.out.println("------------------------");
        System.out.println("TRANSACTION SUCCESS!!");
    }
}
