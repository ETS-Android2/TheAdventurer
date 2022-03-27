package fr.iut63.a2ddicegameupdate.models.loop;

import static java.lang.Thread.sleep;

public class Loop extends LoopListener implements Runnable {

    private long millis = 50;
    private long time;

    public int getTime() {
        return (int) time;
    }

    private boolean running = false;

    private final long startTime = System.currentTimeMillis();

    public boolean isRunning(){return running;}

    public void setRunning(boolean run){
        running = run;
    }

    public void start() {
        running = true;
        run();
    }

    @Override
    public void run() {
        while(isRunning()) {
            try {
                sleep(millis);
                //timer++;
                time = ((System.currentTimeMillis()-startTime)/1000);
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