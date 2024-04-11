package eu.veldsoft.plums.trash.model;

import java.util.Arrays;

class PlumCard extends Card {
    /**
     * Value of the plums on the card.
     */
    private int value = 0;

    /**
     * List of containers for trash in this card.
     */
    private Class[] trash;

    /**
     * Constructor with all parameters.
     *
     * @param key   Key value used in some collections.
     * @param value Value of the plums.
     * @param trash List of containers for trash in this card.
     */
    PlumCard(String key, int value, Class... trash) {
        super(key);

        this.value = value;
        this.trash = trash;
        Arrays.sort(this.trash);
    }

    /**
     * Plums value getter.
     */
    public int value() {
        return value;
    }
}
