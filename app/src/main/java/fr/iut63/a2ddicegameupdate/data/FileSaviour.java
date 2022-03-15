package fr.iut63.a2ddicegameupdate.data;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import fr.iut63.a2ddicegameupdate.models.Resultat;

public class FileSaviour implements Saviour {

    @Override
    public void save(FileOutputStream fichier, Serializable toSave) {

        String filename = "text.txt";
        Resultat m = new Resultat(11, 1, "12/07/2022");

        // save the object to file
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(m);

            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // read the object from file
        // save the object to file
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);
            m = (Resultat) in.readObject();
            in.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(m);
    }
}