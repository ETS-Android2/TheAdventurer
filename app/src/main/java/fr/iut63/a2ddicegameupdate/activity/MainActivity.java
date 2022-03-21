package fr.iut63.a2ddicegameupdate.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.io.FileNotFoundException;

import fr.iut63.a2ddicegameupdate.R;
import fr.iut63.a2ddicegameupdate.models.serialization.FileLoader;
import fr.iut63.a2ddicegameupdate.models.serialization.FileSaviour;
import fr.iut63.a2ddicegameupdate.models.serialization.Loader;
import fr.iut63.a2ddicegameupdate.models.serialization.Saviour;
import fr.iut63.a2ddicegameupdate.models.serialization.Stub;

public class MainActivity extends AppCompatActivity {

    public static final String LE_FICHIER_RESULTAT = "test";

    @SuppressLint("LongLogTag")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonScore = findViewById(R.id.buttonScores);
        Button buttonPartie = findViewById(R.id.buttonNouvellePartie);

        buttonScore.setOnClickListener(view -> switchActivities("scoreActivity"));
        buttonPartie.setOnClickListener(view -> switchActivities("gameActivity"));

    }

    private void switchActivities(String activity) {

        Intent switchActivityIntent;

        if(activity.equals("scoreActivity")){
            switchActivityIntent = new Intent(this, ScoresActivity.class);
        }
        else {
            switchActivityIntent = new Intent(this, MenuSelectorActivity.class);
        }

        startActivity(switchActivityIntent);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

}


