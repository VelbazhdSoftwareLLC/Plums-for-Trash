package eu.veldsoft.plums.trash;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

/**
 * Select card to take from two possible cards.
 */
public class SelectCardActivity extends Activity {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_card);

        findViewById(R.id.cardSelectedButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = ((RadioGroup) findViewById(R.id.cardOptions)).getCheckedRadioButtonId();
                if (index == -1) {
                    return;
                }

                finish();
            }
        });
    }
}