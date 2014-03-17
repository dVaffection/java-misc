package exercises;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SortingTest {

    private Sorting sorting;

    @Before
    public void setUp() {
        sorting = new Sorting();
    }

    @Test
    public void testBubble() {
        int[] array = {3, 2, 5, 8, 1};
        int[] expected = {1, 2, 3, 5, 8};
        int[] actual = sorting.bubble(array);
        Assert.assertArrayEquals(expected, actual);
    }
}
