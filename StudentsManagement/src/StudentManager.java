package src;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    public static Student createNewStudent(ArrayList<Student> students, Scanner scanner){
        System.out.print("Enter id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = Integer.parseInt(scanner.nextLine());
        Student student = new Student(id, name, age);
        students.add(student);
        return student;
    }
    public static void showListStudent(ArrayList<Student> students){
        for (Student item : students) {
            System.out.println(item);
        }
    }
    public static void removeStudent(ArrayList<Student> students, Scanner scanner){
        System.out.print("Enter index: ");
        int indexRemove = Integer.parseInt(scanner.nextLine());
        students.remove(indexRemove);
    }
    public static void showStudentByIndex(ArrayList<Student> students, Scanner scanner){
        System.out.print("Enter index: ");
        int indexShow = Integer.parseInt(scanner.nextLine());
        Student studentShow = students.get(indexShow);
        System.out.println(studentShow);
    }
    public static void editStudent(ArrayList<Student> students, Scanner scanner){
        System.out.print("Enter index student update: ");
        int indexUpdate = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter ID: ");
        int idUpdate = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter name: ");
        String nameUpdate = scanner.nextLine();
        System.out.print("Enter age: ");
        int ageUpdate = Integer.parseInt(scanner.nextLine());

        if (indexUpdate >= 0 && indexUpdate < students.size()){
            Student studentUpdate = new Student(idUpdate, nameUpdate, ageUpdate);
            students.set(indexUpdate, studentUpdate);
        } else {
            System.out.print("Invalid index! ");
        }
    }
}
