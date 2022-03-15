package fr.iut63.a2ddicegameupdate.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;

import fr.iut63.a2ddicegameupdate.R;
import fr.iut63.a2ddicegameupdate.models.GameDrawer;
import fr.iut63.a2ddicegameupdate.models.map.Map;
import fr.iut63.a2ddicegameupdate.models.map.MapGeneration;
import fr.iut63.a2ddicegameupdate.models.player.AvatarMovement;

public class Play extends Activity
{
    private final DisplayMetrics displayMetrics = new DisplayMetrics();
    private GameDrawer gameDrawer;
    private ConstraintLayout constraintLayout;

    private int height;
    private int width;
    private List<Bitmap> avatar;
    private MapGeneration map;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.game_panel);

        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        height = displayMetrics.heightPixels;
        width = displayMetrics.widthPixels;

        int stage = 1;
        int level = 1;
        constraintLayout = findViewById(R.id.constLayoutGame);

        map = new MapGeneration(width, height, map, level);
        gameDrawer = new GameDrawer(this, map);
        gameDrawer.drawMap();
        ImageView imgPerso = gameDrawer.drawPlayer();
        AvatarMovement avatarMovement = new AvatarMovement();
        Button button_roll_dice = findViewById(R.id.button_roll_dice);
        button_roll_dice.setOnClickListener(view -> avatarMovement.avatarMovement(imgPerso, map, this, avatar));
//        button_roll_dice.setOnClickListener(view -> Log.d("LanceDe", "Dé lancé"));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
//        if (listeScore == null) {
//            leLoader = new Stub();
//            listeScore = (ListeScore) leLoader.load(null);
//        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Intent i = null;

        switch (item.getItemId())
        {
            case R.id.menuAbout:
                i = new Intent(this, ScoresActivity.class);
                startActivity(i);
                return true;
            case R.id.menuExit:
                finish();
                return true;
        }

        return false;
    }

    /**
     * Invoked when the Activity loses user focus.
     */
    @Override
    protected void onPause()
    {
        super.onPause();

        //mGameView.getThread().setState(GameView.STATE_PAUSED); // pause game when Activity pauses
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public ConstraintLayout getConstraintLayout() {
        return constraintLayout;
    }
}