package Controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CheckInput {
    
    public static boolean checkInputMenu(int ch, String[] choice) {
        if ((ch < 1) || (ch > choice.length)) {
            return true;
        }
        return false;
    }
    
    public static boolean checkInputMenu(String ch) {
        for (int i = 0; i < ch.length(); i++) {
            if (!Character.isDigit(ch.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean checkAlpha(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean checkInputDob(String dob) {
//        int count = 0;
//        if (dob.length() == 10) {
//            for (int i = 0; i < dob.length(); i++) {
//                if ((i == 2) || (i == 5)) {
//                    if (dob.charAt(i) == '/') {
//                        count++;
//                    } else {
//                        System.out.println("----------------------");
//                        System.out.println("Invalid!! Date must be formed DD/MM/YYYY!!");
//                        System.out.println("----------------------");
//                        return true;
//                    }
//                } else {
//                    if (Character.isDigit(dob.charAt(i))) {
//                        count++;
//                    } else {
//                        System.out.println("----------------------");
//                        System.out.println("Invalid!! Date must be formed DD/MM/YYYY!!");
//                        System.out.println("----------------------");
//                        return true;
//                    }
//                }
//            }
//        } else {
//            System.out.println("Invalid!! Date must be formed DD/MM/YYYY!!");
//            return true;
//        }
//        
//        return false;

        if (dob.equals(LocalDate.parse(dob, DateTimeFormatter.ofPattern("DD/MM/YYYY")))) {
            return false;
        }
        System.out.println("----------------------");
        System.out.println("Invalid!! Date must be formed DD/MM/YYYY!!");
        System.out.println("----------------------");
        return true;
    }
    
    public static boolean checkInputNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
            } else {
                return true;
            }
        }
        return false;
    } 
}
