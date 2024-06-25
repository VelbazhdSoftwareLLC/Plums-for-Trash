package eu.veldsoft.plums.trash.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Board class is the interface class of the package and holds all objects which take part in the game.
 */
final public class Board {
    /**
     * Market with plums cards.
     */
    private Market market = new Market();

    /**
     * Dump with trash cards.
     */
    private Dump dump = new Dump();

    /**
     * List of the players around the board.
     */
    private List<Player> players = new ArrayList<Player>();

    /**
     * The player who is playing at the moment.
     */
    private Player playing = null;

    /**
     * The game goes in turns.
     */
    private int round = 0;

    /**
     * Start new game or restart current game.
     *
     * @param playersNames List with the names of the players.
     * @return True if the game starts, false otherwise.
     */
    public boolean newGame(String[] playersNames) {
        if (playersNames.length < 2 || 6 < playersNames.length) {
            return false;
        }

        /*
         * The maximum number of players is 6.
         */
        players.clear();
        for (String name : playersNames) {
            players.add(new Player(name));
        }

        //TODO It is better each player to be able to be in each order.
        Collections.shuffle(players);

        /*
         * The first player plays after start of the game.
         */
        playing = ((players.size() <= 0) ? null : players.get(0));

        /*
         * Create new market and dump.
         */
        market = new Market();
        dump = new Dump();

        /*
         * In the real life counting usually starts from one, not from zero.
         */
        round = 1;

        return true;
    }

    /**
     * Get dump size.
     *
     * @return Dump size.
     */
    public int dumpSize() {
        return dump.size();
    }

    /**
     * Currant player take card from the dump.
     *
     * @param index Index of the card in the dump to be taken.
     * @return True if the card was taken, false otherwise.
     */
    public boolean takeFromDump(int index) {
        if (playing == null) {
            return false;
        }

        if (index < 0 || index >= dump.size()) {
            return false;
        }

        playing.keep(dump.take(index));

        return true;
    }
}
