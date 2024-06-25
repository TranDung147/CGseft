package Models;

public class Car {
    private String brand, name, color, id;
    private int madeYear, price, seat, quantity;

    public Car() {
    }

    public Car(String brand, String name, String color, String id, int madeYear, int price, int seat, int quantity) {
        this.brand = brand;
        this.name = name;
        this.color = color;
        this.id = id;
        this.madeYear = madeYear;
        this.price = price;
        this.seat = seat;
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMadeYear() {
        return madeYear;
    }

    public void setMadeYear(int madeYear) {
        this.madeYear = madeYear;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ID: " + id + " || " + brand + " " + name + " " + madeYear + " || Price: " + price + "MIL || Quantity: " + quantity;
    }

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Brand: " + brand);
        System.out.println("Name: " + name);
        System.out.println("Color: " + color);
        System.out.println("Proceduce year: " + madeYear);
        System.out.println("Number of seats: " + seat);
        System.out.println("Price: " + price + "MIL");
        System.out.println("Quantity: " + quantity);

    }

    public void changeInfor(String brand, String name, String color, String id, int madeYear, int price, int seat, int quantity) {
        this.brand = brand;
        this.name = name;
        this.color = color;
        this.id = id;
        this.madeYear = madeYear;
        this.price = price;
        this.seat = seat;
        this.quantity = quantity;
    }
}
