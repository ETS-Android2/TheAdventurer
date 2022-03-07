package fr.iut63.a2ddicegameupdate.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;

import androidx.constraintlayout.widget.ConstraintLayout;

import fr.iut63.a2ddicegameupdate.R;
import fr.iut63.a2ddicegameupdate.activity.ScoresActivity;
import fr.iut63.a2ddicegameupdate.models.GameView;
import fr.iut63.a2ddicegameupdate.models.map.DrawMap;
import fr.iut63.a2ddicegameupdate.models.map.MapGeneration;

public class Play extends Activity
{
    private GameView mGameView = null;

    private final DisplayMetrics mMetrics = new DisplayMetrics();
    private float mScreenDensity;
    private DrawMap drawMap;
    private ConstraintLayout constraintLayout;

    private int height;
    private int width;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        Context mContext = getApplicationContext();

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
        mScreenDensity = mMetrics.density;


        height = mMetrics.heightPixels;
        width = mMetrics.widthPixels;

        int stage = 1;
        int level = 1;
        constraintLayout = findViewById(R.id.constLayoutGame);
        drawMap = new DrawMap(this, new MapGeneration(width, height));
        drawMap.drawMap();

        setContentView(mGameView);
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

    public ConstraintLayout getConstraintLayout() {
        return constraintLayout;
    }
}