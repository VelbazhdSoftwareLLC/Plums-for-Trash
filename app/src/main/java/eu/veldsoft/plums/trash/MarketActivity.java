package eu.veldsoft.plums.trash;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents the activity responsible for displaying and interacting with the market view.
 * This activity shows a visual representation of available cards using an {@link ImageView}
 * and allows navigation through the cards using a {@link SeekBar}. The card images are loaded
 * based on keys passed via the intent extras.
 * Card image references are retrieved from a shared static map of keys to drawable resource IDs.
 */
public class MarketActivity extends Activity {
    /**
     * Map of the card key and card image reference.
     */
    private static Map<String, Integer> CARDS_IMAGES = new HashMap<>();

    /**
     * Array with cards' keys.
     */
    private String[] keys = {};

    /**
     * Array showed if cards are affordable.
     */
    private boolean affordable[] = {};

    /**
     * Card image view reference.
     */
    private ImageView image = null;

    /**
     * Seek bar reference.
     */
    private SeekBar bar = null;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);


        CARDS_IMAGES = GameActivity.CARDS_IMAGES;

        image = ((ImageView) findViewById(R.id.marketCard));
        bar = findViewById(R.id.marketScroller);
        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (keys != null && keys.length > 0) {
                    image.setImageResource(CARDS_IMAGES.get(keys[i]));
                } else {
                    image.setImageResource(R.drawable.garbage_cards_v6_01);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        ((Button) findViewById(R.id.buyButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (affordable != null && affordable.length > bar.getProgress() && affordable[bar.getProgress()] == true) {
                    setResult(Activity.RESULT_OK, (new Intent()).
                            putExtra("index", bar.getProgress()).
                            putExtra("key", keys[bar.getProgress()]));
                    MarketActivity.this.finish();
                } else {
                    Toast.makeText(MarketActivity.this, R.string.can_not_buy_text, Toast.LENGTH_LONG).show();
                }
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
        affordable = getIntent().getBooleanArrayExtra("affordable");

        if (keys != null && keys.length > 0) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                bar.setMin(0);
            }
            bar.setMax(keys.length - 1);
        } else {
            image.setImageResource(R.drawable.garbage_cards_v6_01);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                bar.setMin(0);
            }
            bar.setMax(0);
        }
    }
}
