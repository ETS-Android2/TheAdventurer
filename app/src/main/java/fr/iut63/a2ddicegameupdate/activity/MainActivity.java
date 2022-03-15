package fr.iut63.a2ddicegameupdate.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    private final Resultat resultats = null;
    private Saviour leSauveur = new FileSaviour();
    private Loader leLoader;

    @SuppressLint("LongLogTag")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonScore = findViewById(R.id.buttonScores);
        Button buttonPartie = findViewById(R.id.buttonNouvellePartie);

        buttonScore.setOnClickListener(view -> switchActivities("scoreActivity"));
        buttonPartie.setOnClickListener(view -> switchActivities("gameActivity"));

        leLoader = new FileLoader();
        try {
            listeScore = (ListeScore) leLoader.load(openFileInput("test.txt"));
        } catch (FileNotFoundException e) {
        }

        if (listeScore == null) {
            leLoader = new Stub();
            listeScore = (ListeScore) leLoader.load(null);
        }
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
            leSauveur.save(openFileOutput("test.txt", MODE_PRIVATE), listeScore);
        } catch (FileNotFoundException e) {
            Log.e(getPackageName(), "Impossible de sauvegarder la promotion");
        }

        super.onStop();
    }

    public ListeScore getListeScore() {
        return listeScore;
    }
}


