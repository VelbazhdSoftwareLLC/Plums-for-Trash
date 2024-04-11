package eu.veldsoft.plums.trash.model;

/**
 * Abstract class for cards.
 */
abstract class Card {
    /**
     * Key value of the card used in some collections.
     */
    private String key = "";

    /**
     * Constructor with card key.
     *
     * @param key Key value used in some collections.
     */
    Card(String key) {
        this.key = key;
    }

    /**
     * Get card key.
     *
     * @return Card key.
     */
    String key() {
        return key;
    }
}
