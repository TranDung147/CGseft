package com.mycompany.carshowroommanagement;

import Controllers.LoginController;
import Models.CarShowroom;
import Views.MainMenu;
import java.util.Scanner;


public class CarShowroomManagement {
    private static CarShowroom cs = new CarShowroom();

    public static CarShowroom getCs() {
        return cs;
    }
 
    private static void welcome() {
        Scanner sc = new Scanner(System.in);
        String loginName, password;
        while (true) {            
            System.out.println("------WELCOME TO CAR SHOWROOM------");
            System.out.print("Login name: ");
            loginName = sc.nextLine();
            System.out.print("Password: ");
            password = sc.nextLine();
            
            if (LoginController.checkLogin(loginName.trim(), password.trim())) {
                System.out.println("------------------------");
                System.out.println("This account does not exist!!");
            } else {
                System.out.println("------------------------");
                System.out.println("Login success!!");
                String[] choice = {"Employees", "Cars", "Customers", "Transaction logs", "Edit account", "Exit"}; 
                new MainMenu().run("MENU", choice);
                break;
            }
        }   
    }
    
    public static void main(String[] args) {
        welcome();
    }
}
