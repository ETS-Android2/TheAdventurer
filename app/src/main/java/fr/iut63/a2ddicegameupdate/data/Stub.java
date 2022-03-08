package fr.iut63.a2ddicegameupdate.data;

import java.io.InputStream;
import java.io.Serializable;

import fr.iut63.a2ddicegameupdate.models.ListeScore;

public class Stub implements Loader {

    public Serializable load(InputStream nomDuFichier){
        ListeScore listeS = new ListeScore();
        listeS.addResultat(12564, 2, "22-07-2133");
        listeS.addResultat(1564, 1, "22-07-2133");
        listeS.addResultat(1254, 1, "22-07-2133");
        listeS.addResultat(64, 3, "22-07-2133");
        listeS.addResultat(124, 1, "22-07-2133");
        listeS.addResultat(12545, 2, "22-07-2133");

        return listeS;
    }

}


// https://github.com/ruscoe/Android-Tile-Based-Game
// https://gitlab.iut-clermont.uca.fr/jutheme/projetjavafx/-/blob/main/code/ressources/image/personnage/Perso1.2.png