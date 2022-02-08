package fr.iut63.a2ddicegameupdate.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import fr.iut63.a2ddicegameupdate.R;
import fr.iut63.a2ddicegameupdate.models.ListeScore;
import fr.iut63.a2ddicegameupdate.models.Resultat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, ScoresActivity.class);

        Button buttonScore = findViewById(R.id.buttonScores);
        Button buttonPartie = findViewById(R.id.buttonNouvellePartie);

        buttonScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivities();
            }
        });
    }

    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, ScoresActivity.class);
        startActivity(switchActivityIntent);
    }
}


