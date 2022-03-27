package fr.iut63.a2ddicegameupdate.models.loop;

import static java.lang.Thread.sleep;

/**
 * Classe loop héritant de LoopListener dans le but de gérer le timer.
 */
public class Loop extends LoopListener implements Runnable {

    private long millis = 50;
    private long time;

    /**
     * Getter du timer
     * @return time
     */
    public int getTime() {
        return (int) time;
    }

    private boolean running = false;

    private final long startTime = System.currentTimeMillis();

    /**
     * Méthode renvoyany l'état du timer (en marche ou à l'arrêt)
     * @return true si en marche false sinon.
     */
    public boolean isRunning(){return running;}

    /**
     * Setter du running
     * @param run
     */
    public void setRunning(boolean run){
        running = run;
    }

    /**
     * Start du timer
     */
    public void start() {
        running = true;
        run();
    }

    /**
     * Thread du timer avec la fonction run
     */
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

    /**
     * Notify du timer
     * @param timer temps écoulé
     */
    private void beep(int timer) {
        notify(timer);
    }
}