package eerf.wrapper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StorageTest {

    private Storage storage;

    @Before
    public void setUp() {
        storage = new Storage();
    }

    @Test
    public void test() {
        storage.setId("123");
        Assert.assertEquals("123", storage.getId());
    }
}
