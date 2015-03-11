package open_data_structures;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class ArrayBasedQueueTest {

    @Test
    public void test() {
        ArrayBasedQueue<Character> queue = new ArrayBasedQueue<>(2);

        queue.enqueue('a');
        queue.enqueue('b');
        queue.enqueue('c');
        queue.enqueue('d');
        queue.enqueue('e');
        queue.enqueue('f');
        queue.enqueue('g');

        assertSame('a', queue.dequeue());
        assertSame('b', queue.dequeue());
        assertSame('c', queue.dequeue());
        assertSame('d', queue.dequeue());
        assertSame('e', queue.dequeue());

        assertSame('f', queue.dequeue());
        assertSame('g', queue.dequeue());

        queue.enqueue('a');
        queue.enqueue('b');
        queue.enqueue('c');

        assertSame('a', queue.dequeue());
        assertSame('b', queue.dequeue());
    }
}