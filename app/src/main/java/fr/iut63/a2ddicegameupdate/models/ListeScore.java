package fr.iut63.a2ddicegameupdate.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ListeScore implements Serializable {
    private final List<Resultat> listeResultats = new ArrayList<>();

    public List<Resultat> getListeResultats() {
        return Collections.unmodifiableList(listeResultats);
    }

    public void addResultat(int score, int level, Date date) {
        listeResultats.add(new Resultat(score, level, date));
    }
}
