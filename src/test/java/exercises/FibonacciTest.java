package exercises;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class FibonacciTest {

    private Fibonacci fibonacci;


    @Before
    public void setUp() {
        fibonacci = new Fibonacci();
    }

    @Test
    public void iterative() {
        Assert.assertEquals(3, fibonacci.iterative(4));
        Assert.assertEquals(34, fibonacci.iterative(9));
    }

    @Test
    public void recursive() {
        Assert.assertEquals(3, fibonacci.recursive(4));
        Assert.assertEquals(34, fibonacci.recursive(9));
    }

}
