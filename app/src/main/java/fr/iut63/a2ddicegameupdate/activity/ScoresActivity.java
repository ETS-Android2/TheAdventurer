package fr.iut63.a2ddicegameupdate.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.InputStream;

import fr.iut63.a2ddicegameupdate.R;
import fr.iut63.a2ddicegameupdate.models.ListeScore;
import fr.iut63.a2ddicegameupdate.models.Resultat;

public class ScoresActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_selector);

        Button backButton = findViewById(R.id.buttonRetour);
        backButton.setOnClickListener(view ->  {
            finish();
        });

    }

    public void affichage(){
        Resultat res = new Resultat();
        ListeScore sc = res.chargerResultat();
    }

}