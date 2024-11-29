import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class read {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dob = sc.nextLine();
       
        LocalDateTime ld = null;
        try {
            DateTimeFormatter fomatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
            ld = LocalDateTime.parse(dob, fomatter);
            System.out.println(ld);
        } catch (Exception e) {
            System.out.println("wrong");
        }
        
        System.out.println(ld);
    }  
}
