package eu.veldsoft.plums.trash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Initial menu screen.
 */
public class MenuActivity extends Activity {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu);

        /*
         * Open new game screen.
         */
        findViewById(R.id.single_game).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MenuActivity.this, GameActivity.class));
                    }
                }
        );

        /*
         * Application exit.
         */
        findViewById(R.id.exit_game).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MenuActivity.this.finish();
                    }
                }
        );
    }
}
