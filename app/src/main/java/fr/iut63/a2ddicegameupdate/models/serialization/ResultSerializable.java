package fr.iut63.a2ddicegameupdate.models.serialization;

import java.io.Serializable;

public class ResultSerializable implements Serializable {

    private String pseudo;
    private int level;
    private int score;
    private int time;

    public ResultSerializable(String pseudo, int level, int score, int time){
        this.pseudo = pseudo;
        this.level = level;
        this.score = score;
        this.time = time;
    }

    public String getPseudo() {
        return pseudo;
    }

    public int getLevel() {
        return level;
    }

    public int getScore() {
        return score;
    }

    public int getTime() {
        return time;
    }
}
