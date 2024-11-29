package test;

import Controllers.MainMenu;

public class Main {
    public static void main(String[] args) {
        String title = "Welcome to CarManagement";
        String[] choices = {"Add new car", "View cars", "Edit car", "Search car", "Delete car", "Back"};
        new MainMenu().run(title, choices);
    }
}
