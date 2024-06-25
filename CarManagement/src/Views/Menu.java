package Views;
import Controllers.Validation;
import java.util.Scanner;

public abstract class Menu {
    private void printMenu(String title, String[] choice) {
        System.out.println("-----" + title + "------");
        for (int i = 0; i < choice.length; i++) {
            System.out.println((i + 1) + ". " + choice[i]);
        }
    }

    private int getChoice(String title, String[] choice) {
        Scanner sc = new Scanner(System.in);
        printMenu(title, choice);
        String ch = "";

        do {
            System.out.println("--------------");
            System.out.print("Your choice: ");
            try {
                ch = sc.nextLine();
                if (new Validation().checkInputMenu(ch)) {
                    System.out.println("----------------");
                    System.out.println("Invalid!!");
                } else if (new Validation().checkInputMenu(Integer.parseInt(ch), choice)) {
                    System.out.println("----------------");
                    System.out.println("Invalid!!");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("----------------");
                System.out.println("Invalid!!");
            }
        } while (true);

        return Integer.parseInt(ch);
    }

    public void run(String title, String[] choice) {
        int ch;

        while (true) {
            ch = getChoice(title, choice);
            if (ch == choice.length) {
                break;
            }
            else {
                execute(ch);
            }
        }
    }

    public abstract void execute(int ch);
}
