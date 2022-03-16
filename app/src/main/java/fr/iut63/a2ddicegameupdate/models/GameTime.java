package fr.iut63.a2ddicegameupdate.models;

import android.widget.TextView;

import org.w3c.dom.Text;

public class GameTime {
    private Thread timer;
    private TextView textTimer;

    /**
     * Constructor for GameTime class
     * @param textTimer
     */
    public GameTime(TextView textTimer) {
        this.textTimer = textTimer;
    }

    public void start() {
        System.out.println("GameTime.start()");
        timer = new Thread("timer") {
            public void run() {
                int time = 0;
                while (true) {
                    final int finalTime = time;
                    textTimer.post(new Runnable() {
                        @Override
                        public void run() {
                            textTimer.setText(String.valueOf(finalTime));
                        }
                    });

                    time++;
                    try {
                        timer.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        timer.start();
    }


    /**
     * Method to stop the timer
     */
    public void stop() {
        System.out.println("GameTime.stop()");
        timer.stop();
    }

    /**
     * Method to get the time
     * @return time
     */
    public int getTime() {
        return Integer.parseInt((String) textTimer.getText());
    }

}
