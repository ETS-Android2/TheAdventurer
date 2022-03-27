package fr.iut63.a2ddicegameupdate.models.serialization;

import android.app.Activity;

import fr.iut63.a2ddicegameupdate.activity.ScoresActivity;

/**
 * Classe abstraite du manager de persistence
 */
public abstract class PersistenceManager implements ISaveStates, ILoadStates {
    @Override
    public abstract void save(ScoreRankSerializable scoreRanking, Activity context);

    @Override
    public abstract ScoreRankSerializable load(Activity context);
}
