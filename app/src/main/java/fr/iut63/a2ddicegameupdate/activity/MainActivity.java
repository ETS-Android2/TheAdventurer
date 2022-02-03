package fr.iut63.a2ddicegameupdate.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import fr.iut63.a2ddicegameupdate.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, ScoresActivity.class);

        Button buttonScore = findViewById(R.id.buttonScores);
        Button buttonPartie = findViewById(R.id.buttonNouvellePartie);

        buttonScore.setOnClickListener(view -> setContentView(R.layout.menu_selector));
        buttonPartie.setOnClickListener(view -> setContentView(R.layout.menu_selector));
    }
}