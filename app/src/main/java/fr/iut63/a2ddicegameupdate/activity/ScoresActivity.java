package fr.iut63.a2ddicegameupdate.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import fr.iut63.a2ddicegameupdate.R;

public class ScoresActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_selector);

        Button backButton = findViewById(R.id.buttonRetour);
        backButton.setOnClickListener(view -> finish());

    }
}