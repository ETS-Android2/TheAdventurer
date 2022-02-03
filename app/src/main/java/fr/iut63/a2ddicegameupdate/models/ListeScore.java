package fr.iut63.a2ddicegameupdate.models;

import java.util.ArrayList;

public class ListeScore {
    private final ArrayList<Object> listeScore = new ArrayList<>();

    /**
     * Method to add a score to the list of scores
     * @param score Score to add
     */
    public void addScore(Score score) {
        listeScore.add(score);
    }

    /**
     * Method to get the list of scores
     * @return score list getter
     */
    public ArrayList<Object> getListeScore() {
        return listeScore;
    }
}
