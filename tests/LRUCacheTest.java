import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class LRUCacheTest {

    private LRUCache<String, String> cache;

    @Before
    public void setUp() {
        cache = new LRUCache<>(3);
    }

    @Test(expected = Exception.class)
    public void testExceptionForNonExistingValue() throws Exception {
        cache.get("non-existing-key");
    }

    @Test
    public void testCrud() {
        cache.add("1", "one");

        try {
            Assert.assertSame("one", cache.get("1"));
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }

        cache.remove("1");

        try {
            Assert.assertSame("one", cache.get("1"));
            Assert.fail("Value 'one' must not exist");
        } catch (Exception e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void testRemoveTellsTruth() {
        cache.add("1", "one");

        Assert.assertTrue(cache.remove("1"));
        Assert.assertFalse(cache.remove("1"));
    }

    @Test
    public void testCacheRemainsSize() {
        cache.add("1", "one");
        cache.add("2", "two");
        cache.add("3", "three");
        cache.add("4", "four");

        Assert.assertFalse(cache.exists("1"));
        Assert.assertTrue(cache.exists("2"));
        Assert.assertTrue(cache.exists("3"));
        Assert.assertTrue(cache.exists("4"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeSize() {
        new LRUCache<String, String>(0);
    }

    @Test
    public void cachePopsJustAsked() {
        cache.add("1", "one");
        cache.add("2", "two");
        cache.add("3", "three");

        try {
            cache.get("1");
            cache.add("4", "four");

            // must exist as we've just hit it
            Assert.assertTrue(cache.exists("1"));
            Assert.assertTrue(cache.exists("3"));
            Assert.assertTrue(cache.exists("4"));
            Assert.assertFalse(cache.exists("2"));
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

}
