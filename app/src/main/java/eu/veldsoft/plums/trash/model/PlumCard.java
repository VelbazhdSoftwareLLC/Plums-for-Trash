package eu.veldsoft.plums.trash.model;

import java.util.Arrays;

/**
 * Plum card class.
 */
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
        Arrays.sort(this.trash, (c1, c2) -> c1.getName().compareTo(c2.getName()));
    }

    /**
     * Plums value getter.
     */
    int value() {
        return value;
    }

    /**
     * Identified containers which contains trash
     *
     * @return Array of the used trash containers.
     */
    Class[] containers() {
        return trash;
    }

    /**
     * Check if the card can fit in the container.
     *
     * @param container Container to check.
     * @return True if the card can fit in the container, false otherwise.
     */
    boolean fitContainer(Class container) {
        if (container == SpecialContainer.class) {
            return true;
        }

        return false;
    }
}
