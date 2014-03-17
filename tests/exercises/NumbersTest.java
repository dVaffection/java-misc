package exercises;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class NumbersTest {

    private Numbers numbers;

    @Before
    public void setUp() {
        numbers = new Numbers();
    }

    @Test
    public void evenOrOdd() {
        Assert.assertTrue(numbers.evenOrOdd(0));
        Assert.assertTrue(numbers.evenOrOdd(2));
        Assert.assertFalse(numbers.evenOrOdd(1));
        Assert.assertFalse(numbers.evenOrOdd(5));
    }

    @Test
    public void isPrime() {
        Assert.assertTrue(numbers.isPrime(2));
        Assert.assertTrue(numbers.isPrime(5));
        Assert.assertFalse(numbers.isPrime(6));
        Assert.assertFalse(numbers.isPrime(9));
        Assert.assertFalse(numbers.isPrime(25));
    }

    @Test
    public void isPalindrome() {
        Assert.assertTrue(numbers.isPalindrome(121));
        Assert.assertFalse(numbers.isPalindrome(123));
    }

    @Test
    public void isArmStrong() {
        Assert.assertTrue(numbers.isArmstrong(153));
        Assert.assertFalse(numbers.isArmstrong(123));
    }

    @Test
    public void isBinary() {

        Assert.assertTrue(numbers.isBinary(10010));
        Assert.assertFalse(numbers.isBinary(12));
        Assert.assertFalse(numbers.isBinary(7));
    }
}
