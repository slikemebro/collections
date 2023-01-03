import org.junit.Test;
import org.junit.function.ThrowingRunnable;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Test for customQueue
 */
public class CustomQueueTest {

    private final ArrayDeque<String> queue = new ArrayDeque<>();
    private final CustomQueue<String> customQueue = new CustomQueue<>();

    private void feelsQueues(){
        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");

        customQueue.add("1");
        customQueue.add("2");
        customQueue.add("3");
        customQueue.add("4");
    }

    private void clearQueues(){
        queue.clear();
        customQueue.clear();
    }

    @Test
    public void offer() {
        assertEquals(queue.offer("1"), customQueue.offer("1"));
        assertEquals(queue.offer("2"), customQueue.offer("2"));
        assertEquals(queue.offer("3"), customQueue.offer("3"));
        assertArrayEquals(queue.toArray(), customQueue.toArray());
        clearQueues();
    }

    @Test
    public void offerFirst() {
        feelsQueues();
        assertEquals(queue.offerFirst("1"), customQueue.offerFirst("1"));
        assertEquals(queue.offerFirst("2"), customQueue.offerFirst("2"));
        assertEquals(queue.offerFirst("3"), customQueue.offerFirst("3"));
        assertArrayEquals(queue.toArray(), customQueue.toArray());
        clearQueues();
    }

    @Test
    public void offerLast() {
        assertEquals(queue.offerLast("1"), customQueue.offerLast("1"));
        assertEquals(queue.offerLast("2"), customQueue.offerLast("2"));
        assertEquals(queue.offerLast("3"), customQueue.offerLast("3"));
        assertArrayEquals(queue.toArray(), customQueue.toArray());
        clearQueues();
    }

    @Test
    public void peek() {
        feelsQueues();
        assertEquals(queue.peek(), customQueue.peek());
        clearQueues();
    }

    @Test
    public void peekFirst() {
        feelsQueues();
        assertEquals(queue.peekFirst(), customQueue.peekFirst());
        clearQueues();
    }

    @Test
    public void peekLast() {
        feelsQueues();
        assertEquals(queue.peekLast(), customQueue.peekLast());
        clearQueues();
    }

    @Test(expected = NoSuchElementException.class)
    public void pop() {
        feelsQueues();
        assertEquals(queue.pop(), customQueue.pop());
        assertEquals(queue.pop(), customQueue.pop());
        assertEquals(queue.pop(), customQueue.pop());
        clearQueues();
        assertThrows(NoSuchElementException.class,
                (ThrowingRunnable) customQueue.pop());
    }

    @Test(expected = NoSuchElementException.class)
    public void poll() {
        feelsQueues();
        assertEquals(queue.poll(), customQueue.poll());
        assertEquals(queue.poll(), customQueue.poll());
        assertEquals(queue.poll(), customQueue.poll());
        clearQueues();
        assertThrows(NoSuchElementException.class,
                (ThrowingRunnable) customQueue.poll());
    }

    @Test(expected = NoSuchElementException.class)
    public void pollFirst() {
        feelsQueues();
        assertEquals(queue.pollFirst(), customQueue.pollFirst());
        assertEquals(queue.pollFirst(), customQueue.pollFirst());
        assertEquals(queue.pollFirst(), customQueue.pollFirst());
        clearQueues();
        assertThrows(NoSuchElementException.class,
                (ThrowingRunnable) customQueue.pollFirst());
    }

    @Test(expected = NoSuchElementException.class)
    public void pollLast() {
        feelsQueues();
        assertEquals(queue.pollLast(), customQueue.pollLast());
        assertEquals(queue.pollLast(), customQueue.pollLast());
        assertEquals(queue.pollLast(), customQueue.pollLast());
        clearQueues();
        assertThrows(NoSuchElementException.class,
                (ThrowingRunnable) customQueue.pollLast());
    }

    @Test
    public void push() {
        feelsQueues();
        queue.push("11");
        queue.push("12");
        queue.push("13");

        customQueue.push("11");
        customQueue.push("12");
        customQueue.push("13");
        assertArrayEquals(queue.toArray(), customQueue.toArray());
        clearQueues();
    }
}