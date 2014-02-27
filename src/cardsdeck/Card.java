package cardsdeck;

public class Card {

    public enum Suit {
        DIAMONDS("Diamonds"),
        HEARTS("Hearts"),
        SPADES("Spades"),
        CLUBS("Clubs");

        private String name;

        Suit(String name) {
            this.name = name;
        }

        public String toString() {
            return name;
        }
    }

    public enum Rank {
        SIX("6"),
        SEVEN("7"),
        EIGHT("8"),
        NINE("9"),
        TEN("10"),
        JACK("Jack"),
        QUEEN("Queen"),
        KING("King"),
        ACE("Ace");

        private String name;

        Rank(String name) {
            this.name = name;
        }

        public String toString() {
            return name;
        }
    }

    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public String toString() {
        return rank + " of " + suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (rank != card.rank) return false;
        if (suit != card.suit) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rank.hashCode();
        result = 31 * result + suit.hashCode();
        return result;
    }
}
