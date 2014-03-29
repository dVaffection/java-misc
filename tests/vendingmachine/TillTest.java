package vendingmachine;

import org.hamcrest.*;
import org.junit.*;

import java.util.*;

import static org.junit.Assert.*;

public class TillTest {

    Till till;

    @Before
    public void setUp() {
        till = new Till();
    }

    @Test
    public void breakIntoCoins() {
        Collection<Coin> actual, expected;

        try {
            till.breakIntoCoins(-1);
            fail();
        } catch (Exception e) {

        }

        expected = Collections.emptyList();
        actual = till.breakIntoCoins(0);
        assertThat(actual, CoreMatchers.is(expected));


        expected = Arrays.asList(Coin.PENNY, Coin.PENNY);
        actual = till.breakIntoCoins(0.02f);
        assertThat(actual, CoreMatchers.is(expected));


        expected = Arrays.asList(Coin.LOONIE, Coin.NICKEL, Coin.PENNY, Coin.PENNY);
        actual = till.breakIntoCoins(1.07f);
        assertThat(actual, CoreMatchers.is(expected));

        expected = Arrays.asList(Coin.TOONIE, Coin.LOONIE, Coin.HALF, Coin.QUARTER, Coin.DIME, Coin.NICKEL, Coin.PENNY);
        actual = till.breakIntoCoins(3.91f);
        assertThat(actual, CoreMatchers.is(expected));
    }
}
