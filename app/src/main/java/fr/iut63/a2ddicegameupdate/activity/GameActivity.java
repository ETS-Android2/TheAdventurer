package fr.iut63.a2ddicegameupdate.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.XmlRes;
import androidx.constraintlayout.widget.ConstraintLayout;

import fr.iut63.a2ddicegameupdate.R;

public class GameActivity  extends Activity {

    private ImageView imageViewPerso;
    private int avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_panel);
        imageViewPerso = new ImageView(this);
        String imagePersoPath;


        Bundle extras = getIntent().getExtras();
        if (extras != null){
            avatar = 4;
        }

        imageViewPerso.setImageResource(R.drawable.perso12);
        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.layout);
        layout.addView(imageViewPerso);

        Log.d("EXTRA", extras.getString("difficulty"));
    }
}
