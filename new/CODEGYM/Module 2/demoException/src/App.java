public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.add(3,4));
        try {
            System.out.println(calculator.divide(3,0));
            System.out.println(calculator.divide(3,4));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(calculator.add(3,4));
    }

}