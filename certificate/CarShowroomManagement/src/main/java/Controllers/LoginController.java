package Controllers;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.FileWriter;

public class LoginController {
    private static String loginName, password;
    
    public static void setLogin(String s) {
        loginName = s;
    }
    
    public static void setPassword(String s) {
        password = s;
    }

    public static String getLogin() {
        return loginName;
    }

    public static String getPassword() {
        return password;
    }

    public static boolean checkLogin(String loginName, String password) {
        readAccount();
        if (loginName.equals(LoginController.loginName) && (password.equals(LoginController.password))) {
            return false;
        } else {
           
            return true;
        }     
    }
    
    private static void readAccount() {
        String s = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("account.txt"));
            s = br.readLine();
            br.close();
        } catch (Exception e) {
            System.out.println("----------------------");
            System.out.println("Can not reach to data!!");
        }
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 32) {
                loginName = s.substring(start, i);
                start = i + 1; 
                break;
            }
        }
        
        password = s.substring(start);
    }
    
    public static void editAccount(String s) {
        try {
            FileWriter fw = new FileWriter("account.txt");
            fw.write(s);
            fw.close();
        } catch (Exception e) {
        }
    }
}
