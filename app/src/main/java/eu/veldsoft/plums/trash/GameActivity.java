package eu.veldsoft.plums.trash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eu.veldsoft.plums.trash.model.Board;


/**
 * Game screen is the most used window in the game.
 */
public class GameActivity extends Activity {
    /**
     * Map of the card key and card image.
     */
    static final Map<String, Integer> CARDS_IMAGES = new HashMap<String, Integer>();

    /**
     * The identifier for launching activity.
     */
    private static final int LAUNCH_PLAYERS_LIST_ACTIVITY = 1;

    /**
     * The identifier for launching activity.
     */
    private static final int LAUNCH_SELECT_CARD_ACTIVITY = 2;

    /**
     * The link between view layer and object model is the instance of the Board class. It is static because it will be needed in other activities.
     */
    private static Board board = new Board();

    /**
     * Seek bar reference.
     */
    private SeekBar bar1 = null;

    /**
     * Seek bar reference.
     */
    private SeekBar bar2 = null;

    /**
     * Get board reference.
     *
     * @return The board reference.
     */
    static Board board() {
        return board;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        findViewById(R.id.checkCardsButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });


        /*
         * Map card keys to card image resource identifiers.
         */
        if (CARDS_IMAGES.size() == 0) {
            CARDS_IMAGES.put("bins_v4_01", R.drawable.bins_v4_01);
            CARDS_IMAGES.put("bins_v4_02", R.drawable.bins_v4_02);
            CARDS_IMAGES.put("bins_v4_10", R.drawable.bins_v4_10);
            CARDS_IMAGES.put("bins_v4_19", R.drawable.bins_v4_19);
            CARDS_IMAGES.put("bins_v4_20", R.drawable.bins_v4_20);
            CARDS_IMAGES.put("garbage_cards_v6_01", R.drawable.garbage_cards_v6_01);
            CARDS_IMAGES.put("garbage_cards_v6_02", R.drawable.garbage_cards_v6_02);
            CARDS_IMAGES.put("garbage_cards_v6_03", R.drawable.garbage_cards_v6_03);
            CARDS_IMAGES.put("garbage_cards_v6_04", R.drawable.garbage_cards_v6_04);
            CARDS_IMAGES.put("garbage_cards_v6_05", R.drawable.garbage_cards_v6_05);
            CARDS_IMAGES.put("garbage_cards_v6_06", R.drawable.garbage_cards_v6_06);
            CARDS_IMAGES.put("garbage_cards_v6_07", R.drawable.garbage_cards_v6_07);
            CARDS_IMAGES.put("garbage_cards_v6_08", R.drawable.garbage_cards_v6_08);
            CARDS_IMAGES.put("garbage_cards_v6_09", R.drawable.garbage_cards_v6_09);
            CARDS_IMAGES.put("garbage_cards_v6_10", R.drawable.garbage_cards_v6_10);
            CARDS_IMAGES.put("garbage_cards_v6_11", R.drawable.garbage_cards_v6_11);
            CARDS_IMAGES.put("garbage_cards_v6_12", R.drawable.garbage_cards_v6_12);
            CARDS_IMAGES.put("garbage_cards_v6_13", R.drawable.garbage_cards_v6_13);
            CARDS_IMAGES.put("garbage_cards_v6_14", R.drawable.garbage_cards_v6_14);
            CARDS_IMAGES.put("garbage_cards_v6_15", R.drawable.garbage_cards_v6_15);
            CARDS_IMAGES.put("garbage_cards_v6_16", R.drawable.garbage_cards_v6_16);
            CARDS_IMAGES.put("garbage_cards_v6_17", R.drawable.garbage_cards_v6_17);
            CARDS_IMAGES.put("garbage_cards_v6_18", R.drawable.garbage_cards_v6_18);
            CARDS_IMAGES.put("garbage_cards_v6_19", R.drawable.garbage_cards_v6_19);
            CARDS_IMAGES.put("garbage_cards_v6_20", R.drawable.garbage_cards_v6_20);
            CARDS_IMAGES.put("garbage_cards_v6_21", R.drawable.garbage_cards_v6_21);
            CARDS_IMAGES.put("garbage_cards_v6_22", R.drawable.garbage_cards_v6_22);
            CARDS_IMAGES.put("garbage_cards_v6_23", R.drawable.garbage_cards_v6_23);
            CARDS_IMAGES.put("garbage_cards_v6_24", R.drawable.garbage_cards_v6_24);
            CARDS_IMAGES.put("garbage_cards_v6_25", R.drawable.garbage_cards_v6_25);
            CARDS_IMAGES.put("garbage_cards_v6_26", R.drawable.garbage_cards_v6_26);
            CARDS_IMAGES.put("garbage_cards_v6_27", R.drawable.garbage_cards_v6_27);
            CARDS_IMAGES.put("garbage_cards_v6_28", R.drawable.garbage_cards_v6_28);
            CARDS_IMAGES.put("garbage_cards_v6_29", R.drawable.garbage_cards_v6_29);
            CARDS_IMAGES.put("garbage_cards_v6_30", R.drawable.garbage_cards_v6_30);
            CARDS_IMAGES.put("garbage_cards_v6_31", R.drawable.garbage_cards_v6_31);
            CARDS_IMAGES.put("garbage_cards_v6_32", R.drawable.garbage_cards_v6_32);
            CARDS_IMAGES.put("garbage_cards_v6_33", R.drawable.garbage_cards_v6_33);
            CARDS_IMAGES.put("garbage_cards_v6_34", R.drawable.garbage_cards_v6_34);
            CARDS_IMAGES.put("garbage_cards_v6_35", R.drawable.garbage_cards_v6_35);
            CARDS_IMAGES.put("garbage_cards_v6_36", R.drawable.garbage_cards_v6_36);
            CARDS_IMAGES.put("garbage_cards_v6_37", R.drawable.garbage_cards_v6_37);
            CARDS_IMAGES.put("garbage_cards_v6_38", R.drawable.garbage_cards_v6_38);
            CARDS_IMAGES.put("garbage_cards_v6_39", R.drawable.garbage_cards_v6_39);
            CARDS_IMAGES.put("garbage_cards_v6_40", R.drawable.garbage_cards_v6_40);
            CARDS_IMAGES.put("garbage_cards_v6_41", R.drawable.garbage_cards_v6_41);
            CARDS_IMAGES.put("garbage_cards_v6_42", R.drawable.garbage_cards_v6_42);
            CARDS_IMAGES.put("garbage_cards_v6_43", R.drawable.garbage_cards_v6_43);
            CARDS_IMAGES.put("garbage_cards_v6_44", R.drawable.garbage_cards_v6_44);
            CARDS_IMAGES.put("garbage_cards_v6_45", R.drawable.garbage_cards_v6_45);
            CARDS_IMAGES.put("garbage_cards_v6_46", R.drawable.garbage_cards_v6_46);
            CARDS_IMAGES.put("garbage_cards_v6_47", R.drawable.garbage_cards_v6_47);
            CARDS_IMAGES.put("garbage_cards_v6_48", R.drawable.garbage_cards_v6_48);
            CARDS_IMAGES.put("garbage_cards_v6_49", R.drawable.garbage_cards_v6_49);
            CARDS_IMAGES.put("garbage_cards_v6_50", R.drawable.garbage_cards_v6_50);
            CARDS_IMAGES.put("garbage_cards_v6_51", R.drawable.garbage_cards_v6_51);
            CARDS_IMAGES.put("garbage_cards_v6_52", R.drawable.garbage_cards_v6_52);
            CARDS_IMAGES.put("garbage_cards_v6_53", R.drawable.garbage_cards_v6_53);
            CARDS_IMAGES.put("garbage_cards_v6_54", R.drawable.garbage_cards_v6_54);
            CARDS_IMAGES.put("garbage_cards_v6_55", R.drawable.garbage_cards_v6_55);
            CARDS_IMAGES.put("garbage_cards_v6_56", R.drawable.garbage_cards_v6_56);
            CARDS_IMAGES.put("garbage_cards_v6_57", R.drawable.garbage_cards_v6_57);
            CARDS_IMAGES.put("garbage_cards_v6_58", R.drawable.garbage_cards_v6_58);
            CARDS_IMAGES.put("garbage_cards_v6_59", R.drawable.garbage_cards_v6_59);
            CARDS_IMAGES.put("garbage_cards_v6_60", R.drawable.garbage_cards_v6_60);
            CARDS_IMAGES.put("garbage_cards_v6_61", R.drawable.garbage_cards_v6_61);
            CARDS_IMAGES.put("garbage_cards_v6_62", R.drawable.garbage_cards_v6_62);
            CARDS_IMAGES.put("garbage_cards_v6_63", R.drawable.garbage_cards_v6_63);
            CARDS_IMAGES.put("garbage_cards_v6_64", R.drawable.garbage_cards_v6_64);
            CARDS_IMAGES.put("garbage_cards_v6_65", R.drawable.garbage_cards_v6_65);
            CARDS_IMAGES.put("garbage_cards_v6_66", R.drawable.garbage_cards_v6_66);
            CARDS_IMAGES.put("garbage_cards_v6_67", R.drawable.garbage_cards_v6_67);
            CARDS_IMAGES.put("garbage_cards_v6_68", R.drawable.garbage_cards_v6_68);
            CARDS_IMAGES.put("garbage_cards_v6_69", R.drawable.garbage_cards_v6_69);
            CARDS_IMAGES.put("garbage_cards_v6_70", R.drawable.garbage_cards_v6_70);
            CARDS_IMAGES.put("quest_v5_en_01", R.drawable.quest_v5_en_01);
            CARDS_IMAGES.put("quest_v5_en_02", R.drawable.quest_v5_en_02);
            CARDS_IMAGES.put("quest_v5_en_03", R.drawable.quest_v5_en_03);
            CARDS_IMAGES.put("quest_v5_en_04", R.drawable.quest_v5_en_04);
            CARDS_IMAGES.put("quest_v5_en_05", R.drawable.quest_v5_en_05);
            CARDS_IMAGES.put("quest_v5_en_06", R.drawable.quest_v5_en_06);
            CARDS_IMAGES.put("quest_v5_en_07", R.drawable.quest_v5_en_07);
            CARDS_IMAGES.put("quest_v5_en_08", R.drawable.quest_v5_en_08);
            CARDS_IMAGES.put("quest_v5_en_09", R.drawable.quest_v5_en_09);
            CARDS_IMAGES.put("quest_v5_en_10", R.drawable.quest_v5_en_10);
            CARDS_IMAGES.put("quest_v5_en_11", R.drawable.quest_v5_en_11);
            CARDS_IMAGES.put("quest_v5_en_12", R.drawable.quest_v5_en_12);
            CARDS_IMAGES.put("quest_v5_en_13", R.drawable.quest_v5_en_13);
            CARDS_IMAGES.put("quest_v5_en_14", R.drawable.quest_v5_en_14);
            CARDS_IMAGES.put("quest_v5_en_15", R.drawable.quest_v5_en_15);
            CARDS_IMAGES.put("quest_v5_en_16", R.drawable.quest_v5_en_16);
        }

