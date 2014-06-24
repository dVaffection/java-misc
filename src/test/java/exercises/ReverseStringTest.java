package exercises;

import junit.framework.Assert;
import org.junit.Test;

public class ReverseStringTest {

    @Test
    public void iterative() throws Exception {
        String str = "java";
        String actual = ReverseString.iterative(str);
        String expected = "avaj";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void recursive() throws Exception {
        String str = "dv";
        String actual = ReverseString.recursive(str);
        String expected = "vd";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testBuilder() throws Exception {
        String str = "java";
        String actual = ReverseString.builder(str);
        String expected = "avaj";

        Assert.assertEquals(expected, actual);
    }
}
