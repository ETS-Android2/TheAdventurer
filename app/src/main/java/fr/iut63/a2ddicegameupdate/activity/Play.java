package fr.iut63.a2ddicegameupdate.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;

import fr.iut63.a2ddicegameupdate.R;
import fr.iut63.a2ddicegameupdate.models.GameDrawer;
import fr.iut63.a2ddicegameupdate.models.Loop;
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
    private TextView timeview;
    private Loop loop;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.game_panel);

        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        height = displayMetrics.heightPixels;
        width = displayMetrics.widthPixels;

        int difficulty = 1;
        int avatar = 1;

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            difficulty = extras.getInt("difficulty");
            avatar = extras.getInt("avatar");
        }
        constraintLayout = findViewById(R.id.constLayoutGame);

        startLoop();

        map = new MapGeneration(width, height, difficulty);
        gameDrawer = new GameDrawer(this, map);
        gameDrawer.drawMap(difficulty);
        ImageView imgPerso = gameDrawer.drawPlayer(avatar);
        AvatarMovement avatarMovement = new AvatarMovement();
        Button button_roll_dice = findViewById(R.id.button_roll_dice);
        Play play = this;

        button_roll_dice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_roll_dice.setClickable(false);
                avatarMovement.avatarMovement(imgPerso, map, loop, play);
                button_roll_dice.setClickable(true);
            }
        });
    }

    public void endGame(){
        Button button_roll_dice = findViewById(R.id.button_roll_dice);
        button_roll_dice.setEnabled(false);

        TextView textView = new TextView(this);
        textView.setText(R.string.end_game);
        textView.setTextSize(40);
        textView.setTextColor(getResources().getColor(R.color.black));
        textView.setX((int) Math.ceil(width / 2) - (width / 7));
        textView.setY((int) Math.ceil(height / 4));
        constraintLayout.addView(textView);

        EditText editText = new EditText(this);
        editText.setHint(R.string.enter_name);
        editText.setTextSize(20);
        editText.setTextColor(getResources().getColor(R.color.black));
        editText.setX((int) Math.ceil(width / 2) - (width / 7));
        editText.setY((int) Math.ceil(height / 2));
        constraintLayout.addView(editText);

        Button button = new Button(this);
        button.setText(R.string.menu);
        button.setTextSize(40);
        button.setTextColor(getResources().getColor(R.color.black));
        button.setX((int) Math.ceil(width / 2) - (width / 10));
        button.setY((int) Math.ceil(height / 4) + (width / 4));

        constraintLayout.addView(button);

        button.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }



    public void startLoop() {
        loop = new Loop();
        loop.setRunning(true);
        Thread boucleThread = new Thread(loop);
        boucleThread.start();
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

    /*@Override
    public void update(int timer) {
        if (loop.isRunning()) {
            Updater.updateTimerSeconds(timer, Loop.getDefaultMillis(), game);
        }
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Intent i;

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