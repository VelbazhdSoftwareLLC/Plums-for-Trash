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
}
