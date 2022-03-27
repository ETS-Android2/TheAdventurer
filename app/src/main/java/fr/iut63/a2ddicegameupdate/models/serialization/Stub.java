package fr.iut63.a2ddicegameupdate.models.serialization;

import android.app.Activity;

import fr.iut63.a2ddicegameupdate.activity.ScoresActivity;

/**
 * STUB de l'application (persistence légère)
 */
public class Stub implements ILoadStates {

    @Override
    public ScoreRankSerializable load(Activity context) {

        ScoreRankSerializable scoreRank = new ScoreRankSerializable();
        scoreRank.addResult(new ResultSerializable("ZartaX0O3", 3, 12543, 156));
        scoreRank.addResult(new ResultSerializable("Zytrox", 4, 12543, 154));
        scoreRank.addResult(new ResultSerializable("ZartaX0O3", 2, 12543, 136));
        scoreRank.addResult(new ResultSerializable("Zytrox", 2, 12543, 100));
        scoreRank.addResult(new ResultSerializable("Zytrox", 1, 12543, 114));
        scoreRank.addResult(new ResultSerializable("Zytrox", 1, 12543, 98));

        return scoreRank;
    }
}
