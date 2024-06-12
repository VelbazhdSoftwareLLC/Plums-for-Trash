package eu.veldsoft.plums.trash.model;

/**
 * Plastic card class.
 */
class PlasticCard extends Card {
    /**
     * Constructor with card key.
     *
     * @param key Key value used in some collections.
     */
    PlasticCard(String key) {
        super(key);
    }


    /**
     * Check if the card can fit in the container.
     *
     * @param container Container to check.
     * @return True if the card can fit in the container, false otherwise.
     */
    public boolean fitContainer(Class container) {
        if (container == PlasticContainer.class) {
            return true;
        }

        return false;
    }

}
