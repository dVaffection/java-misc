import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;

public class StringUtilTest {

    @Test
    public void testPad2Params() {
        String expected = "java  ";
        String actual = StringUtil.pad("java", 6);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPad2ParamsPadLengthLessThanString() {
        String expected = "java";
        String actual = StringUtil.pad("java", 2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPad3Params() {
        String expected = "javac";
        String actual = StringUtil.pad("java", 5, "c");
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPad3ParamsPadStrEmpty() {
        String expected = "javac";
        String actual = StringUtil.pad("java", 5, "");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPad4Params() {
        String expected = "my_java";
        String actual = StringUtil.pad("java", 7, "my_", StringUtil.PadType.LEFT);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPad4ParamsPadStrGreaterThanPadLength() {
        String expected = "mjava";
        String actual = StringUtil.pad("java", 5, "my_", StringUtil.PadType.LEFT);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPad4ParamsPadStrLessThanPadLength() {
        String expected = "mmmmjava";
        String actual = StringUtil.pad("java", 8, "m", StringUtil.PadType.LEFT);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPad4ParamsPadRight() {
        String expected = "javalava";
        String actual = StringUtil.pad("java", 8, "lava", StringUtil.PadType.RIGHT);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRepeat() {
        String expected = "javajavajava";
        String actual = StringUtil.repeat("java", 3);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRepeatIllegalMultiplier() {
        StringUtil.repeat("java", -1);
    }

    @Test
    public void testRepeatZeroMultiplier() {
        String expected = "";
        String actual = StringUtil.repeat("java", 0);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testWordsCount() {
        int expected = 3;
        int actual = StringUtil.wordsCount("Hello dear java");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testWordsCountEmptyString() {
        int expected = 0;
        int actual = StringUtil.wordsCount("  ");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPos() {
        int expected = 6;
        try {
            int actual = StringUtil.pos("coffeejavacoffeejava", "java");
            Assert.assertEquals(expected, actual);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPosEmptyNeedle() throws Exception {
        try {
            StringUtil.pos("coffeejavacoffeejava", "");
        } catch (Exception e) {
            if (e instanceof IllegalArgumentException) {
                throw e;
            } else {
                Assert.fail(e.getMessage());
            }
        }
    }

    @Test
    public void testRpos() {
        int expected = 10;
        try {
            int actual = StringUtil.rpos("coffeejavacoffeejava", "coffee");
            Assert.assertEquals(expected, actual);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Ignore
    @Test
    public void testStrtr() {
        String str = "hi hello";

        HashMap<String, String> pairs = new HashMap<>();
        pairs.put("hello", "hi");
        pairs.put("hi", "hello");

        String expected = "hello hi";
        String actual = StringUtil.strtr(str, pairs);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAllIndexOf() {
        String str = "Find the first and last OOP in the whole OOP string.";
        String instance = "OOP";

        Integer[] expected = new Integer[2];
        expected[0] = 24;
        expected[1] = 41;

        Integer[] actual = StringUtil.allIndexOf(str, instance);
        Assert.assertArrayEquals(expected, actual);

    }

    @Test
    public void findHashTags() {
        String str = "@mwop\nNo, it's intended to _educate_ the #Larave1 people on what is a #Fa-ca_de. Landing missed. @Ocramius @JeremyKendall";

        String[] expected = {"Larave1", "Fa-ca_de"};
        String[] actual = StringUtil.findHashTags(str);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void findMentioned() {
        String str = "@mwop\nNo, it's intended to _educate_ the #Larave1 people on what is a #Fa-ca_de. Landing missed. @Ocramius @JeremyKendall";

        String[] expected = {"mwop", "Ocramius", "JeremyKendall"};
        String[] actual = StringUtil.findMentioned(str);
        Assert.assertArrayEquals(expected, actual);
    }

}
