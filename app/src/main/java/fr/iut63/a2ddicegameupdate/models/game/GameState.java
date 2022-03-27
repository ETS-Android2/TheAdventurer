package fr.iut63.a2ddicegameupdate.models.game;

import android.os.Build;

import androidx.annotation.RequiresApi;
import java.util.Objects;

/**
 * Classe De l'état de la partie (timer, menu pause, etc).
 */
public class GameState implements Comparable<GameState>{


    private int timeSeconds ;
    public int getTimeSeconds() {return timeSeconds;}
    public int timeSecondsProperty() {return timeSeconds;}
    public void setTimeSeconds(int timeSeconds) {this.timeSeconds = timeSeconds;}

    /**
     * Constructeur de la classe GameState avec le setter du timer à 0.
     */
    public GameState(){
        setTimeSeconds(0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameState gameState = (GameState) o;
        return timeSeconds == gameState.timeSeconds;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(timeSeconds);
    }

    @Override
    public int compareTo(GameState gameState) {
        return 0;
    }
}
