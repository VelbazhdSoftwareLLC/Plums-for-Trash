package eu.veldsoft.plums.trash;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.util.HashMap;
import java.util.Map;

//TODO Write JavaDoc comment for the class.

/**
 *
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

        //TODO Handle buy button.
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onStart() {
        super.onStart();

        keys = getIntent().getStringArrayExtra("keys");

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
