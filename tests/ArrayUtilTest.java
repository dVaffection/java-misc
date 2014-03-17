import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class ArrayUtilTest extends TestCase {

    @Test
    public void testFindDuplicates() {
        Integer[] array = {1, 2, 3, 2, 4, 1};
        Integer[] expected = {2, 1};
        Integer[] actual = ArrayUtil.findDuplicates(array);
        Assert.assertArrayEquals(expected, actual);
    }
}
