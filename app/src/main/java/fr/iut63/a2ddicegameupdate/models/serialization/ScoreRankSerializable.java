package fr.iut63.a2ddicegameupdate.models.serialization;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ScoreRankSerializable implements Serializable {

    private final List<ResultSerializable> rank = new ArrayList<>();

    public List<ResultSerializable> getRank(){
        return rank;
    }

    public void addResult(ResultSerializable result){
        rank.add(result);
    }
}
