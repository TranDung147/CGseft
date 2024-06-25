package Controllers;

import Models.Car;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.function.Predicate;

public class CarsController {

    public boolean checkID(String s) {
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

    public void addCar(String brand, String name, String color, int madeYear, int price, int seat, int quantity, String id) {
        int count = 0;
        ArrayList<Car> cars = loadCarData();
        for (int i = 0; i < cars.size(); i++) {
            if (id.equals(cars.get(i).getId())) {
                count++;
                cars.get(i).setQuantity(quantity + cars.get(i).getQuantity());
                break;
            }
        }

        if (count == 0) {
            cars.add(new Car(brand, name, color, id, madeYear, price, seat, quantity));
        }
        saveCarData(cars);
    }

    public boolean checkExistence(String id) {
        ArrayList<Car> cars = loadCarData();
        for (int i = 0; i < cars.size(); i++) {
            if (id.equals(cars.get(i).getId())) {
                return false;
            }
        }
        return true;
    }

    public void viewCars() {
        ArrayList<Car> cars = loadCarData();
        for (Car c: cars) {
            System.out.println(c);
        }
    }

    public void editCar(String brand, String name, String color, int madeYear, int price, int seat, int quantity, String id) {
        ArrayList<Car> cars = loadCarData();
        for (int i = 0; i < cars.size(); i++) {
            if (id.equals(cars.get(i).getId())) {
                cars.get(i).changeInfor(brand, name, color, id, madeYear, price, seat, quantity);
                break;
            }
        }
        saveCarData(cars);
    }

    public boolean checkQuantity(String id, int quantity) {
        ArrayList<Car> cars = loadCarData();
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

    private ArrayList<Car> search(Predicate<Car> p) {
        ArrayList<Car> cars = loadCarData();
        ArrayList<Car> result = new ArrayList<Car>();
        for (Car c : cars) {
            if (p.test(c)) {
                result.add(c);
            }
        }
        return result;
    }

    public void searchByID(String id) {
        ArrayList<Car> cars = search(p -> p.getId().equalsIgnoreCase(id));
        if (cars.size() == 0) {
            System.out.println("--------NULL--------");
        } else {
            System.out.println("--------------------");
            cars.get(0).display();
        }
    }

    public void searchByBrand(String brand) {
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

    public void searchByPrice(int price) {
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

    public void searchByYear(int y) {
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

    public void deleteCar(String id) {
        ArrayList<Car> cars = loadCarData();
        for (int i = 0; i < cars.size(); i++) {
            if (id.equals(cars.get(i).getId())) {
                cars.remove(i);
                break;
            }
        }
        saveCarData(cars);
    }
    private ArrayList<Car> loadCarData() {
        ArrayList<Car> cars = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/data/data.csv"));
            String line = br.readLine();
            while (line != null) {
                ArrayList<String> dataArrayList = new ArrayList<>();
                String[] s = line.split(";");
                for (int i = 0; i < s.length; i++) {
                    String[] datas = s[i].trim().split("=");
                    dataArrayList.add(datas[1]);
                }
                line = br.readLine();
                cars.add(new Car(dataArrayList.get(0), dataArrayList.get(1), dataArrayList.get(2), dataArrayList.get(3), Integer.parseInt(dataArrayList.get(4)), Integer.parseInt(dataArrayList.get(5)), Integer.parseInt(dataArrayList.get(6)), Integer.parseInt(dataArrayList.get(7))));
            }
            br.close();
        } catch (Exception e) {
        }
        return cars;
    }
    private void saveCarData(ArrayList<Car> rollRoyce) {
        ArrayList<Car> cars = rollRoyce;
        try {
            FileWriter fw = new FileWriter("src/data/data.csv");
            for (Car c : cars) {
                String s = "brand=" + c.getBrand() +"; name=" + c.getName() + "; color=" + c.getColor()
                        + "; id=" + c.getId() + "; madeyear=" + c.getMadeYear() + "; price=" + c.getPrice()
                        + "; seat=" + c.getSeat() + "; quantity=" + c.getQuantity();
                fw.write(s);
                fw.write("\n");
            }
            fw.close();
        } catch (Exception e) {
        }
    }


    public static void main(String[] args) {
        CarsController cc = new CarsController();
        ArrayList<Car> cars = cc.loadCarData();
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
