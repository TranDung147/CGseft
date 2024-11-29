package CalculatorLifetime;

import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Person person = new Person();
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Nhap ngay: ");
            int day = scanner.nextInt();
            person.setDay(day);

            System.out.println("Nhap thang: ");
            int month = scanner.nextInt();
            person.setMonth(month);

            System.out.println("Nhap nam: ");
            int year = scanner.nextInt();
            person.setYear(year);

            System.out.println("You have lived " + calculateDaysLived(person.getDay(), person.getMonth(), person.getYear()) + " days.");
        } catch (NumberFormatException) {
            System.out.println(e.getMessage());
        }
    }
    private static int calculateDaysLived(int day, int month, int year) {
        int daysLived = 0;
        for (int i = year; i < getcurrentYear(); i++) {
            daysLived += isLeapYear(i)? 366 : 365;
        }
        for (int i = 1; i < month; i++) {
            daysLived += getDaysInMonth(i, year);
        }
        daysLived += day;
        return daysLived;
    }
    }
}
