public class App {
    public static void main(String[] args) {
        Node<Integer> n1 = new Node<Integer>(10);
        Node<Integer> n2 = new Node<Integer>(8);
        Node<Integer> n3 = new Node<Integer>(20);
        Node<Integer> n4 = new Node<Integer>(9);

        BinaryTree myTree = new BinaryTree(n1);
        myTree.insert(n2);
        myTree.insert(n3);
        myTree.insert(n4);

        System.out.println(n2.right);
    }
}
