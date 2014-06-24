package vendingmachine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

public class VendingMachineTest {

    VendingMachine vendingMachine;

    @Before
    public void setUp() {
        vendingMachine = new VendingMachine();
    }

    @Test
    public void noProductOrChangeForgotten() throws StateException {
        assertNull(vendingMachine.getProduct());
        assertNull(vendingMachine.getChange());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void creditIsRequiredFirst() throws TillException, StateException {
        vendingMachine.chooseProduct("Coca Cola");
    }

    @Test
    public void machineIsEmpty() throws TillException, StateException {
        Collection<Coin> coins = Arrays.asList(Coin.TOONIE);
        vendingMachine.credit(coins);

        vendingMachine.chooseProduct("Coca Cola");
        Product product = vendingMachine.getProduct();
        assertNull(product);

        float expectedChangeAmount = 2.0f, actualChangeAmount = 0f;
        Collection<Coin> change = vendingMachine.getChange();
        for (Coin coin : change) {
            actualChangeAmount += coin.getValue();
        }

        assertEquals(expectedChangeAmount, actualChangeAmount, 0);
    }

    @Test
    public void buyCoke() throws StateException, TillException, StorageException {
        Collection<Product> products = Arrays.asList(new Product("Coca Cola", 1.65f));
        vendingMachine.fillWithProducts(products);

        Collection<Coin> coins = Arrays.asList(Coin.TOONIE);
        vendingMachine.credit(coins);
        vendingMachine.chooseProduct("Coca Cola");

        Product product = vendingMachine.getProduct();
        assertEquals("Coca Cola", product.getName());

        float expectedChangeAmount = 0.35f, actualChangeAmount = 0f;
        Collection<Coin> change = vendingMachine.getChange();
        for (Coin coin : change) {
            actualChangeAmount += coin.getValue();
        }

        assertEquals(expectedChangeAmount, actualChangeAmount, 0);
    }
}
