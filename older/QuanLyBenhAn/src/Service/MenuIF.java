package Service;

import java.util.Scanner;
public abstract class MenuIF {
    private Scanner sc = new Scanner(System.in);
    private String title;
    private String [] choices;

    public MenuIF(String title, String[] choices) {
        this.title = title;
        this.choices = choices;
    }

    public void printMenu(String title, String[] choices) {
        System.out.println("=======" + title + "=======");
        for (int i = 0; i < choices.length; i++) {
            System.out.println(i+1 + ". " + choices[i]);
        }
        System.out.println("=====================");
    }

    public int getChoice() {
        System.out.print("Enter your choice: ");
        return sc.nextInt();
    }

    public void run() {
        int ch;
        while (true) {
            printMenu(title, choices);
            ch = getChoice();
            if (ch < 1 || ch > choices.length) {
                System.out.println("invalid");
            } else if (ch == choices.length) {
                System.out.println("good bye");
                break;
            } else {
                execute(ch);
            }
        }
    }

    public abstract void execute(int ch);
}