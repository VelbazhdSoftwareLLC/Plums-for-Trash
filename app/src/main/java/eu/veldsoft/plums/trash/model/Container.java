package eu.veldsoft.plums.trash.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class for containers which will hold different types of waste.
 */
abstract class Container {
    /**
     * List of cards held into the container.
     */
    private List<Card> cards = new ArrayList<Card>();

    /**
     * Reset the initial state of the container.
     */
    void reset() {
        cards.clear();
    }

    /**
     * Put card into the container.
     *
     * @param card Card to put.
     */
    void put(Card card) {
        cards.add(card);
    }

    /**
     * Get card from the container.
     *
     * @param index Index of the card to get.
     * @return Card from the container.
     */
    Card get(int index) {
        return cards.get(index);
    }

    /**
     * Get card from the container.
     *
     * @param card Card to get.
     * @return Card from the container.
     */
    Card get(Card card) {
        if (!cards.contains(card)) {
            return null;
        }

        cards.remove(card);
        return card;
    }

    /**
     * Retrieves the list of all cards.
     *
     * @return a list of {@code Card} objects currently stored. Returns an empty list if no cards are present.
     */
    List<Card> get() {
        return cards;
    }

    /**
     * TODO Homework - comment.
     *
     * @param bill
     */
    public void takeOut(List<Card> bill) {
        for (Card card : bill) {
            cards.remove(card);
        }
    }
}
