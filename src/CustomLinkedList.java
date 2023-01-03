import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Custom LinkedList with a lot of useful functions
 * @param <E> Type of Objects
 */
public class CustomLinkedList<E> implements Iterable<E>{


    /**
     * Last Element of linkedList
     */
    private Element<E> last;

    /**
     * First Element of linkedList
     */
    private Element<E> first;

    /**
     * Current size of linkedList
     */
    private int size = 0;

    /**
     * Return current size of linkedList
     * @return size of linkedList
     */
    public int size(){
        return size;
    }

    /**
     * This method add an Element at the last position (same to addLast)
     * @param e an Element
     */
    public void add(E e){
        addLast(e);
    }

    public Object[] toArray(){
        Object[] arr = new Object[size];
        int index = 0;
        for (Element<E> x = first; x != null; x = x.next){
            arr[index] = x.element;
            index++;
        }
        return arr;
    }

    /**
     * This method add an Element into linkedList<p>
     * If index == 0 Element will add to the first position(same to addFirst)<p>
     * If index == size Element will add to the end (same to addLast)<p>
     * If index > 0 && index < size Element will add into linkedList
     * @param index position of Element in linkedList
     * @throws IndexOutOfBoundsException if index incorrect
     * @param e an Element
     */
    public void add(int index, E e){
        checkIndex(index);
        if (index == 0) addFirst(e);
        else if (index == size) addLast(e);
        else {
            Element<E> currentElement = first;
            for (int i = 1; i <= index; i++) {
                currentElement = currentElement.next;
            }
            Element<E> previous = currentElement.previous;
            Element<E> next = currentElement;
            currentElement = new Element<>(previous, e, next);
            previous.next = currentElement;
            next.previous = currentElement;
            size++;
        }
    }

    /**
     * Getting first Element (same to getFirst)
     * @return an Element
     */
    public Object element(){
        return getFirst();
    }

    /**
     * Getting first Element
     * @return an Element
     */
    public Object getFirst(){
        Element<E> element = first;
        if (first == null){
            throw new NoSuchElementException();
        }
        return element.element;
    }

    /**
     * Getting last Element
     * @return an Element
     */
    public Object getLast(){
        Element<E> element = last;
        if (last == null){
            throw new NoSuchElementException();
        }
        return element.element;
    }

    /**
     * Getting Element by index<p>
     * If index == 0 (same to getFirst)<p>
     * If index == size - 1 (same to getLast)
     * @param index position Of Element in linkedList
     * @throws IndexOutOfBoundsException if index incorrect
     * @return an Element
     */
    public Object get(int index){
        checkIndex(index);
        if (index == 0) return getFirst();
        else if (index == size - 1) return getLast();
        Element<E> element = first;
        for (int i = 1; i <= index; i++) {
            element = element.next;
        }
        return element.element;
    }

    /**
     * Delete all Elements from linkedList
     */
    public void clear(){
        for (Element<E> x = first; x != null; ){
            Element<E> n = x.next;
            x.next = null;
            x.element = null;
            x.previous = null;
            x = n;
        }
        size = 0;
        first = null;
        last = null;
    }

    /**
     * Return boolean information about Element in linked list<p>
     * If Element exist return true else false
     * @param o an Element
     * @return true or false
     */
    public boolean contains(Object o){
        for (Element<E> x = first; x != null; x = x.next){
            if (x.element.equals(o)) return true;
        }
        return false;
    }

    /**
     * Checking index to correct
     * @param index position of Element in linkedList
     */
    private void checkIndex(int index) {
        if (index > size || index < 0) throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
    }

    /**
     * Add Element at the last position
     * @param e an Element
     */
    public void addLast(E e) {
        final Element<E> l = last;
        final Element<E> newAdd = new Element<>(l, e, null);
        last = newAdd;
        if (l == null){
            first = newAdd; // if element only one in the linkedList this
                            // Element will be also the first
        }else {
            l.next = newAdd;
        }
        size++;
    }

    /**
     * Add Element to first position
     * @param e an Element
     */
    public void addFirst(E e){
        final Element<E> f = first;
        final Element<E> newAdd = new Element<>(null, e, f);
        first = newAdd;
        if (f == null){
            last = newAdd; // if element only one in the linkedList this
                           // Element will be also the last
        }else {
            f.previous = newAdd;
        }
        size++;
    }

    /**
     * Return first index of Element
     * @param o an Element
     * @return position of Element or -1
     */
    public int indexOf(Object o){
        int index = 0;
        for (Element<E> x = first; x != null; x = x.next){
            if (x.element.equals(o)) return index;
            index++;
        }
        return -1;
    }

