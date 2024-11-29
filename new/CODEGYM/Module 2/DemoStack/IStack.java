public interface IStack<E> {
    void push(E item);
    E pop();
    E peek();
    boolean isEmpty();
    int search(E item);
    int getSize();
}
