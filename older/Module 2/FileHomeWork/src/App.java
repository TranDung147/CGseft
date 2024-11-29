import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User user = new User();
        File myFile = new File("./src/data.txt");
        int choice;

        do {
            printMenu();
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    if (myFile.exists()) {
                        if (myFile.canRead()) {
                            try {
                                FileReader reader = new FileReader(myFile);
                                BufferedReader bufferedReader = new BufferedReader(reader);
                                String contentOfLine = null;
                                while ((contentOfLine = bufferedReader.readLine()) != null) {
                                    System.out.println(contentOfLine);
                                }
                                bufferedReader.close();
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }

                    } else {
                        System.out.println("File not found");
                    }
                    break;
                case 2:
                    if (myFile.exists()) {
                        if (myFile.canWrite()) {
                            try {
                                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(myFile, true));

                                System.out.println("Enter id: ");
                                int id = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Enter user name: ");
                                String userName = sc.nextLine();

                                bufferedWriter.write("ID: " + id + " name: " + userName);
                                bufferedWriter.newLine();
                                bufferedWriter.close();
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }

                        }
                    } else {
                        System.out.println("File not found");
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
            }
        } while (choice != 3);

    }

    public static void printMenu() {
        System.out.println("===================Menu======================");
        System.out.println("1. Hien thi danh sach user.");
        System.out.println("2. Add user.");
        System.out.println("3. Exit....");
        System.out.print("Enter number: ");
    }
}