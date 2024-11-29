public class BinaryTree {
    public Node<Integer> root;
    public BinaryTree(Node<Integer> root) {
        this.root = root;
    }

    public void insert(Node<Integer> node) {
        Node<Integer> currentNode = this.root;
        Node<Integer> p = currentNode;
        //Tim ra node goc cua cay con cuoi cung
        while(currentNode != null) {
            p = currentNode;
            if (currentNode.data < node.data) {
                currentNode = currentNode.right;
            } else if (currentNode.data > node.data){
                currentNode = currentNode.left;
            }
        }
        //insert new node vao vi tri can them
        if (p.data < node.data) {
            p.right = node;
        } else {
            p.left = node;
        }
    }
}
