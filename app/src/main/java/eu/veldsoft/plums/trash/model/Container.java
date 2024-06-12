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
    public void reset() {
        cards.clear();
    }

    /**
     * Put card into the container.
     *
     * @param card Card to put.
     */
    public void put(Card card) {
        cards.add(card);
    }

    /**
     * Get card from the container.
     *
     * @param index Index of the card to get.
     * @return Card from the container.
     */
    public Card get(int index) {
        return cards.get(index);
    }

    /**
     * Get card from the container.
     *
     * @param card Card to get.
     * @return Card from the container.
     */
    public Card get(Card card) {
        if (!cards.contains(card)) {
            throw new RuntimeException("The card is not in the container.");
        }

        cards.remove(card);

        return card;
    }
}
