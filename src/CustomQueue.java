import java.util.NoSuchElementException;

/**
 * Queue it is a type of queue by format FIFO(First In First Out)
 * @param <E> type of queue
 */
public class CustomQueue<E> extends CustomLinkedList<E> implements Iterable<E> {
    /**
     * Add to the end of queue an Element (same to addLast)
     * @throws NullPointerException if Element is null
     * @param e an Element
     * @return true or false
     */
    public boolean offer(E e){
        if (e == null) throw new NullPointerException();
        addLast(e);
        return true;
    }

    /**
     * Add to the start of queue an Element (same to addFirst)
     * @throws NullPointerException if Element is null
     * @param e an Element
     * @return true or false
     */
    public boolean offerFirst(E e){
        if (e == null) throw new NullPointerException();
        addFirst(e);
        return true;
    }

    /**
     * Add to the end of queue an Element (same to addLast)
     * @throws NullPointerException if Element is null
     * @param e an Element
     * @return true or false
     */
    public boolean offerLast(E e){
        if (e == null) throw new NullPointerException();
        addLast(e);
        return true;
    }

    /**
     * Getting first Element of queue (same to getFirst)
     * @return an Element
     */
    public Object peek(){
        return getFirst();
    }

    /**
     * Getting first Element of queue (same to getFirst)
     * @return an Element
     */
    public Object peekFirst(){
        return peek();
    }

    /**
     * Getting last Element of queue (same to getLast)
     * @return an Element
     */
    public Object peekLast(){
        return getLast();
    }

    /**
     * Removing first Element of queue (same to removeFirst)
     * @throws NoSuchElementException if queue is empty
     * @return removed Element
     */
    public Object pop(){
        return removeFirst();
    }

    /**
     * Removing first Element of queue (same to removeFirst)
     * @throws NoSuchElementException if queue is empty
     * @return removed Element
     */
    public Object poll(){
        return pop();
    }

    /**
     * Removing first Element of queue (same to removeFirst)
     * @throws NoSuchElementException if queue is empty
     * @return removed Element
     */
    public Object pollFirst(){
        return pop();
    }

    /**
     * Removing last Element of queue (same to removeLast)
     * @throws NoSuchElementException if queue is empty
     * @return removed Element
     */
    public Object pollLast(){
        return removeLast();
    }

    /**
     * Add Element to first position
     * @throws NullPointerException if Element == null
     * @param e an Element
     */
    public void push(E e){
        if (e == null) throw new NullPointerException();
        addFirst(e);
    }
}
