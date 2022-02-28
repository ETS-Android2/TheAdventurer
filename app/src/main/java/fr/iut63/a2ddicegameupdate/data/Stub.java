package fr.iut63.a2ddicegameupdate.data;

import java.io.FileInputStream;
import java.io.Serializable;
import java.util.Date;

import fr.iut63.a2ddicegameupdate.models.Personnage;
import fr.iut63.a2ddicegameupdate.models.Resultat;
import fr.iut63.a2ddicegameupdate.models.ListeScore;

public class Stub implements Loader {

    public Serializable load(FileInputStream nomDuFichier){
        ListeScore listeS = new ListeScore();
        listeS.addResultat(12564, 2, new Date(System.currentTimeMillis()));
        listeS.addResultat(1564, 1, new Date(System.currentTimeMillis()));
        listeS.addResultat(1254, 1, new Date(System.currentTimeMillis()));
        listeS.addResultat(64, 3, new Date(System.currentTimeMillis()));
        listeS.addResultat(124, 1, new Date(System.currentTimeMillis()));
        listeS.addResultat(12545, 2, new Date(System.currentTimeMillis()));

        return listeS;
    }

}