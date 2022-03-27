package fr.iut63.a2ddicegameupdate.models.serialization;

import android.app.Activity;

import fr.iut63.a2ddicegameupdate.activity.ScoresActivity;

public interface ISaveStates {
    void save(ScoreRankSerializable scoreRank, Activity context);
}
