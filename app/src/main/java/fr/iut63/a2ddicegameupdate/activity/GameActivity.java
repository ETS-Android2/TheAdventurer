package fr.iut63.a2ddicegameupdate.activity;

import android.app.Activity;
import android.os.Bundle;

import fr.iut63.a2ddicegameupdate.R;

public class GameActivity  extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_panel);
    }
}