        bar1 = findViewById(R.id.card1Scroller);
        bar2 = findViewById(R.id.card2Scroller);

        ((Button) findViewById(R.id.checkCardsButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (board.dumpSize() <= 0) {
                    return;
                }

                if (board.dumpSize() == 1) {
                    startActivityForResult((new Intent(GameActivity.this, SelectCardActivity.class)).putExtra("first", 0).putExtra("second", -1), LAUNCH_SELECT_CARD_ACTIVITY);
                } else if (bar1.getProgress() != bar2.getProgress()) {
                    startActivityForResult((new Intent(GameActivity.this, SelectCardActivity.class)).putExtra("first", bar1.getProgress()).putExtra("second", bar2.getProgress()), LAUNCH_SELECT_CARD_ACTIVITY);
                } else {
                    return;
                }
            }
        });

        redraw();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.game_option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.new_game) {
            startActivityForResult(new Intent(GameActivity.this, NumberOfPlayersActivity.class), LAUNCH_PLAYERS_LIST_ACTIVITY);
        }

        if (item.getItemId() == R.id.help) {
            startActivity(new Intent(GameActivity.this, HelpActivity.class));
        }

        if (item.getItemId() == R.id.about) {
            startActivity(new Intent(GameActivity.this, AboutActivity.class));
        }

        if (item.getItemId() == R.id.exit) {
            GameActivity.this.finish();
        }

        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        /*
         * Do not handle other results than OK.
         */
        if (resultCode != RESULT_OK) {
            return;
        }

        if (requestCode == LAUNCH_PLAYERS_LIST_ACTIVITY) {
            List<String> names = new ArrayList<String>();

            if (data.getBooleanExtra("player1Enabled", false)) {
                names.add(data.getCharSequenceExtra("player1Name").toString());
            }
            if (data.getBooleanExtra("player2Enabled", false)) {
                names.add(data.getCharSequenceExtra("player2Name").toString());
            }
            if (data.getBooleanExtra("player3Enabled", false)) {
                names.add(data.getCharSequenceExtra("player3Name").toString());
            }
            if (data.getBooleanExtra("player4Enabled", false)) {
                names.add(data.getCharSequenceExtra("player4Name").toString());
            }
            if (data.getBooleanExtra("player5Enabled", false)) {
                names.add(data.getCharSequenceExtra("player5Name").toString());
            }
            if (data.getBooleanExtra("player6Enabled", false)) {
                names.add(data.getCharSequenceExtra("player6Name").toString());
            }

            /*
             * Convert the list of names to array of names.
             */
            if (board.newGame(names.toArray(new String[0])) == false) {
                findViewById(R.id.tableLayout).setVisibility(View.INVISIBLE);
                Toast.makeText(GameActivity.this, R.string.game_not_started_text, Toast.LENGTH_LONG).show();
            } else {
                redraw();
                findViewById(R.id.tableLayout).setVisibility(View.VISIBLE);
            }
        }

        if (requestCode == LAUNCH_SELECT_CARD_ACTIVITY) {
            /*
             * Try to take a card.
             */
            if (!board.takeFromDump(data.getIntExtra("index", -1))) {
                Toast.makeText(GameActivity.this, R.string.no_card_taken_text, Toast.LENGTH_LONG).show();
            } else {
                redraw();
            }
        }
    }

    /**
     * After change in the object model the user interface should be updated.
     */
    private void redraw() {
        int dumpSize = board.dumpSize();

        if (dumpSize > 0) {
            bar1.setMin(0);
            bar2.setMax(dumpSize - 1);
            bar1.setMin(0);
            bar2.setMax(dumpSize - 1);
        } else {
            bar1.setMin(0);
            bar2.setMax(0);
            bar1.setMin(0);
            bar2.setMax(0);
        }
    }
}
