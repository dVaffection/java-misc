package stackmachine;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;

public class RPNCalculatorTest {

    private RPNCalculator rpnCalculator;

    @Before
    public void setUp() {
        rpnCalculator = new RPNCalculator();
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentException() {
        Object[] ops = {'%'};
        rpnCalculator.ops(ops);
    }

    @Test
    public void addition() {
        Object[] ops = {1, 2, '+', 3, '+'};
        Object actual = rpnCalculator.ops(ops);
        Integer expected = 6;

        assertSame(expected, actual);
    }

    @Test
    public void subtraction() {
        Object[] ops = {6, 2, '-', 3, '-'};
        Object actual = rpnCalculator.ops(ops);
        Integer expected = 1;

        assertSame(expected, actual);
    }

    @Test
    public void multiplication() {
        Object[] ops = {1, 2, '*', 3, '*'};
        Object actual = rpnCalculator.ops(ops);
        Integer expected = 6;

        assertSame(expected, actual);
    }

    @Test
    public void division() {
        Object[] ops = {4, 2, '/', 1, '/'};
        Object actual = rpnCalculator.ops(ops);
        Integer expected = 2;

        assertSame(expected, actual);
    }
}