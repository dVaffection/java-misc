package cardsdeck;

import cardsdeck.deck.CardNotFoundException;

import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public Iterable<Card> getCards() {
        return cards;
    }

    public Card findCard(Card.Rank rank, Card.Suit suit) throws CardNotFoundException {
        for (Card card : cards) {
            if (card.getRank() == rank && card.getSuit() == suit) {
                return card;
            }
        }

        String message = "Card was not found, rank and suit: " + rank + ", " + suit;
        throw new CardNotFoundException(message);
    }

}
