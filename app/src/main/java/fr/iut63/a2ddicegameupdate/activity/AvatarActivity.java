package fr.iut63.a2ddicegameupdate.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

import fr.iut63.a2ddicegameupdate.R;

public class AvatarActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avatar_selector);

        Button backButton = findViewById(R.id.buttonRetour);
        backButton.setOnClickListener(view ->  {
            finish();
        });

        /*Button nextButton = findViewById(R.id.buttonNext);
        nextButton.setOnClickListener(view -> {
            setContentView(R.layout.avatar_selector);
        });*/

    }
}
