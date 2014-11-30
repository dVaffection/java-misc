package stackmachine;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

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