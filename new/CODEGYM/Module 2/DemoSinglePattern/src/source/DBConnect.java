package source;
public class DBConnect {
    private static int totalObject = 0;
    private static DBConnect instance = null;
    private DBConnect(){

    }

    public static DBConnect getInstance() {
        if (instance == null) {
            instance = new DBConnect();
            totalObject++;
        }
        return instance;
    }

    public void connnect(){
        System.out.println("Connecting database");
    }

    public static int getTotalObject(){
        return totalObject;
    }
}
