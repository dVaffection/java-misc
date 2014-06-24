package exercises;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class Array3Test {

    private Array3 array3;

    @Before
    public void setUp() {
        array3 = new Array3();
    }

    @Test
    public void testMaxMirror() {
        int[] nums = {1, 2, 1, 4};
        Assert.assertEquals(3, array3.maxMirror(nums));
    }

    @Test
    public void clearSubRange() {
        List<Character> actual = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e'));
        actual.subList(1, 3).clear();

        List<Character> expected = Arrays.asList('a', 'd', 'e');

        Assert.assertEquals(expected, actual);
    }
}
