package fr.iut63.a2ddicegameupdate.models;

import static java.lang.Thread.sleep;

import android.util.Log;

import java.util.logging.Handler;

public class Loop extends LoopListener implements Runnable {
    private static final long DEFAULT_MILLIS = 50;
    private long millis = 50;
    private int timer = 0;
    private boolean running = false;

    private final long startTime = System.currentTimeMillis();

    public static long getDefaultMillis() {return DEFAULT_MILLIS;}

    public long getMillis(){return millis;}
    public void setMillis(long millis){this.millis = millis;}


    public boolean isRunning(){return running;}
    public void setRunning(boolean run){running = run;}

    public void start() {
        running = true;
        run();
    }


    @Override
    public void run() {
        long time;
        while(isRunning()) {
            try {
                sleep(millis);
                //timer++;
                time = ((System.currentTimeMillis()-startTime)/1000);
                Log.d("GameTime", "run: "+(time));
                beep((int)time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void beep(int timer) {
        notify(timer);
    }
}