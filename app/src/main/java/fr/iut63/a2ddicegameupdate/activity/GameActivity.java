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
            avatar = extras.getInt("avatar");
        }

        if(avatar == 3){
//            imagePersoPath ="R.drawable.perso32";
            //imageViewPerso.setImageResource(R.drawable.);
        }else if(avatar == 2){
//            imagePersoPath ="R.drawable.perso22";
            //imageViewPerso.setImageResource(R.drawable.perso22);
        }else{
//            imagePersoPath ="R.drawable.perso12";
            imageViewPerso.setImageResource(R.drawable.perso12);
        }
        imageViewPerso.setImageResource(R.drawable.perso12);
        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.layout);
        layout.addView(imageViewPerso);


//        Bundle extras = getIntent().getExtras();
//        Log.d("EXTRA", extras.getString("difficulty"));
    }
}
