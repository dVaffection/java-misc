package open_data_structures;

import org.junit.Test;

import static org.junit.Assert.*;

public class SLListTest {

    @Test
    public void stack() {
        Stack<Character> stack = new SLList<>();

        assertNull(stack.pop());

        stack.push('c');
        stack.push('b');
        stack.push('a');
        assertSame('a', stack.pop());
        assertSame('b', stack.pop());
        assertSame('c', stack.pop());

        assertNull(stack.pop());
    }

    @Test
    public void queue() {
        Queue<Character> queue = new SLList<>();

        assertNull(queue.dequeue());

        queue.enqueue('a');
        queue.enqueue('b');
        queue.enqueue('c');
        assertSame('a', queue.dequeue());
        assertSame('b', queue.dequeue());
        assertSame('c', queue.dequeue());

        assertNull(queue.dequeue());
    }

    @Test
    public void deque() {
        Deque<Character> deque = new SLList<>();

        deque.push('b');
        deque.push('a');
        deque.enqueue('c');

        assertSame('a', deque.dequeue());
        assertSame('b', deque.dequeue());
        assertSame('c', deque.dequeue());

        assertNull(deque.dequeue());

        deque.enqueue('a');
        deque.enqueue('b');
        deque.enqueue('c');

        assertSame('a', deque.pop());
        assertSame('b', deque.pop());
        assertSame('c', deque.pop());

        assertNull(deque.pop());
    }
}