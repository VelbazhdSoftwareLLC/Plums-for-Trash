package eu.veldsoft.plums.trash.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Player class describes the players' characteristics.
 */
class Player {
    /**
     * Playr's containers.
     */
    private List<Container> containers = new ArrayList<Container>();

    /**
     * Constructor without parameters.
     */
    public Player() {
        containers.add(new GlassContainer());
        containers.add(new PaperContainer());
        containers.add(new PlasticContainer());
        containers.add(new OrganicContainer());
        containers.add(new SpecialContainer());
    }
}
