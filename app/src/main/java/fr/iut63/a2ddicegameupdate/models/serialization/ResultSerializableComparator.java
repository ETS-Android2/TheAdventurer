package fr.iut63.a2ddicegameupdate.models.serialization;

import java.util.Comparator;

public class ResultSerializableComparator implements Comparator<ResultSerializable> {
    public int compare(ResultSerializable a, ResultSerializable b)
    {
        return a.getScore() - b.getScore();
    }
}
