package cardsdeck;

import cardsdeck.deck.CardNotFoundException;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DeckTest {

    private Deck deck;

    @Before
    public void setUp() throws Exception {
        deck = new Deck();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetCards() throws Exception {
        deck.addCard(new Card(Card.Rank.ACE, Card.Suit.CLUBS));
        deck.addCard(new Card(Card.Rank.JACK, Card.Suit.SPADES));

        int actual = 0;
        Iterable<Card> cards = deck.getCards();
        for (Card card : cards) {
            actual++;
        }

        Assert.assertEquals(2, actual);
    }

    @Test
    public void testFindCard() throws Exception {
        deck.addCard(new Card(Card.Rank.ACE, Card.Suit.CLUBS));
        deck.addCard(new Card(Card.Rank.JACK, Card.Suit.SPADES));
        deck.addCard(new Card(Card.Rank.EIGHT, Card.Suit.DIAMONDS));


        Card expected = new Card(Card.Rank.JACK, Card.Suit.SPADES);
        Card actual = deck.findCard(Card.Rank.JACK, Card.Suit.SPADES);
        Assert.assertEquals(expected, actual);


    }

    @Test
    public void testFindCardException() {
        try {
            deck.findCard(Card.Rank.JACK, Card.Suit.SPADES);
            Assert.assertTrue(false);
        } catch (CardNotFoundException e) {
            Assert.assertTrue(true);
        }
    }
}
