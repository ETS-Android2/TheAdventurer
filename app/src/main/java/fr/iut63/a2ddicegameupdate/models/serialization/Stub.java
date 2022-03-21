package fr.iut63.a2ddicegameupdate.models.serialization;

import java.io.InputStream;
import java.io.Serializable;

public class Stub implements Loader {

    public Serializable load(InputStream nomDuFichier){
        ScoreRankSerializable listeS = new ScoreRankSerializable();
        listeS.addResult(new ResultSerializable("ZartaX0O3", 3, 12543, 156));
        listeS.addResult(new ResultSerializable("Zytrox", 4, 12543, 154));
        listeS.addResult(new ResultSerializable("ZartaX0O3", 2, 12543, 136));
        listeS.addResult(new ResultSerializable("Zytrox", 2, 12543, 100));
        listeS.addResult(new ResultSerializable("Zytrox", 1, 12543, 114));
        listeS.addResult(new ResultSerializable("Zytrox", 1, 12543, 98));

        return listeS;
    }
}
