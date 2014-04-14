package vendingmachine;

import org.junit.*;

import static org.junit.Assert.*;

public class ProductTest {

    Product product;

    @Before
    public void setUp() {
        product = new Product("Sprite", 1.75f);
    }

    /**
     * Object must be equal to itself
     */
    @Test
    public void equalsReflexive() {
        assertEquals(product, product);
    }

    /**
     * if a.equals(b) is true then b.equals(a) must be true
     */
    @Test
    public void equalsSymmetric() {
        Product anotherProduct = new Product("Sprite", 1.75f);
        assertEquals(anotherProduct, product);
        assertEquals(product, anotherProduct);
    }

    /**
     * multiple invocation of equals() method must result same value until any of properties are modified
     */
    @Test
    public void equalsConsistent() {
        Product anotherProduct = new Product("Sprite", 1.75f);
        assertEquals(anotherProduct, product);
        assertEquals(anotherProduct, product);
    }

    /**
     * comparing any object to null must be false and should not result in NullPointerException
     */
    @Test
    public void equalsNull() {
        assertNotEquals(null, product);
    }

    @Test
    public void notEquals() {
        assertNotEquals(new Product("Cola", 1.75f), product);
        assertNotEquals(new Product("Sprite", 1.50f), product);
    }

    @Test
    public void testHashCodeEquals() {
        Product anotherProduct = new Product("Sprite", 1.75f);
        assertEquals(anotherProduct.hashCode(), product.hashCode());
    }

    @Test
    public void testHashCodeNotEquals() {
        assertNotEquals(new Product("Cola", 1.75f).hashCode(), product.hashCode());
        assertNotEquals(new Product("Sprite", 1.50f).hashCode(), product.hashCode());
    }
}
