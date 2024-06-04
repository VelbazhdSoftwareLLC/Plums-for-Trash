package eu.veldsoft.plums.trash.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Deck class holds all cards of the game.
 */
abstract class Deck {
    /**
     * List of all cards.
     */
    protected List<Card> CARDS = new ArrayList<>();

    /**
     * List of cards for a specific game.
     */
    protected List<Card> cards = new ArrayList<>();

    /**
     * Reset the initial state of the deck.
     */
    public void reset() {
        cards = new ArrayList<>(CARDS);
        Collections.shuffle(cards);
    }

    /**
     * Pull the top card of the deck.
     *
     * @return The card pulled.
     * @throws RuntimeException If the deck is empty.
     */
    public Card pull() {
        if (cards == null || cards.isEmpty()) {
            throw new RuntimeException("The deck is empty!");
        }

        return cards.remove(0);
    }

    /**
     * Check if the deck is empty.
     *
     * @return True if the deck is empty, false otherwise.
     */
    public boolean isEmpty() {
        return cards.isEmpty();
    }

}
