package vendingmachine;

import org.junit.*;

import static org.junit.Assert.*;

public class ProductTest {

    Product product;

    @Before
    public void setUp() {
        product = new Product("Sprite", 1.75f);
    }

    @Test
    public void equals() {
        assertEquals(new Product("Sprite", 1.75f), product);
    }
}
