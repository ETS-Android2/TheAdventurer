package fr.iut63.a2ddicegameupdate.models;

import java.time.LocalDateTime;

public class Score {
    private final int score;
    private final int level;
    private final String date;

    /**
     * Constructor for Score class
     * @param score Score du joueur
     * @param level Level du joueur
     * @param date Date du score
     */
    public Score(int score, int level,String date) {
        this.score = score;
        this.level = level;
        this.date = date;
    }

    /**
     * Method to get the level
     * @return level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Method to get the score
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * Method to get the date
     * @return date
     */
    public String getDate() {
        return date;
    }
}
