package vendingmachine;

import org.junit.*;
import org.mockito.*;

import java.util.*;

import static org.mockito.Mockito.*;

public class InTransactionStateTest {

    private InTransactionState state;
    @Mock
    private Collection<Coin>   credit;
    @Mock
    private VendingMachine     vendingMachine;
    @Mock
    private Storage            storage;
    @Mock
    private Till               till;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        state = new InTransactionState(credit, vendingMachine, storage, till);
    }

    @Test
    public void credit() throws StateException {
        Collection<Coin> coins = Arrays.asList(Coin.LOONIE);
        state.credit(coins);

        verify(credit, times(1)).addAll(eq(coins));
    }

    @Test(expected = StorageException.class)
    public void productDoesNotExist() throws TillException, StateException, StorageException {
        String name = "non-existing-product-name";

        when(storage.getProduct(name)).thenThrow(new StorageException("Product is out of stock"));
        state.chooseProduct(name);
    }


    @Test(expected = TillException.class)
    public void notEnoughCredit() throws TillException, StateException, StorageException {
        Product product = new Product("Sprite", 1.75f);

        when(storage.getProduct("Sprite")).thenReturn(product);
        when(till.charge(anyCollection(), anyFloat())).thenThrow(new TillException("Not enough credit"));
        state.chooseProduct("Sprite");
    }

    @Test
    public void productIsBought() throws StorageException, TillException, StateException {
        Product product = new Product("Sprite", 1.75f);
        Collection<Coin> change = Collections.emptyList();

        when(storage.getProduct("Sprite")).thenReturn(product);
        when(till.charge(anyCollection(), anyFloat())).thenReturn(change);
        state.chooseProduct("Sprite");
        verify(storage, times(1)).removeProduct("Sprite");

        IdleState newState = new IdleState(vendingMachine, storage, till);
        newState.setProduct(product);
        newState.setChange(change);
        verify(vendingMachine, times(1)).changeState(eq(newState));
    }
}
