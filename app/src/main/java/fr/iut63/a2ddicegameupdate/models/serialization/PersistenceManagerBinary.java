package fr.iut63.a2ddicegameupdate.models.serialization;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Inet4Address;

import fr.iut63.a2ddicegameupdate.activity.MainActivity;
import fr.iut63.a2ddicegameupdate.activity.ScoresActivity;


public class PersistenceManagerBinary extends PersistenceManager {

    private static final File fileSerialization = new File(System.getProperty("user.dir") + "/code/ressources/serialization/saveScores.ser");

    @Override
    public void save(ScoreRankSerializable scoreRanking, Activity context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("config.txt", Context.MODE_PRIVATE));
            for(ResultSerializable re : scoreRanking.getRank()){
                outputStreamWriter.write(re.getPseudo() + " " + re.getLevel() + " " + re.getScore() + " " + re.getTime() +  "\n");
            }
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    @Override
    public ScoreRankSerializable load(Activity context) {

        String ret = "";
        ScoreRankSerializable scoreList = new ScoreRankSerializable();

        try {
            InputStream inputStream = context.openFileInput("config.txt");
            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ((receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                    String[] list = receiveString.split(" ");
                    int score = Integer.parseInt(list[1]);
                    int level = Integer.parseInt(list[2]);
                    int timer = Integer.parseInt(list[3]);
                    ResultSerializable result  = new ResultSerializable(list[0], score, level, timer);
                    scoreList.addResult(result);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        if(scoreList.getRank() == null){
            Stub stub = new Stub();
            scoreList = stub.load(context);
        }


        return scoreList;
    }

}
