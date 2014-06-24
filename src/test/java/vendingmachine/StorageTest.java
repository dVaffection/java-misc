package vendingmachine;

import org.junit.*;

import java.util.*;

import static org.junit.Assert.*;

public class StorageTest {

    private Storage storage;

    @Before
    public void setUp() {
        Collection<Product> products = new ArrayList<>();
        products.add(new Product("Coca-Cola", 1.15f));
        products.add(new Product("Diet Coke", 1.05f));
        products.add(new Product("Coke Zero", 0.95f));

        storage = new Storage();
        storage.addProducts(products);
    }

    @Test(expected = StorageException.class)
    public void getNonExistingProduct() throws StorageException {
        storage.getProduct("Sprite");
    }

    @Test
    public void getExistingProduct() throws StorageException {
        Product product = storage.getProduct("Diet Coke");
        assertEquals("Diet Coke", product.getName());
        assertEquals(1.05f, product.getPrice(), 0.0f);
    }

    @Test(expected = StorageException.class)
    public void removeNonExistingProduct() throws StorageException {
        storage.removeProduct("Sprite");
    }

    @Test
    public void removeExistingProduct() throws StorageException {
        storage.removeProduct("Diet Coke");

        try {
            storage.getProduct("Diet Coke");
            fail();
        } catch (StorageException e) {

        }
    }
}
