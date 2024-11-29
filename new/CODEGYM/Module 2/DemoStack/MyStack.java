public class MyStack<E> implements IStack<E>{
    private E[] elements;
    private int size = 0;

    public MyStack(){
        elements = (E[]) new Object[size];
    }
    @Override
    public void push(E item) {
        E[] newElements = (E[]) new Object[elements.length +1];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        newElements[elements.length] = item;
        elements = newElements;
    }

    @Override
    public E pop() {
        E itemTop = elements[elements.length - 1];
        E[] newElements = (E[]) new Object[elements.length - 1];
        for (int i = 0; i < elements.length - 1; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        return itemTop;
    }

    @Override
    public E peek() {
        return elements[elements.length - 1];
    }

    @Override
    public boolean isEmpty() {
        return elements.length == 0;
    }

    @Override
    public int search(E item) {
        return 0;
    }

    @Override
    public int getSize() {
        return elements.length;
    }
}

