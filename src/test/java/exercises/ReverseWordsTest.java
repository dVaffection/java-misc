package exercises;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReverseWordsTest {


    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testIteration() throws Exception {
        String str = "java is the best programming language";
        String actual = ReverseWords.iteration(str);
        String expected = "language programming best the is java";

        Assert.assertEquals(expected, actual);
    }
}
