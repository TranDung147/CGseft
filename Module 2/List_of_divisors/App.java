import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        System.out.println("The divisor of " + num + " is: ");
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                System.out.println(i + " ");
            }
        }
    }
}
