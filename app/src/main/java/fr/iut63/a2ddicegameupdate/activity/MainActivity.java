package fr.iut63.a2ddicegameupdate.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import fr.iut63.a2ddicegameupdate.R;
import fr.iut63.a2ddicegameupdate.data.FileLoader;
import fr.iut63.a2ddicegameupdate.data.FileSaviour;
import fr.iut63.a2ddicegameupdate.data.Loader;
import fr.iut63.a2ddicegameupdate.data.Saviour;
import fr.iut63.a2ddicegameupdate.data.Stub;
import fr.iut63.a2ddicegameupdate.models.ListeScore;
import fr.iut63.a2ddicegameupdate.models.Resultat;

public class MainActivity extends AppCompatActivity {

    public static final String LE_FICHIER_RESULTAT = "test";
    private ListeScore listeScore;
    private Saviour saviour = new FileSaviour();
    private Loader leLoader = new FileLoader();
    private Resultat resultats = null;

    @SuppressLint("LongLogTag")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (listeScore == null) {
            leLoader = new Stub();
            listeScore = (ListeScore) leLoader.load(null);
        }

        for ( Resultat r: listeScore.getListeResultats()) {
            Log.d("--- Log Resultat ---", "Score : " + r.getScore() + " Level : " + r.getLevel() );
        }

        Button buttonScore = findViewById(R.id.buttonScores);
        Button buttonPartie = findViewById(R.id.buttonNouvellePartie);

        buttonScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivities("scoreActivity");
            }
        });

        buttonPartie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivities("gameActivity");
            }
        });
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
        try {
            saviour.save(openFileOutput(LE_FICHIER_RESULTAT, MODE_PRIVATE), listeScore);
        } catch (FileNotFoundException e) {
            Log.e(getPackageName(), "Impossible de sauvegarder la liste des résultats");
        }

        super.onStop();
    }

    public Resultat getResultats() {
        return resultats;
    }

    public ListeScore getListeScore() {
        return listeScore;
    }
}


