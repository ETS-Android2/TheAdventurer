package fr.iut63.a2ddicegameupdate.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import fr.iut63.a2ddicegameupdate.R;

public class GameActivity  extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_panel);

        Bundle extras = getIntent().getExtras();
        Log.d("EXTRA", extras.getString("difficulty"));
    }
}
