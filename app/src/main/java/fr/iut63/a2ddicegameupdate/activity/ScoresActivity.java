package fr.iut63.a2ddicegameupdate.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import fr.iut63.a2ddicegameupdate.R;
import fr.iut63.a2ddicegameupdate.models.serialization.PersistenceManager;
import fr.iut63.a2ddicegameupdate.models.serialization.PersistenceManagerBinary;
import fr.iut63.a2ddicegameupdate.models.serialization.ResultSerializable;
import fr.iut63.a2ddicegameupdate.models.serialization.ScoreRankSerializable;

public class ScoresActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_selector);

        PersistenceManager pb = new PersistenceManagerBinary();
        ScoreRankSerializable scoreList = pb.load(this);
        String score = "Top Scores : \n \n \n";

        int i = 0;

        if(scoreList.getRank() != null){
            Log.e("ERROR : ", "TA MERE");
            for(ResultSerializable re : scoreList.getRank()){
                if(i == 10) break;
                score += re.getPseudo() + " " + re.getLevel() + " " + re.getScore() + " " + re.getTime() + "\n";
                i++;
            }
        }

        TextView Textview = findViewById(R.id.textViewScore);
        Textview.setText(score);

        Button backButton = findViewById(R.id.buttonRetour);
        backButton.setOnClickListener(view -> finish());

    }
}