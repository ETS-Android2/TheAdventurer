package fr.iut63.a2ddicegameupdate.data;

import java.io.FileInputStream;

public interface Loader {

    Object load(FileInputStream fichier);

}