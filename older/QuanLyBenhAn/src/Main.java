import Service.MainMenu;

public class Main {
    public static void main(String[] args) {
        String title = "Medical Record Management";
        String[] choices = {"Add New Medical Record", "Delete Medical Record", "View Medical Records", "Exit"};
        MainMenu menu = new MainMenu(title, choices);
        menu.run();
    }
}