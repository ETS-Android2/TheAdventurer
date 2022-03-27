package fr.iut63.a2ddicegameupdate.models.serialization;

import android.app.Activity;

/**
 * Interface du loader
 */
public interface ILoadStates {

    ScoreRankSerializable load(Activity context);
}
