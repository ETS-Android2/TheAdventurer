package fr.iut63.a2ddicegameupdate.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import fr.iut63.a2ddicegameupdate.R;

public class ScoresActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, MainActivity.class);
        Button button = findViewById(R.id.buttonRetour);
        button.setOnClickListener(view -> setContentView(R.layout.activity_main));
    }
}