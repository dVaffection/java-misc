package exercises;

import junit.framework.Assert;
import org.junit.Test;

public class FactorialTest {

    @Test(expected = IllegalArgumentException.class)
    public void testLessThanOne() {
        Factorial.calc(-1);
    }

    @Test
    public void testNEqualsZero() {
        int expected = 1;
        int actual = Factorial.calc(0);
        Assert.assertSame(expected, actual);
    }

    @Test
    public void testNEqualsOne() {
        int expected = 1;
        int actual = Factorial.calc(1);
        Assert.assertSame(expected, actual);
    }

    @Test
    public void test() {
        Assert.assertEquals(2, Factorial.calc(2));
        Assert.assertEquals(6, Factorial.calc(3));
        Assert.assertEquals(24, Factorial.calc(4));
        Assert.assertEquals(3628800, Factorial.calc(10));
    }

}
