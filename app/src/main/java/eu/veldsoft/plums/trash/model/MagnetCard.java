package eu.veldsoft.plums.trash.model;

import java.util.Arrays;

/**
 * Describes the magnet card.
 */
class MagnetCard extends Card {

    /**
     * List of containers for trash in this card.
     */
    private Class[] trash;

    /**
     * Constructor with all parameters.
     *
     * @param trash List of containers for trash in this card.
     */
    MagnetCard(Class... trash) {
        super();

        this.trash = trash;
        Arrays.sort(this.trash);
    }

    //TODO Add method for trash container checking.
}
