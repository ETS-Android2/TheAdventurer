package fr.iut63.a2ddicegameupdate.models.serialization;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class FileLoader implements Loader {



    @Nullable
    @Override
    public Serializable load(@NonNull InputStream fichier) {
        Serializable retour = null;
        try (ObjectInputStream ois = new ObjectInputStream(fichier)) {
            retour  = (Serializable) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return retour;
    }
}