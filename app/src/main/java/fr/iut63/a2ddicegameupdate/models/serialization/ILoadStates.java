package fr.iut63.a2ddicegameupdate.models.serialization;

import fr.iut63.a2ddicegameupdate.activity.ScoresActivity;

public interface ILoadStates {

    ScoreRankSerializable load(ScoresActivity context);
}
