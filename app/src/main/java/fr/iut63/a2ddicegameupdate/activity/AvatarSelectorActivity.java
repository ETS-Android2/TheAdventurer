package fr.iut63.a2ddicegameupdate.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.RadioButton;

import fr.iut63.a2ddicegameupdate.R;

/**
 * Activité de séléction du personnage avant le lancement du jeu
 */
public class AvatarSelectorActivity extends Activity {

    public static int avatar = 1;

    /**
     * Lancement de la vue du choix des personnage à la  création de l'activité
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avatar_selector);

        RadioButton avatar_1 = findViewById(R.id.avatar_button_1);
        avatar_1.setOnClickListener(view -> avatar = 1);

        RadioButton avatar_2 = findViewById(R.id.avatar_button_2);
        avatar_2.setOnClickListener(view -> avatar = 2);

        RadioButton avatar_3 = findViewById(R.id.avatar_button_3);
        avatar_3.setOnClickListener(view -> avatar = 3);

        Button backButton = findViewById(R.id.buttonRetour);
        backButton.setOnClickListener(view -> finish());

        Button startGameButton = findViewById(R.id.startGameButton);
        startGameButton.setOnClickListener(view -> startGame());

    }

    /**
     * Méthode appelé lors du lancement du jeu (stockage des choix du joueur sur la difficulté et l'avatar puis lancement)
     */
    void startGame() {

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            int value = extras.getInt("difficulty");
            Intent i = new Intent(this, Play.class);
            i.putExtra("difficulty", value);
            i.putExtra("avatar", avatar);
            startActivity(i);
        }else{
            Log.e("ERROR", "Start failed.");
        }
    }
}
