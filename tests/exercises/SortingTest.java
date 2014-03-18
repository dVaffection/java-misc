package exercises;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SortingTest {

    @Test
    public void testBubble() {
        Integer[] actual = {3, 2, 5, 8, 1};
        Integer[] expected = {1, 2, 3, 5, 8};
        Sorting.bubble(actual);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void shuffle() {
        Integer[] array = {1, 2, 3};
        Integer[] shuffled = Sorting.shuffle(array);
        Assert.assertFalse(Arrays.equals(array, shuffled));
    }
}
