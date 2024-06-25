package Controllers;

import Views.Menu;

import java.util.Scanner;

public class MainMenu extends Menu {

    CarsController mercedes;
    Scanner sc;
    Validation val;

    public MainMenu() {
        mercedes = new CarsController();
        sc = new Scanner(System.in);
        val = new Validation();
    }

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                addCar();
                break;
            case 2:
                mercedes.viewCars();
                break;
            case 3:
                editCar();
                break;
            case 4:
                String title = "Search Menu";
                String choices[] = {"Search By ID", "Search By Brand", "Search By Price", "Search By Year", "Back"};
                new SearchCarsMenu().run(title, choices);
                break;
            case 5:
                deleteCar();
                break;
        }
    }

    private void addCar() {
        String brand = "", name = "", color = "", id = "", temp = "";
        int madeYear = 0, price = 0, seat = 0, quantity = 0;

        do {
            System.out.print("ID: ");
            id = sc.nextLine();
            if (mercedes.checkID(id)) {
                System.out.println("---------");
                System.out.println("ID must be formed: 'C**' (* is a number)");
                System.out.println("---------");
            }
        } while (mercedes.checkID(id));

        if (mercedes.checkExistence(id)) {
            System.out.print("Brand: ");
            brand = sc.nextLine();
            System.out.print("Name: ");
            name = sc.nextLine();
            System.out.print("Color: ");
            color = sc.nextLine();

            do {
                System.out.print("Year of manufacture: ");
                temp = sc.nextLine();
                if (val.checkInputNumber(temp)) {
                    System.out.println("----------------");
                    System.out.println("Year just contain number!!");
                    System.out.println("----------------");
                }
            } while (val.checkInputNumber(temp));
            madeYear = Integer.parseInt(temp);

            do {
                System.out.print("Price: ");
                temp = sc.nextLine();
                if (val.checkInputNumber(temp)) {
                    System.out.println("----------------");
                    System.out.println("Price just contain number!!");
                    System.out.println("----------------");
                }
            } while (val.checkInputNumber(temp));
            price = Integer.parseInt(temp);

            do {
                System.out.print("Number of seats: ");
                temp = sc.nextLine();
                if (val.checkInputNumber(temp)) {
                    System.out.println("----------------");
                    System.out.println("Number of seats just contain number!!");
                    System.out.println("----------------");
                }
            } while (val.checkInputNumber(temp));
            seat = Integer.parseInt(temp);
        }

        do {
            System.out.print("Quantity: ");
            temp = sc.nextLine();
            if (val.checkInputNumber(temp)) {
                System.out.println("----------------");
                System.out.println("Quantity just contain number!!");
                System.out.println("----------------");
            }
        } while (val.checkInputNumber(temp));
        quantity = Integer.parseInt(temp);

        mercedes.addCar(brand, name, color, madeYear, price, seat, quantity, id);
        System.out.println("--------------------");
        System.out.println("Add success!!");
    }

    private void editCar() {
        String brand = "", name = "", color = "", id = "", temp = "";
        int madeYear = 0, price = 0, seat = 0, quantity = 0;

        do {
            System.out.print("ID: ");
            id = sc.nextLine();
            if (mercedes.checkExistence(id)) {
                System.out.println("---------");
                System.out.println("Car does not exist!!");
                System.out.println("---------");
            }
        } while (mercedes.checkExistence(id));

        System.out.print("Brand: ");
        brand = sc.nextLine();
        System.out.print("Name: ");
        name = sc.nextLine();
        System.out.print("Color: ");
        color = sc.nextLine();

        do {
            System.out.print("Year of manufacture: ");
            temp = sc.nextLine();
            if (val.checkInputNumber(temp)) {
                System.out.println("----------------");
                System.out.println("Year just contain number!!");
                System.out.println("----------------");
            }
        } while (val.checkInputNumber(temp));
        madeYear = Integer.parseInt(temp);

        do {
            System.out.print("Price: ");
            temp = sc.nextLine();
            if (val.checkInputNumber(temp)) {
                System.out.println("----------------");
                System.out.println("Price just contain number!!");
                System.out.println("----------------");
            }
        } while (val.checkInputNumber(temp));
        price = Integer.parseInt(temp);

        do {
            System.out.print("Number of seats: ");
            temp = sc.nextLine();
            if (val.checkInputNumber(temp)) {
                System.out.println("----------------");
                System.out.println("Number of seats just contain number!!");
                System.out.println("----------------");
            }
        } while (val.checkInputNumber(temp));
        seat = Integer.parseInt(temp);

        do {
            System.out.print("Quantity: ");
            temp = sc.nextLine();
            if (val.checkInputNumber(temp)) {
                System.out.println("----------------");
                System.out.println("Quantity just contain number!!");
                System.out.println("----------------");
            }
        } while (val.checkInputNumber(temp));
        quantity = Integer.parseInt(temp);

        mercedes.editCar(brand, name, color, madeYear, price, seat, quantity, id);
        System.out.println("-------------------");
        System.out.println("Edit success!!");
    }

    private void deleteCar() {
        System.out.print("ID: ");
        String id = sc.nextLine();
        if (mercedes.checkExistence(id)) {
            System.out.println("---------");
            System.out.println("Car does not exist!!");
            System.out.println("---------");
        } else {
            mercedes.deleteCar(id);
            System.out.println("-------------------");
            System.out.println("Delete success!!");
        }
    }
}
