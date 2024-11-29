import javax.swing.text.Style;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Map<String, Student> students = new HashMap<String, Student>();
        boolean isLogin = false;
        Scanner scanner = new Scanner(System.in);
        Student s1 = new Student(1, "Pham Van Loc", "1234");
        Student s2 = new Student(2, "Pham Van Huy", "1234");

        students.put(s1.getName(), s1);
        students.put(s2.getName(), s2);


        while (!isLogin){
            System.out.println("Enter your name");
            String name = scanner.nextLine();
            System.out.println("Enter your password");
            String password = scanner.nextLine();

            Student s = students.get(name);
            if (s!= null){
                if (s.getPassword().equals(password)){
                    isLogin = true;

                    Map<String, Student> userLogin = new HashMap<String, Student>();
                    userLogin.put(s.getName(), s);
                    System.out.println("Login successful");
                } else {
                    System.out.println("Login fail");
                }
            }
        }

        System.out.println("Student login");
    }
}
