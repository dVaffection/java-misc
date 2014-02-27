package cardsdeck;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CardTest {

    private Card card;

    @Before
    public void setUp() throws Exception {
        card = new Card(Card.Rank.ACE, Card.Suit.CLUBS);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetRank() throws Exception {
        Assert.assertSame(Card.Rank.ACE, card.getRank());
    }

    @Test
    public void testGetSuit() throws Exception {
        Assert.assertSame(Card.Suit.CLUBS, card.getSuit());
    }

    @Test
    public void testToString() throws Exception {
        Assert.assertEquals("Ace of Clubs", card.toString());
    }

    @Test
    public void testEquals() throws Exception {
        Card anotherCard = new Card(Card.Rank.ACE, Card.Suit.CLUBS);
        Assert.assertTrue(card.equals(anotherCard));
    }

    @Test
    public void testHashCode() {
        Card anotherCard = new Card(Card.Rank.ACE, Card.Suit.CLUBS);
        Assert.assertEquals(card.hashCode(), anotherCard.hashCode());
    }
}
