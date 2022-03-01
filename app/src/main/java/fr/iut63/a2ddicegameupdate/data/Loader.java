package fr.iut63.a2ddicegameupdate.data;

import java.io.FileInputStream;
import java.io.InputStream;

public interface Loader {

    Object load(InputStream fichier);

}