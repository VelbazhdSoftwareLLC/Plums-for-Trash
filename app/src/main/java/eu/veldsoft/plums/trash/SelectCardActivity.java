package eu.veldsoft.plums.trash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

/**
 * Select card to take from two possible cards.
 */
public class SelectCardActivity extends Activity {
    /**
     * Map of the card key and card image reference.
     */
    private static Map<String, Integer> CARDS_IMAGES = new HashMap<String, Integer>();

    /**
     * Card image key for the first card.
     */
    private String key1 = "garbage_cards_v6_01";

    /**
     * Card image key for the second card.
     */
    private String key2 = "garbage_cards_v6_01";

    /**
     * Index of the first card into the dump.
     */
    private int index1 = -1;

    /**
     * Index of the second card into the dump.
     */
    private int index2 = -1;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_card);

        CARDS_IMAGES = GameActivity.CARDS_IMAGES;

        ((ImageView) findViewById(R.id.firstCard)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((RadioButton) findViewById(R.id.firstOption)).setChecked(true);
            }
        });

        ((ImageView) findViewById(R.id.secondCard)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((RadioButton) findViewById(R.id.secondOption)).setChecked(true);
            }
        });

        findViewById(R.id.cardSelectedButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = ((RadioGroup) findViewById(R.id.cardOptions)).getCheckedRadioButtonId();
                if (index == -1) {
                    Toast.makeText(SelectCardActivity.this, R.string.please_select_a_card_text, Toast.LENGTH_LONG).show();
                    return;
                }

                if (index == R.id.firstOption && index1 != -1) {
                    setResult(Activity.RESULT_OK, (new Intent()).putExtra("index", index1));
                    SelectCardActivity.this.finish();
                } else if (index == R.id.secondOption && index2 != -1) {
                    setResult(Activity.RESULT_OK, (new Intent()).putExtra("index", index2));
                    SelectCardActivity.this.finish();
                } else if (index == 1 && index1 == -1) {
                    Toast.makeText(SelectCardActivity.this, R.string.first_card_is_not_proper_for_selection_text, Toast.LENGTH_LONG).show();
                } else if (index == 2 && index2 == -1) {
                    Toast.makeText(SelectCardActivity.this, R.string.second_card_is_not_proper_for_selection_text, Toast.LENGTH_LONG).show();
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

        index1 = getIntent().getIntExtra("index1", -1);
        index2 = getIntent().getIntExtra("index2", -1);
        key1 = getIntent().getStringExtra("key1");
        key2 = getIntent().getStringExtra("key2");

        if (key1 == null) {
            key1 = "garbage_cards_v6_01";
        }

        if (key2 == null) {
            key2 = "garbage_cards_v6_01";
        }

        ((ImageView) findViewById(R.id.firstCard)).setImageResource(CARDS_IMAGES.get(key1));
        ((ImageView) findViewById(R.id.secondCard)).setImageResource(CARDS_IMAGES.get(key2));
    }
}
