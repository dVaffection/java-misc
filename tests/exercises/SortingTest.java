package exercises;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SortingTest {

    @Test
    public void bubble() {
        Integer[] actual = {3, 2, 5, 8, 1};
        Integer[] expected = {1, 2, 3, 5, 8};
        Sorting.bubble(actual);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void shuffle() {
        Integer[] shuffled = {1, 2, 3};
        Integer[] sorted = Arrays.copyOf(shuffled, shuffled.length);
        Sorting.shuffle(shuffled);
        Assert.assertFalse(Arrays.equals(sorted, shuffled));
    }

    @Test
    public void isSorted() {
        Assert.assertTrue(Sorting.isSorted(new Integer[]{}));
        Assert.assertTrue(Sorting.isSorted(new Integer[]{2}));
        Assert.assertTrue(Sorting.isSorted(new Integer[]{1, 2, 5, 8, 9}));
    }

    @Test
    public void bogo() {
        Integer[] actual = {3, 2, 1,};
        Integer[] expected = {1, 2, 3};
        Sorting.bogo(actual);
        Assert.assertArrayEquals(expected, actual);
    }
}
