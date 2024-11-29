package Controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Validation {

    public boolean checkInputMenu(int ch, String[] choice) {
        if ((ch < 1) || (ch > choice.length)) {
            return true;
        }
        return false;
    }

    public boolean checkInputMenu(String ch) {
        for (int i = 0; i < ch.length(); i++) {
            if (!Character.isDigit(ch.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean checkAlpha(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean checkInputDob(String dob) {
        if (dob.equals(LocalDate.parse(dob, DateTimeFormatter.ofPattern("DD/MM/YYYY")))) {
            return false;
        }
        System.out.println("----------------------");
        System.out.println("Invalid!! Date must be formed DD/MM/YYYY!!");
        System.out.println("----------------------");
        return true;
    }

    public boolean checkInputNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
            } else {
                return true;
            }
        }
        return false;
    }

}
