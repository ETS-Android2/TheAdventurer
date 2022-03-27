package fr.iut63.a2ddicegameupdate.models.serialization;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Liste des scores à sérializr dans un fichier
 */
public class ScoreRankSerializable implements Serializable {

    private List<ResultSerializable> rank = new ArrayList<>();

    public List<ResultSerializable> getRank(){
        return rank;
    }

    public void setRank(List<ResultSerializable> list){
        this.rank = list;
    }

    public void addResult(ResultSerializable result){
        rank.add(result);
    }
}
