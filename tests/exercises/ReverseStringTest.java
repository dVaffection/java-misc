package exercises;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReverseStringTest {


    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testIteration() throws Exception {
        String str = "java";
        String actual = ReverseString.iteration(str);
        String expected = "avaj";

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
