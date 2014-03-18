package exercises;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SortingTest {

    private Sorting sorting;

    @Before
    public void setUp() {
        sorting = new Sorting();
    }

    @Test
    public void testBubble() {
        Integer[] array = {3, 2, 5, 8, 1};
        Integer[] expected = {1, 2, 3, 5, 8};
        Integer[] actual = sorting.bubble(array);
        Assert.assertArrayEquals(expected, actual);
    }
}
