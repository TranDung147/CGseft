import java.util.Stack;

public class App {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.pop();
        System.out.println("Top items of stack: " + stack.peek());
        System.out.println("Total items of stack: " + stack.size());
    }
}
