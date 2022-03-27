package fr.iut63.a2ddicegameupdate.models.serialization;

import fr.iut63.a2ddicegameupdate.activity.ScoresActivity;

public abstract class PersistenceManager implements ISaveStates, ILoadStates {
    @Override
    public abstract void save(ScoreRankSerializable scoreRanking, ScoresActivity context);

    @Override
    public abstract ScoreRankSerializable load(ScoresActivity context);
}
