package exercises;

import junit.framework.Assert;
import org.junit.Test;

public class FactorialTest {

    @Test(expected = IllegalArgumentException.class)
    public void testLessThanOne() {
        Factorial.iterative(-1);
    }

    @Test
    public void testNEqualsZero() {
        int expected = 1;
        int actual = Factorial.iterative(0);
        Assert.assertSame(expected, actual);
    }

    @Test
    public void testNEqualsOne() {
        int expected = 1;
        int actual = Factorial.iterative(1);
        Assert.assertSame(expected, actual);
    }

    @Test
    public void testIterative() {
        Assert.assertEquals(2, Factorial.iterative(2));
        Assert.assertEquals(6, Factorial.iterative(3));
        Assert.assertEquals(24, Factorial.iterative(4));
        Assert.assertEquals(3_628_800, Factorial.iterative(10));
    }

    @Test
    public void testRecursive() {
        Assert.assertEquals(2, Factorial.iterative(2));
        Assert.assertEquals(6, Factorial.recursive(3));
        Assert.assertEquals(24, Factorial.iterative(4));
        Assert.assertEquals(3_628_800, Factorial.iterative(10));
    }

}
