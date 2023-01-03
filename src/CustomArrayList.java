import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/**
 * Custom dynamic array with a lot of useful functions
 * @param <E> Type of Objects
 */
public class CustomArrayList<E> implements Iterable<E>{

    /**
     * Standard size of array
     */
    private static int CAPACITY = 10;

    /**
     * Size of arrayList
     */
    private int size = 0;

    /**
     * Array which will change its size
     */
    private Object[] arrayList;

    /**
     * Empty array
     */
    private static final Object[] EMPTY_ARRAY_LIST = new Object[]{};


    /**
     * Standard Constructor for arrayList with size - 10
     */
    public CustomArrayList() {
        arrayList = new Object[10];
    }

    /**
     * Constructor which can change the beginning size of arrayList
     * @param newCapacity beginning size of arrayList
     */
    public CustomArrayList(int newCapacity){
        if (newCapacity > 10){
            this.arrayList = new Object[newCapacity];
        } else if (newCapacity == 0) {
            this.arrayList = EMPTY_ARRAY_LIST;
        }else {
            throw new IllegalArgumentException("Wrong capacity");
        }
    }

    /**
     * Adding at the end of arraylist an Element
     * @param e added Element
     */
    public void add(E e){
        if (size < CAPACITY){
            arrayList[size] = e;
            size++;
        }else {
            increaseInSizeForAdd(e);
        }
    }

    /**
     * Adding by index of arrayList an Element
     * @param index index of added Element
     * @param e added Element
     */
    public void add(int index, E e){
        addByIndex(index, e);
    }

    /**
     * Adding by index into arrayList<p>
     * If size == capacity. Capacity will increase<p>
     * If index == size, Element will add in the end<p>
     * Else arrayList will copy and Element add into center
     * @param index index of added Element
     * @param e added Element
     */
    private void addByIndex(int index, E e){
        checkSizeOfArrayList(index);
        if (size >= CAPACITY){
            increaseInSizeForAdd(e);
        }else if (index == size){
            arrayList[index] = e;
            size++;
        }else {
            System.arraycopy(arrayList, index, arrayList,
                    index + 1, size - index);
            arrayList[index] = e;
            size++;
        }
    }

    /**
     * Show size of arrayList
     * @return size of arrayList
     */
    public int size(){
        return size;
    }

    /**
     * Delete all Elements from the arrayList
     */
    public void clear(){
        size = 0;
        arrayList = EMPTY_ARRAY_LIST;
    }

    /**
     * Look for an Element in arrayList
     * @param o an Element
     * @return true if Element contains and false if is not
     */
    public boolean contains(Object o){
        for (int i = 0; i < size; i++) {
            if (arrayList[i].equals(o))return true;
        }
        return false;
    }

    /**
     * Getting an Element by index, if index incorrect will throw an Exception
     * @param index of Element
     * @throws IndexOutOfBoundsException index < 0 or index > size
     * @return An Element by index
     */
    public Object get(int index){
       checkSizeOfArrayList(index);
       return arrayList[index];
    }

    /**
     * return an index of the first Element
     * @param o an Element
     * @return index of Element or -1 if Element is not real
     */
    public int indexOf(Object o){
        for (int i = 0; i < size; i++) {
            if (arrayList[i].equals(o))return i;
        }
        return -1;
    }

    /**
     * return an index of the last Element
     * @param o an Element
     * @return index of last Element or -1 if Element is not real
     */
    public int lastIndexOf(Object o){
        int lastIndex = -1;
        for (int i = 0; i < size; i++) {
            if (arrayList[i].equals(o)) lastIndex = i;
        }
        return lastIndex;
    }

    /**
     * remove an Element by index
     * @param index of the removed Element
     * @throws IndexOutOfBoundsException index < 0 or index > size
     * @return removed Element
     */
    public Object remove(int index){
        checkSizeOfArrayList(index);
        Object deletedElement = arrayList[index];
        if (arrayList.length - 1 - index >= 0)
            System.arraycopy(arrayList, index + 1, arrayList, index, arrayList.length - 1 - index);
        size--;
        return deletedElement;
    }

    /**
     * remove an Element
     * @param o removed Element
     * @return true if Element was removed
     */
    public boolean remove(Object o){
        int deleteIndex = -1;
        for (int i = 0; i < size; i++) {
            if (arrayList[i].equals(o)) {
                deleteIndex = i;
                break;
            }
        }
        if (deleteIndex == -1) return false;
        if (arrayList.length - 1 - deleteIndex >= 0)
            System.arraycopy(arrayList, deleteIndex + 1, arrayList, deleteIndex, arrayList.length - 1 - deleteIndex);
        size--;
        return true;
    }

    /**
     * Make from arrayList an array
     * @return an array
     */
    public Object[] toArray(){
        Object[] array = new Object[size];
        System.arraycopy(arrayList, 0, array, 0, array.length);
        return array;
    }

    /**
     * Change an Element by index
     * @param index of Element
     * @param e an Element
     */
    public Object set(int index, E e){
        checkSizeOfArrayList(index);
        Object oldElement = arrayList[index];
        arrayList[index] = e;
        return oldElement;
    }


    /**
     * make capacity equals size
     */
    public void trimToSize(){
        CAPACITY = size;
    }

    /**
     * Check index if it is correct
     * @param index index
     */
    private void checkSizeOfArrayList(int index) {
        if (index > size || index < 0) throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
    }

    /**
     * Make new arrayList with bigger size and adding an Element
     * @param e an Element
     */
    private void increaseInSizeForAdd(E e) {
        CAPACITY *= 2;
        Object[] oldArrayList = arrayList;
        arrayList = new Object[CAPACITY];
        System.arraycopy(oldArrayList, 0, arrayList, 0, oldArrayList.length);
        arrayList[size] = e;
        size++;
    }

    /**
     * Check if size of arrayList is zero
     * @return true if arrayList is empty
     */
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomArrayList<?> that)) return false;
        return size == that.size &&
                Arrays.equals(arrayList, that.arrayList);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(arrayList);
        return result;
    }

    /**
     * Override method toString
     * @return arrayList toString
     */
    @Override
    public String toString() {
        if (size == 0) return "[]";
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int i = 0; i < size - 1; i++) {
            str.append(arrayList[i]).append(", ");
        }
        return str.append(arrayList[size-1]).append("]").toString();
    }

    /**
     * Custom Iterator
     * @return new Iterator
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int current = 0;

            /**
             * @return boolean meaning about next object
             */
            @Override
            public boolean hasNext() {
                return current < size && arrayList[current] != null;
            }

            /**
             * @return next object
             */
            @Override
            @SuppressWarnings("unchecked")
            public E next() {
                return (E) arrayList[current++];
            }
        };
    }
}