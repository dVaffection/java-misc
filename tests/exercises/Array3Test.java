package exercises;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

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
}
