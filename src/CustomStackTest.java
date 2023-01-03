import org.junit.Test;
import org.junit.function.ThrowingRunnable;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.junit.Assert.*;

/**
 * Test for customStack
 */
public class CustomStackTest {

    private final Stack<String> stack = new Stack<>();
    private final CustomStack<String> customStack = new CustomStack<>();

    private void feelStacks(){
        stack.add("1");
        stack.add("2");
        stack.add("3");
        stack.add("4");

        customStack.add("1");
        customStack.add("2");
        customStack.add("3");
        customStack.add("4");
    }

    private void clearStacks(){
        stack.clear();
        customStack.clear();
    }

    @Test(expected = EmptyStackException.class)
    public void peek() {
        assertThrows(EmptyStackException.class,
                (ThrowingRunnable) customStack.peek());
        feelStacks();
        assertEquals(stack.peek(), customStack.peek());
        clearStacks();
    }

    @Test(expected = EmptyStackException.class)
    public void pop() {
        assertThrows(EmptyStackException.class,
                (ThrowingRunnable) customStack.pop());
        feelStacks();
        assertEquals(stack.pop(), customStack.pop());
        assertEquals(stack.pop(), customStack.pop());
        assertEquals(stack.pop(), customStack.pop());
        clearStacks();
    }

    @Test
    public void push() {
        assertEquals(stack.push("1"), customStack.push("1"));
        assertEquals(stack.push("2"), customStack.push("2"));
        assertEquals(stack.push("3"), customStack.push("3"));
        assertArrayEquals(stack.toArray(), customStack.toArray());
    }

    @Test
    public void search() {
        feelStacks();
        feelStacks();
        assertEquals(stack.search("1"), customStack.search("1"));
        assertEquals(stack.search("2"), customStack.search("2"));
        assertEquals(stack.search("3"), customStack.search("3"));
        clearStacks();
    }

    @Test
    public void empty(){
        feelStacks();
        assertEquals(stack.empty(), customStack.empty());
        clearStacks();
        assertEquals(stack.empty(), customStack.empty());
    }
}