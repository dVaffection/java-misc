package stackmachine;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class StackMachineTest {

    private StackMachine stackMachine;

    @Before
    public void setUp() {
        stackMachine = new StackMachine();
    }

    @Test
    public void emptyInTheBeginning() {
        assertNull(stackMachine.pop());
    }

    @Test
    public void empty() {
        assertTrue(stackMachine.empty());

        stackMachine.push(1);
        assertFalse(stackMachine.empty());

        stackMachine.pop();
        assertTrue(stackMachine.empty());
    }

    @Test
    public void peek() {
        stackMachine.push(1);
        assertSame(1, stackMachine.peek());
        assertSame(1, stackMachine.pop());
        assertNull(stackMachine.pop());
    }

    @Test
    public void sameSequence() {
        stackMachine.push(1);
        stackMachine.push(2);
        stackMachine.push('+');

        assertSame('+', stackMachine.pop());
        assertSame(2, stackMachine.pop());
        assertSame(1, stackMachine.pop());
        assertNull(stackMachine.pop());
    }
}