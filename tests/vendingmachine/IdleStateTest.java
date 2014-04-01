package vendingmachine;

import org.junit.*;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IdleStateTest {

    private IdleState      state;
    private VendingMachine vendingMachine;
    private Storage        storage;
    private Till           till;

    @Before
    public void setUp() {
        vendingMachine = mock(VendingMachine.class);
        storage = mock(Storage.class);
        till = mock(Till.class);

        state = new IdleState(vendingMachine, storage, till);
    }

    @Test
    public void fillWithProducts() throws StateException {
        Collection<Product> products = new ArrayList<Product>();

        state.fillWithProducts(products);
        verify(storage, times(1)).addProducts(eq(products));
    }

    @Test(expected = StateException.class)
    public void chooseProduct() throws TillException, StateException, StorageException {
        state.chooseProduct("does not matter");
    }

    @Test
    public void credit() throws StateException {
        Collection<Coin> coins = new ArrayList<>();
        State newState = new InTransactionState(coins, vendingMachine, storage, till);

        state.credit(coins);
        verify(vendingMachine, times(1)).changeState(eq(newState));
    }

    @Test
    public void getProduct() throws StateException {
        assertNull(state.getProduct());

        state.setProduct(new Product("Sprite", 1.75f));
        assertEquals(new Product("Sprite", 1.75f), state.getProduct());
    }

    @Test
    public void getChange() throws StateException {
        assertNull(state.getChange());

        Collection<Coin> change = Arrays.asList(Coin.PENNY, Coin.NICKEL);
        state.setChange(change);
        assertEquals(change, state.getChange());
    }
}
