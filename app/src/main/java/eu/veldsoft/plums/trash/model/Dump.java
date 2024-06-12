package eu.veldsoft.plums.trash.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Dump class holds the cards making the dump area.
 */
class Dump {
    /**
     * Deck with cards used in the dump.
     */
    private DumpDeck deck = new DumpDeck();

    /**
     * List of cards held into the dump which are not used.
     */
    private List<Card> unused = new ArrayList<Card>();

    /**
     * Reset the initial state of the dump.
     */
    public void reset() {
        deck.reset();
        unused.clear();

        while (!deck.isEmpty()) {
            unused.add(deck.pull());
        }
    }

    /**
     * Lookup cards from the dump.
     *
     * @param indices Indices of the cards to lookup.
     * @return Cards from the dump to look at.
     * @throws RuntimeException If the index is out of bounds.
     */
    public Card[] lookup(int... indices) {
        Card[] cards = new Card[indices.length];

        for (int i = 0; i < indices.length; i++) {
            if (indices[i] < 0 || indices[i] >= unused.size()) {
                throw new RuntimeException("The index is out of bounds.");
            }

            cards[i] = unused.get(indices[i]);
        }

        return cards;
    }

    /**
     * Take a card from the dump.
     *
     * @param index Index of the card to take.
     * @return Card taken from the dump.
     * @throws RuntimeException If the dump is empty or index is out of bounds.
     */
    public Card take(int index) {
        if (unused.isEmpty()) {
            throw new RuntimeException("The dump is empty.");
        }

        if (index < 0 || index >= unused.size()) {
            throw new RuntimeException("The index is out of bounds.");
        }

        return unused.remove(index);
    }

    /**
     * Take a card from the dump.
     *
     * @param card Reference of the card to take.
     * @return Card taken from the dump.
     * @throws RuntimeException If the dump is empty or the card is not in the dump.
     */
    public Card take(Card card) {
        if (unused.isEmpty()) {
            throw new RuntimeException("The dump is empty.");
        }

        if (!unused.contains(card)) {
            throw new RuntimeException("The card is not in the dump.");
        } else {
            unused.remove(card);
        }

        return card;
    }

    /**
     * Get number of cards in the dump.
     *
     * @return Number of cards in the dump.
     */
    public int size() {
        return unused.size();
    }
}
