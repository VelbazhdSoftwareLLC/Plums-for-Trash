package eu.veldsoft.plums.trash.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Player class describes the players' characteristics.
 */
class Player {

    /**
     * The name of the player.
     */
    private String name = "";

    /**
     * Player's containers.
     */
    private List<Container> containers = new ArrayList<Container>();

    /**
     * Constructor with name of the player.
     *
     * @param name The name of the player.
     */
    Player(String name) {
        this.name = name;

        containers.add(new GlassContainer());
        containers.add(new PaperContainer());
        containers.add(new PlasticContainer());
        containers.add(new OrganicContainer());
        containers.add(new SpecialContainer());
    }
}
