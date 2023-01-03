import java.util.EmptyStackException;

/**
 * Stack it is a type of arrayList by format LIFO(Last In First Out)
 * @param <E> type of Elements
 */
public class CustomStack<E> extends CustomArrayList<E> implements Iterable<E> {

    /**
     * Check if stack is empty
     * @return true if stack is empty
     */
    public boolean empty(){
        return isEmpty();
    }

    /**
     * Get the last Element of stack
     * @throws EmptyStackException if arrayList is empty
     * @throws IndexOutOfBoundsException index < 0 or index > size
     * @return last Element
     */
    public Object peek(){
        if (size() == 0){
            throw new EmptyStackException();
        }else return get(size() - 1);
    }

    /**
     * Get last Element and remove from stack
     * @throws EmptyStackException if arrayList is empty
     * @throws IndexOutOfBoundsException index < 0 or index > size
     * @return last Element
     */
    public Object pop(){
        if (size() == 0){
            throw new EmptyStackException();
        }else {
            Object popElement = peek();
            remove(size() - 1);
            return popElement;
        }
    }

    /**
     * Add Element to the last
     * @param e an Element
     * @return pushed Element
     */
    public Object push(E e){
        add(e);
        return e;
    }

    /**
     * Return last index of Element (same to lastIndexOf)
     * @param o an Element
     * @return index of Element
     */
    public int search(Object o){
        int i = lastIndexOf(o);
        if (i >= 0) return size() - i;
        return -1;
    }
}
