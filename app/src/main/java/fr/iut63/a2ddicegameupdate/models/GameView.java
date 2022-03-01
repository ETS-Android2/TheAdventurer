package fr.iut63.a2ddicegameupdate.models;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Handler;

import fr.iut63.a2ddicegameupdate.R;
import fr.iut63.a2ddicegameupdate.activity.Play;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private static final int CONTROLS_PADDING = 10;

    private static final int START_STAGE = 1;
    private static final int START_LEVEL = 1;

    private static final int ROLL_DICE = 1;
    private static final int VIEW_LAST_ACTIONS = 2;

    public static final int STATE_RUNNING = 1;
    public static final int STATE_PAUSED = 2;

    private int mScreenXMax = 0;
    private int mScreenYMax = 0;
    private int mScreenXCenter = 0;
    private int mScreenYCenter = 0;
    private int mScreenXOffset = 0;
    private int mScreenYOffset = 0;

    private float mScreenDensity;

    private Context mGameContext;
    private Play mGameActivity;
    private SurfaceHolder mGameSurfaceHolder = null;

    private boolean updatingGameTiles = false;

    private PlayerUnit mPlayerUnit = null;

    private int mPlayerStage = START_STAGE;
    private int mPlayerLevel = START_LEVEL;

    private Bitmap mBackgroundImage = null;

    private int mGameState;

    private boolean mGameRun = true;

    private boolean mPlayerMoving = false;
    private int mPlayerVerticalDirection = 0;
    private int mPlayerHorizontalDirection = 0;

    private GameUi mRollDice = null;


    private Paint mUiTextPaint = null;
    private String mLastStatusMessage = "";

    /**
     * Templates defining all available game tiles.
     */
    private HashMap<Integer, ArrayList<Integer>> mGameTileTmp = null;

    /**
     * Bitmap instances for each game tile type.
     */
    private HashMap<Integer, Bitmap> mGameTileBitmaps = new HashMap<Integer, Bitmap>();

    /**
     * GameTile instances for each game tile used by the current level.
     */
    private List<GameTile> mGameTiles = new ArrayList<GameTile>();

    private int mPlayerStartTileX = 0;
    private int mPlayerStartTileY = 0;

    private int mTileWidth = 32;
    private int mTileHeight = 32;

    class GameThread extends Thread {
        public GameThread(SurfaceHolder surfaceHolder, Context context, Handler handler) {
            mGameSurfaceHolder = surfaceHolder;
            mGameContext = context;

            Resources res = context.getResources();

            mBackgroundImage = BitmapFactory.decodeResource(res, R.drawable.canvas_bg_01);

            Display display = mGameActivity.getWindowManager().getDefaultDisplay();
            mScreenXMax = display.getWidth();
            mScreenYMax = display.getHeight();
            mScreenXCenter = (mScreenXMax / 2);
            mScreenYCenter = (mScreenYMax / 2);

            setGameStartState();
        }

        public void setSurfaceSize(int width, int height)
        {
            // synchronized to make sure these all change atomically
            synchronized (mGameSurfaceHolder)
            {
                mBackgroundImage = Bitmap.createScaledBitmap(mBackgroundImage,
                        width, height, true);
            }
        }

        public void setRunning(boolean run)
        {
            mGameRun = run;
        }

        /**
         * Sets the game state to running.
         */
        public void doStart()
        {
            setState(STATE_RUNNING);
        }

        /**
         * Sets the game state
         * @param state mode - May be STATE_RUNNING or STATE_PAUSED
         */
        public void setState(int state)
        {
            mGameState = state;
        }

        /**
         * Contains the main game loop, which updates all elements of the game.
         */
        @Override
        public void run()
        {
            while (mGameRun)
            {
                Canvas c = null;
                try
                {
                    c = mGameSurfaceHolder.lockCanvas(null);
                    synchronized (mGameSurfaceHolder)
                    {
                        if (mGameState == STATE_RUNNING)
                        {
                            updatePlayerUnit();
                        }

                        doDraw(c);
                    }
                } finally
                {
                    if (c != null)
                    {
                        mGameSurfaceHolder.unlockCanvasAndPost(c);
                    }
                }
            }

            return;
        }

        /**
         * Pauses the game.
         */
        public void pause()
        {
            synchronized (mGameSurfaceHolder)
            {
                if (mGameState == STATE_RUNNING)
                {
                    setState(STATE_PAUSED);
                }
            }
        }

        /**
         * Unpauses the game.
         */
        public void unpause()
        {
            synchronized (mGameSurfaceHolder)
            {
                if (mGameState != STATE_RUNNING)
                {
                    setState(STATE_RUNNING);
                }
            }
        }

        /**
         * Centers the game view around the location of the player unit.
         */
        private void centerView()
        {
            mPlayerUnit.setUnmodifiedX(mPlayerUnit.getX() + mScreenXCenter);
            mPlayerUnit.setUnmodifiedY(mPlayerUnit.getY() + mScreenYCenter);

            mScreenXOffset = (mPlayerUnit.getX() - mScreenXCenter);
            mScreenYOffset = (mPlayerUnit.getY() - mScreenYCenter);

            mPlayerUnit.setX(mScreenXCenter);
            mPlayerUnit.setY(mScreenYCenter);
        }

        /**
         * Draws all visual elements of the game.
         * @param canvas canvas
         */
        private void doDraw(Canvas canvas)
        {
            centerView();

            if (canvas != null)
            {
                canvas.drawBitmap(mBackgroundImage, 0, 0, null);

                if (!updatingGameTiles)
                {
                    drawGameTiles(canvas);
                }

                if (mPlayerUnit != null)
                {
                    canvas.drawBitmap(mPlayerUnit.getBitmap(), mPlayerUnit.getX(),
                            mPlayerUnit.getY(), null);
                }

                drawControls(canvas);

                canvas.drawText(mLastStatusMessage, 30, 50, mUiTextPaint);
            }
        }

        /**
         * Draws the game tiles used in the current level.
         * @param canvas canvas
         */
        private void drawGameTiles(Canvas canvas)
        {
            int gameTilesSize = mGameTiles.size();
            for (int i = 0; i < gameTilesSize; i++)
            {
                if (mGameTiles.get(i) != null)
                {
                    mGameTiles.get(i).setCoordX(
                            mGameTiles.get(i).getCoordX() - mScreenXOffset);
                    mGameTiles.get(i).setCoordY(
                            mGameTiles.get(i).getCoordY() - mScreenYOffset);

                    /*
                    if (mGameTiles.get(i).isVisible())
                    {
                        canvas.drawBitmap(mGameTiles.get(i).getBitmap(),
                                mGameTiles.get(i).getCoordX(), mGameTiles.get(i)
                                        .getCoordY(), null);
                    }

                     */
                }
            }
        }

        /**
         * Draws the game controls.
         * @param canvas canvas
         */
        private void drawControls(Canvas canvas)
        {
            canvas.drawBitmap(mRollDice.getBitmap(), mRollDice.getX(), mRollDice.getY(), null);
        }

        /**
         * Updates the direction, position and state of the player unit.
         */
        private void updatePlayerUnit()
        {
            GameTile collisionTile = null;

            if (mPlayerMoving)
            {
                int differenceX = 0;
                int differenceY = 0;
                int newX = mPlayerUnit.getX();
                int newY = mPlayerUnit.getY();

            }
        }

    }

    public GameView(Context context) {
        super(context);
    }

    private void setControlsStart()
    {
        if (mRollDice == null)
        {
            mRollDice = new GameUi(mGameContext, R.drawable.icon);

            mRollDice.setX(mScreenXMax - ((mRollDice.getWidth() * 2) + getPixelValueForDensity(CONTROLS_PADDING)));
            mRollDice.setY(mScreenYMax - (mRollDice.getHeight() + getPixelValueForDensity(CONTROLS_PADDING)));
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        int eventAction = event.getAction();

        if (eventAction == MotionEvent.ACTION_BUTTON_PRESS) {
            if (mGameState == STATE_RUNNING) {
                final int x = (int) event.getX();
                final int y = (int) event.getY();

                if (mRollDice.getImpact(x, y)) {
                    Log.d("Tile Game Example", "Pressed roll dice button");
                    mLastStatusMessage = "Rolling Dice";
                    mPlayerMoving = true;
                }
            }
        }

        return true;
    }

    private GameThread thread;

    public GameView(Context context, Play activity, int stage, int level, float screenDensity)
    {
        super(context);

        mGameContext = context;
        mGameActivity = activity;

        mScreenDensity = screenDensity;

        mPlayerStage = stage;
        mPlayerLevel = level;

        SurfaceHolder holder = getHolder();
        holder.addCallback(this);

        // create thread only; it's started in surfaceCreated()
        thread = new GameThread(holder, context, null);

        setFocusable(true);

        mUiTextPaint = new Paint();
        mUiTextPaint.setStyle(Paint.Style.FILL);
        mUiTextPaint.setColor(Color.YELLOW);
        mUiTextPaint.setAntiAlias(true);

        Typeface uiTypeface = Typeface.createFromAsset(activity.getAssets(), "fonts/Molot.otf");
        if (uiTypeface != null)
        {
            mUiTextPaint.setTypeface(uiTypeface);
        }

        //startLevel();
        thread.doStart();
    }


    public GameThread getThread()
    {
        return thread;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder)
    {
        // start the thread here so that we don't busy-wait in run()
        // waiting for the surface to be created

        if (thread.getState() == Thread.State.TERMINATED)
        {
            //thread = new GameThread(holder, getContext(), new Handler());
            thread.setRunning(true);
            thread.start();
            thread.doStart();
            //startLevel();
        }
        else
        {
            thread.setRunning(true);
            thread.start();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height)
    {
        thread.setSurfaceSize(width, height);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder)
    {
        boolean retry = true;
        thread.setRunning(false);
        while (retry)
        {
            try
            {
                thread.join();
                retry = false;
            } catch (InterruptedException e)
            {
                Log.e("Tile Game Example", e.getMessage());
            }
        }
    }

    private void setPlayerStart()
    {
        if (mPlayerUnit == null)
        {
            mPlayerUnit = new PlayerUnit(mGameContext, R.drawable.perso12);
        }

        int playerStartX = (mPlayerStartTileX * mPlayerUnit.getWidth());
        int playerStartY = (mPlayerStartTileY * mPlayerUnit.getHeight());

        Log.d("Tile Game Example", "Player unit starting at X: " + playerStartX + ", Y: " + playerStartY);

        mPlayerUnit.setX(playerStartX);
        mPlayerUnit.setY(playerStartY);
        mPlayerUnit.setUnmodifiedX(0);
        mPlayerUnit.setUnmodifiedY(0);
    }

    private void setGameStartState()
    {
        setControlsStart();
        setPlayerStart();
    }

    private int getPixelValueForDensity(int pixels)
    {
        return (int) (pixels * mScreenDensity);
    }
}
