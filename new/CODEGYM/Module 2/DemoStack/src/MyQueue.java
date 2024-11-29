public class MyQueue<E> implements IQueue<E> {
    private E[] elements;
    private int limit;

    public MyQueue(E[] elements){
        this.elements = elements;
        this.limit = elements.length;
    }
    @Override
    public boolean offer(E item) {
        if (elements.length == this.limit) {}
        return false;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E remove() {
        return null;
    }
}
