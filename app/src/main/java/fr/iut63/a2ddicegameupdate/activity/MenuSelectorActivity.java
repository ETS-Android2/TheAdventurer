package fr.iut63.a2ddicegameupdate.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

import fr.iut63.a2ddicegameupdate.R;

public class MenuSelectorActivity extends Activity {

    public static int difficulty = 1;
    public static int avatar = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_selector);


        RadioButton difficultychoice1 = findViewById(R.id.difficulty_button_1);
        difficultychoice1.setOnClickListener(view -> difficulty = 1);

        RadioButton difficultychoice2 = findViewById(R.id.difficulty_button_2);
        difficultychoice2.setOnClickListener(view -> difficulty = 2);

        RadioButton difficultychoice3 = findViewById(R.id.difficulty_button_3);
        difficultychoice3.setOnClickListener(view -> difficulty = 3);

        Button nextButton = findViewById(R.id.buttonNext);
        nextButton.setOnClickListener(view -> nextMenu());

        Button backButton = findViewById(R.id.buttonRetour);
        backButton.setOnClickListener(view -> finish());
    }

    void nextMenu(){
        Intent i = new Intent(this, AvatarSelectorActivity.class);
        i.putExtra("difficulty", difficulty);
        startActivity(i);
    }
}