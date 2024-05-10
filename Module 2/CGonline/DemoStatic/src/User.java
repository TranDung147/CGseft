public class User {
    public int id;
    public String name;
    public static String group = "C0224M1";

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static String getGroup(){
        return User.group;
    }
}
