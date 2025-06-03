package eu.veldsoft.plums.trash.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * Reset the initial state of the player.
     */
    void reset() {
        for (Container c : containers) {
            c.reset();
        }

        bought.clear();
    }

    /**
     * Get the name of the player.
     *
     * @return The name of the player.
     */
    String name() {
        return name;
    }

    /**
     * Get the containers of the player.
     *
     * @return The containers of the player.
     */
    List<Container> containers() {
        return containers;
    }

    /**
     * Keep the card taken from the dump.
     *
     * @param card Card to keep.
     */
    void keep(Card card) {
        for (Container c : containers) {
            if (!card.fitContainer(c.getClass())) {
                continue;
            }

            /* Have in mind that a single card can appear in many containers */
            c.put(card);
        }
    }

    /**
     * TODO Homework - comment!
     *
     * @param card, Card object to be given to each container.
     */
    void give(Card card) {
        for (Container c : containers) {
            c.get(card);
        }
    }

    /**
     * Adds the chosen card to the list of player's cards.
     *
     * @param card, object to be marked as purchased
     */
    void purchase(Card card) {
        bought.add(card);
    }

    /**
     * Retrieves all cards currently held, including bought cards and those from all containers.
     *
     * @return A list of {@code Card} objects representing all cards held. The list includes cards from
     * the {@code bought} collection and all cards from each {@code Container} in {@code containers}.
     */
    List<Card> allCards() {
        List<Card> result = new ArrayList<>();

        result.addAll(bought);
        for (Container c : containers) {
            result.addAll(c.get());
        }

        return result;
    }

    /**
     * Checking if the player has enough rubbish to exchange for the card plum.
     *
     * @param card Card with cost price( rubbish types - Organic, Paper, Plastic, Glass).
     * @return True if it possibly to buy the chosen card, false otherwise.
     */
    boolean affordable(Card card) {
        if (card instanceof PlumCard == false) {
            return false;
        }

        Map<Class, Integer> counters = new HashMap<>();
        PlumCard check = (PlumCard) card;
        for (Class container : check.containers()) {
            counters.put(container, counters.getOrDefault(container, 0) + 1);
        }

        for (Class container : counters.keySet()) {
            for (Container trash : containers)
                if (trash.getClass() == container && counters.get(container) > trash.get().size()) {
                    return false;
                }
        }

        return true;
    }

    /**
     * Get trash cards from the player.
     *
     * @param bill List of cards to be used for paying the bill.
     */
    public void pay(List<Card> bill) {
        for (Container c : containers) {
            c.takeOut(bill);
        }
    }
}
