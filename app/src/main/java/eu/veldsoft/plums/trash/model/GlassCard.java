package eu.veldsoft.plums.trash.model;

/**
 * Glass card class.
 */
class GlassCard extends Card {
    /**
     * Constructor with card key.
     *
     * @param key Key value used in some collections.
     */
    GlassCard(String key) {
        super(key);
    }

    /**
     * Check if the card can fit in the container.
     *
     * @param container Container to check.
     * @return True if the card can fit in the container, false otherwise.
     */
    public boolean fitContainer(Class container) {
        if (container == GlassContainer.class) {
            return true;
        }

        return false;
    }
}
