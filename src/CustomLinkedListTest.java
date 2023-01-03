import org.junit.Test;
import org.junit.function.ThrowingRunnable;

import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Test for customLinkedList
 */
public class CustomLinkedListTest {
    private final LinkedList<String> linkedList = new LinkedList<>();
    private final CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();

    private void feelLists(){
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");

        customLinkedList.add("1");
        customLinkedList.add("2");
        customLinkedList.add("3");
        customLinkedList.add("4");
    }

    private void clearLists(){
        linkedList.clear();
        customLinkedList.clear();
    }

    @Test
    public void size() {
        feelLists();
        assertEquals(linkedList.size(), customLinkedList.size());
        clearLists();
    }

    @Test
    public void add() {
        feelLists();
        assertArrayEquals(linkedList.toArray(), customLinkedList.toArray());
        clearLists();
    }

    @Test
    public void addByIndex() {
        feelLists();

        linkedList.add(1, "12");
        customLinkedList.add(1, "12");

        linkedList.add(linkedList.size(), "10");
        customLinkedList.add(customLinkedList.size(), "10");

        linkedList.add(0, "50");
        customLinkedList.add(0, "50");

        assertArrayEquals(linkedList.toArray(), customLinkedList.toArray());
        clearLists();
    }

    @Test
    public void element() {
        feelLists();
        assertEquals(linkedList.element(), customLinkedList.element());
        clearLists();
    }

    @Test
    public void getFirst() {
        feelLists();
        assertEquals(linkedList.getFirst(), customLinkedList.getFirst());
        clearLists();
    }

    @Test
    public void getLast() {
        feelLists();
        assertEquals(linkedList.getLast(), customLinkedList.getLast());
        clearLists();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get() {
        feelLists();
        assertEquals(linkedList.get(0), customLinkedList.get(0));
        assertEquals(linkedList.get(linkedList.size() - 1),
                customLinkedList.get(customLinkedList.size() - 1));
        assertEquals(linkedList.get(2), customLinkedList.get(2));
        assertThrows(IndexOutOfBoundsException.class, (ThrowingRunnable) customLinkedList.get(20));
        clearLists();
    }

    @Test
    public void clear() {
        feelLists();
        linkedList.clear();
        customLinkedList.clear();
        assertArrayEquals(linkedList.toArray(), customLinkedList.toArray());
    }

    @Test
    public void contains() {
        feelLists();
        assertEquals(linkedList.contains("1"), customLinkedList.contains("1"));
        assertEquals(linkedList.contains("123"), customLinkedList.contains("123"));
        clearLists();
    }

    @Test
    public void addLast() {
        feelLists();
        linkedList.addLast("12");
        customLinkedList.addLast("12");
        assertArrayEquals(linkedList.toArray(), customLinkedList.toArray());
        clearLists();
    }

    @Test
    public void addFirst() {
        feelLists();
        linkedList.addFirst("12");
        customLinkedList.addFirst("12");
        assertArrayEquals(linkedList.toArray(), customLinkedList.toArray());
        clearLists();
    }

    @Test
    public void indexOf() {
        feelLists();
        assertEquals(linkedList.indexOf("1"), customLinkedList.indexOf("1"));
        assertEquals(linkedList.indexOf("10"), customLinkedList.indexOf("10"));
        clearLists();
    }

    @Test
    public void lastIndexOf() {
        feelLists();
        linkedList.add("1");
        linkedList.add("1");
        customLinkedList.add("1");
        customLinkedList.add("1");

        assertEquals(linkedList.lastIndexOf("1"), customLinkedList.lastIndexOf("1"));
        assertEquals(linkedList.lastIndexOf("2"), customLinkedList.lastIndexOf("2"));
        clearLists();
    }

    @Test
    public void remove() {
        feelLists();
        assertTrue(customLinkedList.remove("1"));
        linkedList.remove("1");
        assertArrayEquals(linkedList.toArray(), customLinkedList.toArray());
        clearLists();
    }

    @Test
    public void removeFirst() {
        feelLists();
        linkedList.removeFirst();
        customLinkedList.removeFirst();
        assertArrayEquals(linkedList.toArray(), customLinkedList.toArray());
        clearLists();
    }

    @Test
    public void removeLast() {
        feelLists();
        linkedList.removeLast();
        customLinkedList.removeLast();
        assertArrayEquals(linkedList.toArray(), customLinkedList.toArray());
        clearLists();
    }

    @Test
    public void removeObject() {
        feelLists();
        linkedList.remove("1");
        customLinkedList.remove("1");
        assertArrayEquals(linkedList.toArray(), customLinkedList.toArray());
        clearLists();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeByIndex() {
        feelLists();
        linkedList.remove(1);
        customLinkedList.remove(1);

        assertArrayEquals(linkedList.toArray(), customLinkedList.toArray());
        assertEquals(linkedList.remove(1), customLinkedList.remove(1));
        assertThrows(IndexOutOfBoundsException.class,
                (ThrowingRunnable) customLinkedList.remove(20));
        clearLists();
    }

    @Test
    public void isEmpty() {
        feelLists();
        assertEquals(linkedList.isEmpty(), customLinkedList.isEmpty());
        clearLists();
        assertEquals(linkedList.isEmpty(), customLinkedList.isEmpty());
    }

    @Test
    public void testEquals() {
        feelLists();
        LinkedList<String> linkedList1 = new LinkedList<>();
        CustomLinkedList<String> customLinkedList1 = new CustomLinkedList<>();

        linkedList1.add("1");
        linkedList1.add("2");
        linkedList1.add("3");
        customLinkedList1.add("1");
        customLinkedList1.add("2");
        customLinkedList1.add("3");

        assertEquals(linkedList.equals(linkedList1),
                customLinkedList.equals(customLinkedList1));

        linkedList1.add("4");
        customLinkedList1.add("4");

        assertEquals(linkedList.equals(linkedList1),
                customLinkedList.equals(customLinkedList1));
        clearLists();
    }

    @Test
    public void testToString() {
        feelLists();
        assertEquals(linkedList.toString(), customLinkedList.toString());
        clearLists();
    }

    @Test
    public void forEach(){
        feelLists();
        StringBuilder linkedListString = new StringBuilder();
        StringBuilder customLinkedListString = new StringBuilder();
        for (String s : linkedList) {
            linkedListString.append(s);
        }
        for (String s : customLinkedList) {
            customLinkedListString.append(s);
        }
        assertEquals(linkedListString.toString(),
                customLinkedListString.toString());
        clearLists();
    }
}