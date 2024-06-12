package eu.veldsoft.plums.trash.model;

/**
 * Paper card class.
 */
class PaperCard extends Card {
    /**
     * Constructor with card key.
     *
     * @param key Key value used in some collections.
     */
    PaperCard(String key) {
        super(key);
    }


    /**
     * Check if the card can fit in the container.
     *
     * @param container Container to check.
     * @return True if the card can fit in the container, false otherwise.
     */
    public boolean fitContainer(Class container) {
        if (container == PaperContainer.class) {
            return true;
        }

        return false;
    }

}
