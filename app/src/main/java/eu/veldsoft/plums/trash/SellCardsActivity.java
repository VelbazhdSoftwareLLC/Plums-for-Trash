package eu.veldsoft.plums.trash;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.util.HashMap;
import java.util.Map;


/**
 * Activity for selling card/s
 * This class show interface, which access the user/player to sell his cards
 */
public class SellCardsActivity extends Activity {
    /**
     * Map of the card key and card image reference.
     */
    private static Map<String, Integer> CARDS_IMAGES = new HashMap<>();

    /**
     * Array with cards' keys.
     */
    private String[] keys = {};

    /**
     * Selection of the cards to sell.
     */
    private boolean[] sales = {};

    /**
     * Card image view reference.
     */
    private ImageView sell = null;

    /**
     * Card image view reference.
     */
    private ImageView buy = null;

    /**
     * Seek bar reference.
     */
    private SeekBar bar = null;

    /**
     * Checked if card will be sold.
     */
    private CheckBox marked = null;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_cards);

        CARDS_IMAGES = GameActivity.CARDS_IMAGES;

        buy = ((ImageView) findViewById(R.id.cardToBuy));
        sell = ((ImageView) findViewById(R.id.cardForSale));
        bar = findViewById(R.id.salesScroller);

        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (keys != null && keys.length > 0) {
                    sell.setImageResource(CARDS_IMAGES.get(keys[progress]));
                    marked.setChecked(sales[progress]);
                } else {
                    sell.setImageResource(R.drawable.garbage_cards_v6_01);
                    marked.setChecked(false);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        ((Button) findViewById(R.id.cardsSelectedButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Activity.RESULT_OK, (new Intent()).
                        putExtra("sales", sales));
                SellCardsActivity.this.finish();
            }
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onStart() {
        super.onStart();

        keys = getIntent().getStringArrayExtra("keys");
        sales = new boolean[keys.length];

        String key = getIntent().getStringExtra("key");
        key = (key == null) ? "garbage_cards_v6_01" : key;
        buy.setImageResource(CARDS_IMAGES.get(key));

        if (keys != null && keys.length > 0) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                bar.setMin(0);
            }
            bar.setMax(keys.length - 1);
        } else {
            sell.setImageResource(R.drawable.garbage_cards_v6_01);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                bar.setMin(0);
            }
            bar.setMax(0);
        }

        bar.setProgress(0);
    }
}
