import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class CappedStorageTest {

    private CappedStorage<String, String> storage;

    @Before
    public void setUp() {
        storage = new CappedStorage<>(3);
    }

    @Test
    public void testCrud() {
        storage.add("1", "one");
        storage.add("2", "two");

        try {
            String value = storage.get("1");
            Assert.assertSame("one", value);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }

        try {
            String value = storage.get("2");
            Assert.assertSame("two", value);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }

        storage.remove("1");
        Assert.assertFalse(storage.exists("1"));
        Assert.assertTrue(storage.exists("2"));
    }

    @Test
    public void testStorageUpdatesValueByKey() {
        storage.add("1", "one");
        storage.add("2", "two");
        storage.add("3", "three");
        storage.add("2", "updated-two");

        try {
            Assert.assertSame("one", storage.get("1"));
            Assert.assertSame("updated-two", storage.get("2"));
            Assert.assertSame("three", storage.get("3"));
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test(expected = Exception.class)
    public void testExceptionForNonExistingValue() throws Exception {
        storage.get("non-existing-key");
    }

    @Test
    public void testStorageRemainsSize() {
        storage.add("1", "one");
        storage.add("2", "two");
        storage.add("3", "three");
        storage.add("4", "four");

        Assert.assertFalse(storage.exists("1"));
        Assert.assertTrue(storage.exists("2"));
        Assert.assertTrue(storage.exists("3"));
        Assert.assertTrue(storage.exists("4"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeSize() {
        new CappedStorage<String, String>(0);
    }

}
