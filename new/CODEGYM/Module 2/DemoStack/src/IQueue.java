public interface IQueue<E> {
    boolean offer(E item);
    E poll();
    E remove();

}
