package cardsdeck;

public class Implementation {

    public static void main(String... args) {
        Deck deck = new Deck();
        deck.addCard(new Card(Card.Rank.ACE, Card.Suit.CLUBS));
        deck.addCard(new Card(Card.Rank.SEVEN, Card.Suit.HEARTS));
        deck.addCard(new Card(Card.Rank.JACK, Card.Suit.SPADES));

        for (Card card : deck.getCards()) {
            System.out.println(card);
        }

        try {
            System.out.println(deck.findCard(Card.Rank.ACE, Card.Suit.CLUBS));
            System.out.println(deck.findCard(Card.Rank.ACE, Card.Suit.HEARTS));
        } catch (Exception e) {
            System.err.println(e);
        }

        System.out.println(Card.Suit.CLUBS);
    }

}
