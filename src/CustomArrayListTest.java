import org.junit.function.ThrowingRunnable;

import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test for customArrayList
 */
public class CustomArrayListTest {

    private final CustomArrayList<String> customArrayList = new CustomArrayList<>();
    private final ArrayList<String> arrayList = new ArrayList<>();

    private void feelArrays(){
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");

        customArrayList.add("1");
        customArrayList.add("2");
        customArrayList.add("3");
        customArrayList.add("4");
    }

    private void clearArrays(){
        arrayList.clear();
        customArrayList.clear();
    }

    @Test
    public void add() {
        feelArrays();
        assertArrayEquals(arrayList.toArray(), customArrayList.toArray());
        clearArrays();
    }

    @Test
    public void addByIndex() {
        feelArrays();

        arrayList.add(1, "12");
        customArrayList.add(1, "12");

        arrayList.add(arrayList.size(), "10");
        customArrayList.add(customArrayList.size(), "10");

        arrayList.add(0, "50");
        customArrayList.add(0, "50");

        assertArrayEquals(arrayList.toArray(), customArrayList.toArray());
        clearArrays();
    }

    @Test
    public void size() {
        feelArrays();
        assertEquals(arrayList.size(), customArrayList.size());
        clearArrays();
    }

    @Test
    public void clear() {
        feelArrays();
        clearArrays();
        assertArrayEquals(arrayList.toArray(), customArrayList.toArray());
    }

    @Test
    public void contains() {
        feelArrays();
        assertEquals(arrayList.contains("1"), customArrayList.contains("1"));
        assertEquals(arrayList.contains("123"), customArrayList.contains("123"));
        clearArrays();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get() {
        feelArrays();
        assertEquals(arrayList.get(1), customArrayList.get(1));
        assertEquals(arrayList.get(0), customArrayList.get(0));
        assertEquals(arrayList.get(arrayList.size() - 1), customArrayList.get(customArrayList.size() - 1));
        assertThrows(IndexOutOfBoundsException.class, (ThrowingRunnable) customArrayList.get(20));
        clearArrays();
    }

    @Test
    public void indexOf() {
        feelArrays();
        assertEquals(arrayList.indexOf("1"), customArrayList.indexOf("1"));
        assertEquals(arrayList.indexOf("10"), customArrayList.indexOf("10"));
        clearArrays();
    }

    @Test
    public void lastIndexOf() {
        feelArrays();
        arrayList.add("1");
        arrayList.add("1");
        customArrayList.add("1");
        customArrayList.add("1");

        assertEquals(arrayList.lastIndexOf("1"), customArrayList.lastIndexOf("1"));
        assertEquals(arrayList.lastIndexOf("2"), customArrayList.lastIndexOf("2"));
        clearArrays();
    }

    @Test
    public void remove() {
        feelArrays();
        assertTrue(customArrayList.remove("1"));
        arrayList.remove("1");
        assertArrayEquals(arrayList.toArray(), customArrayList.toArray());
        clearArrays();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeByIndex() {
        feelArrays();
        assertEquals(arrayList.remove(2), customArrayList.remove(2));
        assertThrows(IndexOutOfBoundsException.class, (ThrowingRunnable) customArrayList.remove(20));
        clearArrays();
    }

    @Test
    public void toArray() {
        feelArrays();
        assertArrayEquals(arrayList.toArray(), customArrayList.toArray());
        clearArrays();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void set() {
        feelArrays();
        assertEquals(arrayList.set(0, "12"), customArrayList.set(0, "10"));
        assertThrows(IndexOutOfBoundsException.class, (ThrowingRunnable) customArrayList.set(20, "23"));
        assertArrayEquals(arrayList.toArray(), customArrayList.toArray());
        clearArrays();
    }

    @Test
    public void isEmpty() {
        feelArrays();
        assertFalse(customArrayList.isEmpty());
        clearArrays();
        assertTrue(customArrayList.isEmpty());
    }

    @Test
    public void testEquals() {
        feelArrays();
        CustomArrayList<String> customArrayList1 = new CustomArrayList<>();
        ArrayList<String> arrayList1 = new ArrayList<>();

        arrayList1.add("1");
        arrayList1.add("2");
        arrayList1.add("3");
        customArrayList1.add("1");
        customArrayList1.add("2");
        customArrayList1.add("3");

        assertEquals(arrayList.equals(arrayList1), customArrayList.equals(customArrayList1));

        arrayList1.add("4");
        customArrayList1.add("4");

        assertEquals(arrayList.equals(arrayList1), customArrayList.equals(customArrayList1));
        clearArrays();
    }

    @Test
    public void testToString() {
        feelArrays();
        assertEquals(arrayList.toString(), customArrayList.toString());
        clearArrays();
    }

    @Test
    public void forEach(){
        feelArrays();
        StringBuilder arrayListString = new StringBuilder();
        StringBuilder customArrayListString = new StringBuilder();
        for (String s : arrayList) {
            arrayListString.append(s);
        }
        for (String s : customArrayList) {
            customArrayListString.append(s);
        }
        assertEquals(arrayListString.toString(), customArrayListString.toString());
        clearArrays();
    }

    @Test
    public void increaseSizeOfArrayList(){
        feelArrays();
        feelArrays();
        feelArrays();
        assertEquals(arrayList.size(), customArrayList.size());
        assertArrayEquals(arrayList.toArray(), customArrayList.toArray());
    }
}