    /**
     * Return last index of Element
     * @param o an Element
     * @return position of Element or -1
     */
    public int lastIndexOf(Object o){
        int index = 0;
        int indexOfElement = -1;
        for (Element<E> x = first; x != null; x = x.next){
            if (x.element.equals(o)) indexOfElement = index;
            index++;
        }
        return indexOfElement;
    }

    /**
     * Class of Elements in linkedList
     * @param <E> type Of Elements
     */
    private static class Element<E>{
        /**
         * Link to the previous Element
         */
        Element<E> previous;
        /**
         * Current Element
         */
        E element;
        /**
         * Link to the next Element
         */
        Element<E> next;

        public Element(Element<E> previous, E element, Element<E> next) {
            this.previous = previous;
            this.element = element;
            this.next = next;
        }
    }

    /**
     * Removing first Element of linkedList(same to removeFirst)
     * @throws NoSuchElementException if linkedList is empty
     * @return removed Element
     */
    public Object remove(){
        return removeFirst();
    }

    /**
     * Removing first Element of linkedList
     * @throws NoSuchElementException if linkedList is empty
     * @return removed Element
     */
    public Object removeFirst() {
        if (size == 0) throw new NoSuchElementException();
        Element<E> element = first.next;
        Object deletedElement = first.element;
        first.element = null;
        first.next = null;
        first = element;
        first.previous = null;
        size--;
        return deletedElement;
    }

    /**
     * Removing last Element of linkedList
     * @throws NoSuchElementException if linkedList is empty
     * @return removed Element
     */
    public Object removeLast(){
        if (size == 0) throw new NoSuchElementException();
        Element<E> element = last.previous;
        Object deletedElement = last.element;
        last.element = null;
        last.previous = null;
        last = element;
        last.next = null;
        size--;
        return deletedElement;
    }

    /**
     * Removing an Element from linkedList
     * @throws NoSuchElementException if linkedList is empty
     * @param o an Element
     * @return true if Element was removed or false
     */
    public boolean remove(Object o){
        if (size == 0) throw new NoSuchElementException();
        if (o.equals(last.element)) {
            removeLast();
            return true;
        } else if (o.equals(first.element)) {
            removeFirst();
            return true;
        }

        Element<E> nextElement;
        Element<E> previousElement;


        for (Element<E> x = first; x != null; x = x.next){
            if (x.element.equals(o)){
                nextElement = x.next;
                previousElement = x.previous;
                nextElement.previous = previousElement;
                previousElement.next = nextElement;
                x.next = null;
                x.previous = null;
                x.element = null;
                return true;
            }
        }
        size--;
        return false;
    }

    /**
     * Removing an Element by index
     * @throws IndexOutOfBoundsException if index incorrect
     * @param index position of Element
     * @return removed Element
     */
    public Object remove(int index){
        checkIndex(index);
        if (index == 0) return removeFirst();
        else if (index == size - 1) return  removeLast();
        Element<E> nextElement;
        Element<E> previousElement;
        Object deletedElement;
        int count = 0;
        for (Element<E> x = first; x != null; x = x.next){
            if (count == index){
                deletedElement = x.element;
                nextElement = x.next;
                previousElement = x.previous;
                nextElement.previous = previousElement;
                previousElement.next = nextElement;
                x.next = null;
                x.previous = null;
                x.element = null;
                size--;
                return deletedElement;
            }
            count++;
        }
        return null;
    }

    /**
     * Return true if linkedList is empty
     * @return true or false
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * Custom Iterator
     * @return new Iterator
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int current = 0;
            Element<E> currentElement = first;

            /**
             * @return boolean meaning about next object
             */
            @Override
            public boolean hasNext() {
                return current < size && currentElement != null;
            }

            /**
             * @return next object
             */
            @Override
            public E next() {
                current++;
                Element<E> nextElement = currentElement;
                currentElement = currentElement.next;
                return nextElement.element;
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomLinkedList<?> that)) return false;
        return size == that.size &&
                Objects.equals(getLast(), that.getLast()) &&
                Objects.equals(getFirst(), that.getFirst());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLast(), getFirst(), size);
    }

    /**
     * Override method toString
     * @return linkedList toString
     */
    @Override
    public String toString() {
        if (size == 0) return "[]";
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (Element<E> x = first; x != null; x = x.next){
            str.append(x.element).append(", ");
        }
        return str.delete(str.length() - 2, str.length()).append("]").toString();
    }
}
