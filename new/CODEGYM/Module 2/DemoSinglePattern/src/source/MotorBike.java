package source;

public class MotorBike {
    private int id;
    private String name;

    public MotorBike(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void run() {
        System.out.println("Bike is running");
    }
}

