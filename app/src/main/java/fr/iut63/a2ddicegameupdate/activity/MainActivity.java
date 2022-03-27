package fr.iut63.a2ddicegameupdate.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;

import fr.iut63.a2ddicegameupdate.R;
import fr.iut63.a2ddicegameupdate.models.serialization.PersistenceManagerBinary;
import fr.iut63.a2ddicegameupdate.models.serialization.ResultSerializable;
import fr.iut63.a2ddicegameupdate.models.serialization.ScoreRankSerializable;

public class MainActivity extends AppCompatActivity {

    public static final String LE_FICHIER_RESULTAT = "test";
    private static final File fileSerialization = new File(System.getProperty("user.dir") + "assets/files/test.txt");

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

    private void writeToFile(String data, Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("config.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

}


