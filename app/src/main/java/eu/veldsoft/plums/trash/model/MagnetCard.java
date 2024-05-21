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
     * @param key   Key value used in some collections.
     * @param trash List of containers for trash in this card.
     */
    MagnetCard(String key, Class... trash) {
        super(key);

        this.trash = trash;
        Arrays.sort(this.trash, (c1, c2) -> c1.getName().compareTo(c2.getName()));
    }

    /**
     * Check if the card can fit in the container.
     *
     * @param container Container to check.
     * @return True if the card can fit in the container, false otherwise.
     */
    public boolean fitContainer(Class container) {
        if (container == SpecialContainer.class) {
            return true;
        }

        return false;
    }

    //TODO Add method for trash container checking.
}
