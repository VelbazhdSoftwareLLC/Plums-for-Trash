package eu.veldsoft.plums.trash.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Board class is the interface class of the package and holds all objects which take part in the game.
 */
final public class Board {
    /**
     * Deck of cards for the game.
     */
    //private Deck deck = new Deck();

    private Dump dump = new Dump();

    /**
     * List of the players around the board.
     */
    private List<Player> players = new ArrayList<Player>();
}
