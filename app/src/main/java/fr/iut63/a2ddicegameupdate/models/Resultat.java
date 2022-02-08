package fr.iut63.a2ddicegameupdate.models;

import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Clock;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Resultat {
    /**
     * Method to save the score in the txt file
     * @param resultat Result to save
     * @param lvl Level
     */
    public void sauvegarderResultat(int resultat, int lvl) {
        try {
            LocalDate today = LocalDate.now();
            FileWriter fw = new FileWriter("test.txt",true);
            fw.write(resultat + " " + lvl + " " + today.format(DateTimeFormatter.ofPattern("dd-MM-yy")) + "\n");
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to load the score in the txt file
     */
    public ListeScore chargerResultat(){
        ListeScore ls = new ListeScore();
        try
        {
            File file = new File("test.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            StringBuffer sb = new StringBuffer();
            String line;
            String separateur = " ";
            String[] tab;
            int level;
            int resultat;
            String date;
            while((line = br.readLine()) != null)
            {
                tab = line.split(separateur);
                level = Integer.parseInt(tab[1]);
                resultat = Integer.parseInt(tab[0]);
                date = tab[2];
                Score sc = new Score(resultat, level, date);
                ls.addScore(sc);
                Log.i("SCORE", "23");
            }
            fr.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return ls;
    }

}

