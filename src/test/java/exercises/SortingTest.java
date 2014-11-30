package exercises;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SortingTest {

    @Test
    public void quick() {
        int[] actual = {6, 5, 3, 1, 8, 7, 2, 4};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};

        Sorting.quick(actual);

//        System.out.println("[6, 5, 3, 1, 8, 7, 2, 4]");
//        System.out.println(Arrays.toString(actual));
    }

    @Test
    public void merge() {
        List<Integer> actual = new LinkedList<>(Arrays.asList(6, 5, 3, 1, 8, 7, 2, 4));
//        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};

        List<Integer> result = Sorting.mergeSort(actual);

        System.out.println("[6, 5, 3, 1, 8, 7, 2, 4]");
        System.out.println(result);

//        System.out.println(Sorting.recursive(3));
    }

    @Test
    public void bubble() {
        Integer[] actual = {3, 2, 5, 8, 1};
        Integer[] expected = {1, 2, 3, 5, 8};
        Sorting.bubble(actual);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void bubbleInt() {
        int[] actual = {3, 2, 5, 8, 1};
        int[] expected = {1, 2, 3, 5, 8};
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
