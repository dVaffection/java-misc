package vendingmachine;

import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

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


        expected = new ArrayList<>();
        actual = till.breakIntoCoins(0);
        assertThat(actual, CoreMatchers.is(expected));


        expected = Arrays.asList(Coin.PENNY, Coin.PENNY);
        actual = till.breakIntoCoins(0.02f);
        assertThat(actual, CoreMatchers.is(expected));
    }
}
