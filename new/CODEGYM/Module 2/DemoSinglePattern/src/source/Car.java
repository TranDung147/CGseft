package source;

public class Car {
    private int id;
    private String name;

    public Car(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void run(){
        System.out.println("Car is running");
    }
}
