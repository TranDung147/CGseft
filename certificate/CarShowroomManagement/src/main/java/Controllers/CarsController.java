package Controllers;

import Models.Car;
import Models.Customer;
import com.mycompany.carshowroommanagement.CarShowroomManagement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.function.Predicate;

public class CarsController {
    
    public static boolean checkID(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                if (s.charAt(i) == 'C') {
                } else {
                    return true;
                }
            } else {
                if (Character.isDigit(s.charAt(i))) {  
                } else {
                    return true;
                }
            } 
        }
        return false;
    }
    
    public static void addCar(String brand, String name, String color, int madeYear, int price, int seat, int quantity, String id) {
        int count = 0;
        ArrayList<Car> cars = CarShowroomManagement.getCs().getCars();
        for (int i = 0; i < cars.size(); i++) {
            if (id.equals(cars.get(i).getId())) {
                count++;
                CarShowroomManagement.getCs().getCars().get(i).setQuantity(quantity + cars.get(i).getQuantity());
            }
        }
        
        if (count == 0) {
            CarShowroomManagement.getCs().getCars().add(new Car(brand, name, color, id, madeYear, price, seat, quantity));
        }
        CarShowroomController.saveCarData();
    }
    
    public static boolean checkExistence(String id) {
        ArrayList<Car> cars = CarShowroomManagement.getCs().getCars();
        for (int i = 0; i < cars.size(); i++) {
            if (id.equals(cars.get(i).getId())) {
                return false;
            }
        }
        return true;
    }
    
    public static void viewCars() {
        ArrayList<Car> cars = CarShowroomManagement.getCs().getCars();
        for (Car c: cars) {
            System.out.println(c);
        }
    }
 
    public static void editCar(String brand, String name, String color, int madeYear, int price, int seat, int quantity, String id) {
        ArrayList<Car> cars = CarShowroomManagement.getCs().getCars();
        for (int i = 0; i < cars.size(); i++) {
            if (id.equals(cars.get(i).getId())) {
                CarShowroomManagement.getCs().getCars().get(i).changeInfor(brand, name, color, id, madeYear, price, seat, quantity);
                break;
            }     
        }
        CarShowroomController.saveCarData();
    }
    
    public static boolean checkQuantity(String id, int quantity) {
        ArrayList<Car> cars = CarShowroomManagement.getCs().getCars();
        for (int i = 0; i < cars.size(); i++) {
            if (id.equals(cars.get(i).getId())) {
                if ((quantity < 1) || (quantity > cars.get(i).getQuantity())) {
                    return true;
                }
                break;
            }
        }
        return false;
    }
    
    public static void sellCars(String id, String name, String email, String address, String phoneNum, String mkh, String msnv, int quantity) {
        int indexCar = 0, indexCus = 0, totalCost = 0;
        int revenue = CarShowroomManagement.getCs().getRevenue();
        ArrayList<Car> cars = CarShowroomManagement.getCs().getCars();
        CarShowroomManagement.getCs().getCustomers().add(new Customer(name, email, address, phoneNum, mkh));
        for (int i = 0; i < cars.size(); i++) {
            if (id.equals(cars.get(i).getId())) {
                indexCar = i;
                break;
            }
        }
        ArrayList<Customer> customers = CarShowroomManagement.getCs().getCustomers();
        
        indexCus = customers.size() - 1;
        
        totalCost = cars.get(indexCar).getPrice() * quantity;
        
        CarShowroomManagement.getCs().getCustomers().get(indexCus).setLogs("Had bought " + quantity + " " + cars.get(indexCar).getBrand() + " ID: " + cars.get(indexCar).getId() + " || Total price: " + totalCost + "MIL || Time: " + LocalDateTime.now());
        CarShowroomManagement.getCs().setLogs("Customers: " + mkh + " had bought " + quantity + " " + cars.get(indexCar).getBrand() + " ID: " + cars.get(indexCar).getId() + " || Total price: " + totalCost + "MIL || Time: " + LocalDateTime.now());
        
        if (quantity < cars.get(indexCar).getQuantity()) {
            CarShowroomManagement.getCs().getCars().get(indexCar).setQuantity(cars.get(indexCar).getQuantity() - quantity);
        } else {
            CarShowroomManagement.getCs().getCars().remove(indexCar);
        }
        
        for (int i = 0; i < CarShowroomManagement.getCs().getEmployees().size(); i++) {
            if (msnv.equals(CarShowroomManagement.getCs().getEmployees().get(i).getMsnv())) {
                CarShowroomManagement.getCs().getEmployees().get(i).setNumCarSold(quantity + CarShowroomManagement.getCs().getEmployees().get(i).getNumCarSold());
            }
        }
        
        CarShowroomManagement.getCs().setRevenue(revenue + totalCost);
        CarShowroomController.saveCarData();
        CarShowroomController.saveLog();
        CarShowroomController.saveEmployeeData();
        CarShowroomController.saveCustomerData();
    }
    
    public static void sellCars(String id, String mkh, String msnv, int quantity) {
        int indexCar = 0, indexCus = 0, totalCost = 0;
        int revenue = CarShowroomManagement.getCs().getRevenue();
        ArrayList<Car> cars = CarShowroomManagement.getCs().getCars();
        for (int i = 0; i < cars.size(); i++) {
            if (id.equals(cars.get(i).getId())) {
                indexCar = i;
                break;
            }
        }
        ArrayList<Customer> customers = CarShowroomManagement.getCs().getCustomers();
        for (int i = 0; i < customers.size(); i++) {
            if (mkh.equals(customers.get(i).getMkh())) {
                indexCus = i;
            }
        }
        
        totalCost = cars.get(indexCar).getPrice() * quantity;
        
        CarShowroomManagement.getCs().getCustomers().get(indexCus).setLogs("Had bought " + quantity + " " + cars.get(indexCar).getBrand() + " ID: " + cars.get(indexCar).getId() + " || Total price: " + totalCost + "MIL || Time: " + LocalDateTime.now());
        CarShowroomManagement.getCs().setLogs("Customers: " + mkh + " had bought " + quantity + " " + cars.get(indexCar).getBrand() + " ID: " + cars.get(indexCar).getId() + " || Total price: " + totalCost + "MIL || Time: " + LocalDateTime.now());
        
        if (quantity < cars.get(indexCar).getQuantity()) {
            CarShowroomManagement.getCs().getCars().get(indexCar).setQuantity(cars.get(indexCar).getQuantity() - quantity);
        } else {
            CarShowroomManagement.getCs().getCars().remove(indexCar);
        }
        
        for (int i = 0; i < CarShowroomManagement.getCs().getEmployees().size(); i++) {
            if (msnv.equals(CarShowroomManagement.getCs().getEmployees().get(i).getMsnv())) {
                CarShowroomManagement.getCs().getEmployees().get(i).setNumCarSold(quantity + CarShowroomManagement.getCs().getEmployees().get(i).getNumCarSold());
            }
        }
        
        CarShowroomManagement.getCs().setRevenue(revenue + totalCost);
        CarShowroomController.saveCarData();
        CarShowroomController.saveLog();
        CarShowroomController.saveEmployeeData();
        CarShowroomController.saveCustomerData();
    }
    
    private static ArrayList<Car> search(Predicate<Car> p) {
        ArrayList<Car> cars = new ArrayList<>();
        for (Car c : CarShowroomManagement.getCs().getCars()) {
            if (p.test(c)) {
                cars.add(c);
            }
        }
        return cars;
    }
    
    public static void searchByID(String id) {
        ArrayList<Car> cars = search(p -> p.getId().equalsIgnoreCase(id));
        if (cars.size() == 0) {
            System.out.println("--------NULL--------");
        } else {
            System.out.println("--------------------");
            cars.get(0).display();
        }
    }
    
    public static void searchByBrand(String brand) {
        ArrayList<Car> cars = search(p -> p.getBrand().equalsIgnoreCase(brand));
        if (cars.size() == 0) {
            System.out.println("--------NULL--------");
        } else {
            System.out.println("--------------------");
            for (int i = 0; i < cars.size(); i++) {
                System.out.println((i + 1) + ". " + cars.get(i));
            }
        }
    }
    
    public static void searchByPrice(int price) {
        ArrayList<Car> cars = search(p -> p.getPrice() <= price);
        if (cars.size() == 0) {
            System.out.println("--------NULL--------");
        } else {
            System.out.println("--------------------");
            for (int i = 0; i < cars.size(); i++) {
                System.out.println((i + 1) + ". " + cars.get(i));
            }
        }
    }
    
    public static void searchByYear(int y) {
        ArrayList<Car> cars = search(p -> p.getMadeYear() == y);
        if (cars.size() == 0) {
            System.out.println("--------NULL--------");
        } else {
            System.out.println("--------------------");
            for (int i = 0; i < cars.size(); i++) {
                System.out.println((i + 1) + ". " + cars.get(i));
            }
        }
    }
}
