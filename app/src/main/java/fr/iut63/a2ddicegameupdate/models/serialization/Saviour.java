package fr.iut63.a2ddicegameupdate.models.serialization;

import java.io.FileOutputStream;
import java.io.Serializable;

public interface Saviour {

    void save(FileOutputStream fichier, Serializable toSave);

}