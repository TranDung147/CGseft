import src.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import src.StudentManager;
public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("1: Create new student");
        System.out.println("2: Show list student");
        System.out.println("3: Remove students");
        System.out.println("4: Show student by index: ");
        System.out.println("5: Edit student: ");
        System.out.println("6: Exit");
        System.out.println("========================================================================");
        int choice = 0;
        while (choice != 6) {
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    StudentManager.createNewStudent(students, scanner);
                    break;
                case 2:
                    StudentManager.showListStudent(students);
                    break;
                case 3:
                    StudentManager.removeStudent(students, scanner);
                    break;
                case 4:
                    StudentManager.showStudentByIndex(students, scanner);
                    break;
                case 5:
                    StudentManager.editStudent(students, scanner);
                    break;
                case 6:
                    System.out.println("Exit!");
                default:
                    System.out.println("Invalid choice, please try again!");
                    break;
            }
            System.out.println("1: Create new student");
            System.out.println("2: Show list student");
            System.out.println("3: Remove students");
            System.out.println("4: Show student by index: ");
            System.out.println("5: Edit student: ");
            System.out.println("6: Exit");
            System.out.println("================================================================");
        }
    }
}












