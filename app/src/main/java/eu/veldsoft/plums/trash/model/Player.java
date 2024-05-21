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
     * List of bought plums as cards.
     */
    private List<Card> bought = new ArrayList<>();

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

        bought.clear();
    }

    /**
     * Get the name of the player.
     *
     * @return The name of the player.
     */
    public String name() {
        return name;
    }

    /**
     * Get the containers of the player.
     *
     * @return The containers of the player.
     */
    public List<Container> containers() {
        return containers;
    }

    /**
     * Keep the card taken from the dump.
     *
     * @param card Card to keep.
     */
    public void keep(Card card) {
        //TODO Sort the card into the right container.
    }
}
