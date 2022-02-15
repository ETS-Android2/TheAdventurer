package fr.iut63.a2ddicegameupdate.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import fr.iut63.a2ddicegameupdate.R;
import fr.iut63.a2ddicegameupdate.models.ListeScore;
import fr.iut63.a2ddicegameupdate.models.Personnage;
import fr.iut63.a2ddicegameupdate.models.Resultat;

public class DifficultyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_selector);

        RadioButton rd = findViewById(R.id.)

        Button backButton = findViewById(R.id.buttonRetour);
        backButton.setOnClickListener(view ->  {
            finish();
        });

        Button nextButton = findViewById(R.id.buttonNext);
        nextButton.setOnClickListener(view -> {
            setContentView(R.layout.avatar_selector);
        });

    }
}