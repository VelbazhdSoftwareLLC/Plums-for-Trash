package eu.veldsoft.plums.trash.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Board class is the interface class of the package and holds all objects which take part in the game.
 */
final public class Board {
    //TODO Homework - comment.
    /**
     *
     */
    private static enum State {
        //TODO Pass as constructor parameteres from wich state in which state you can go.
        NONE,
        NEW_GAME,
        END_TURN,
        END_GAME,
    }

    //TODO Homework - comment.
    /**
     *
     */
    private static final Random PRNG = new Random();

    //TODO Homework - comment.
    /**
     *
     */
    private State state = State.NONE;

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

        market.reset();
        dump.reset();

        /*
         * In the real life counting usually starts from one, not from zero.
         */
        round = 1;

        /* The game has started. */
        state = State.NEW_GAME;

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

    /**
     * Lookup cards from the dump.
     *
     * @param indices Indices of the cards to lookup.
     * @return Cards keys from the dump to look at.
     * @throws RuntimeException If the index is out of bounds.
     */
    public String[] lookupInDump(int... indices) {
        Card cards[] = dump.lookup(indices);
        String keys[] = new String[cards.length];

        for (int i = 0; i < cards.length; i++) {
            keys[i] = cards[i].key();
        }

        return keys;
    }

    /**
     * Retrieves the keys of all cards currently held by the current player.
     *
     * @return an array of strings representing the keys of all cards held by the current player.
     * Returns an empty array if the player is not playing or has no cards.
     */
    public String[] lookupCurrentPlayerCards() {
        String[] keys = {};

        if (playing == null) {
            return keys;
        }

        List<Card> all = playing.allCards();
        keys = new String[all.size()];
        for (int i = 0; i < keys.length; i++) {
            keys[i] = all.get(i).key();
        }

        return keys;
    }

    /**
     * Retrieves the keys of all cards currently opened in the market.
     *
     * @return An array of strings representing the keys of opened market cards.
     */
    public String[] lookupOpenMarketCards() {
        String[] keys = {};

        List<Card> opened = market.opened();
        keys = new String[opened.size()];
        for (int i = 0; i < keys.length; i++) {
            keys[i] = opened.get(i).key();
        }

        return keys;
    }

    //TODO Homework - comment.

    /**
     * @return
     */
    public boolean[] cardsCanBuy() {
        boolean[] affordable = new boolean[market.opened().size()];

        if (playing == null) {
            return affordable;
        }

        for (int i = 0; i < market.opened().size(); i++) {
            Card card = market.opened().get(i);

            //TODO Check for cards which can buy.
            affordable[i] = PRNG.nextBoolean();
        }

        return affordable;
    }


    /**
     * Retrieves the name of the current player.
     *
     * @return The name of the current player, or an empty string if no player is currently playing.
     */
    public String currentPlayerInfo() {
        if (playing == null) {
            return "";
        }

        return playing.name() + " [" + (round) + ']';
    }
}
