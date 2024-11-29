package source;

public class Bike {
    private int id;
    private String name;

    public Bike(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void run(){
        System.out.println("Bike is running");
    }
}
