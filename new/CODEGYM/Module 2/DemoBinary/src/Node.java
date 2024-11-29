public class Node<E> {
    public E data;
    public Node<E> left;
    public Node<E> right;

    public Node(E data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
