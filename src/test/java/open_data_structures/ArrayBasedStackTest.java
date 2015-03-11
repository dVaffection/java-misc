package open_data_structures;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class ArrayBasedStackTest {

    @Test
    public void test() {
        Stack<Character> stack = new ArrayBasedStack<>(2);
        stack.push('d');
        stack.push('c');
        stack.push('b');
        stack.push('a');

        assertSame('a', stack.pop());
        assertSame('b', stack.pop());
        assertSame('c', stack.pop());
        assertSame('d', stack.pop());
    }
}