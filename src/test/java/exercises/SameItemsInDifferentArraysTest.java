package exercises;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;

public class SameItemsInDifferentArraysTest extends TestCase {

    @Test
    public void testStraightForward() {
        Integer[] arr1 = {1, 2, 3, 4};
        Integer[] arr2 = {2, 3, 4};
        Integer[] arr3 = {3, 4, 5, 6, 7, 8, 9};

        int actual = SameItemsInDifferentArrays.straightForward(arr1, arr2, arr3);
        int expected = 2;
        Assert.assertSame(expected, actual);
    }

}
