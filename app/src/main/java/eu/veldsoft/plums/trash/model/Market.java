package eu.veldsoft.plums.trash.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Market class holds the card for trading.
 */
class Market {
    /**
     * Number of maximum open cards.
     */
    private static int NUMBER_OF_OPEN_CARDS = 4;

    /**
     * Deck with cards used in the market.
     */
    private Deck deck = new PlumsDeck();

    /**
     * List of cards held into the closed set.
     */
    private List<Card> closed = new ArrayList<Card>();

    /**
     * List of cards held into the opened set.
     */
    private List<Card> opened = new ArrayList<Card>();

    /**
     * Reset the initial state of the market.
     */
    public void reset() {
        deck.reset();
        closed.clear();
        opened.clear();

        for (int i = 0; i < NUMBER_OF_OPEN_CARDS && !deck.isEmpty(); i++) {
            opened.add(deck.pull());
        }

        while (!deck.isEmpty()) {
            closed.add(deck.pull());
        }
    }

    /**
     * Take a card from the market.
     *
     * @param index Index of the card to take.
     * @return Card taken from the market.
     * @throws RuntimeException If the market is empty or index is out of bounds.
     */
    public Card take(int index) {
        if (opened.isEmpty()) {
            throw new RuntimeException("The market is empty.");
        }

        if (index < 0 || index >= opened.size()) {
            throw new RuntimeException("The index is out of bounds.");
        }

        Card card = opened.remove(index);
        if (!closed.isEmpty()) {
            opened.add(closed.remove(0));
        }

        return card;
    }
}
