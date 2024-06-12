package eu.veldsoft.plums.trash.model;

/**
 * Bonus card class.
 */
class BonusCard extends Card {
    /**
     * Constructor with card key.
     *
     * @param key Key value used in some collections.
     */
    BonusCard(String key) {
        super(key);
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

}
