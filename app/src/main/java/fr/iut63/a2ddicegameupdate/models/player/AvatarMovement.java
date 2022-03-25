package fr.iut63.a2ddicegameupdate.models.player;


import android.util.Log;
import android.widget.ImageView;
import java.util.ArrayList;

import fr.iut63.a2ddicegameupdate.activity.Play;
import fr.iut63.a2ddicegameupdate.models.Case;
import fr.iut63.a2ddicegameupdate.models.Loop;
import fr.iut63.a2ddicegameupdate.models.map.Map;
import fr.iut63.a2ddicegameupdate.models.map.MapGeneration;

public class AvatarMovement {
    private Case actualCase;
    private Case oldCase;

    public void avatarMovement(ImageView imgPerso, MapGeneration map, Loop loop, Play play){
        ArrayList<Case> listeCase = map.getPlayerMap();
        Map mapCase = map.getMapTile();

        //tirer un nombre aléatoire entre 0 et 6
        int random = (int) (Math.random() * 6);
        Log.d("random", String.valueOf(random));
        for (int i = 0; i<random; i++){
            if(actualCase == null && oldCase == null){
                actualCase = listeCase.get(0);
                oldCase = listeCase.get(0);
            }else {
                oldCase = actualCase;
                actualCase = mapCase.getNextCase(oldCase);
            }

            if(actualCase != null){
                int x = actualCase.getCoordX();
                int y = actualCase.getCoordY();
                int xMovement = x * 58;
                int yMovement = y * 53;
                imgPerso.setX(xMovement);
                imgPerso.setY(yMovement);
                if(actualCase.isEnd()){
                    Log.d("End", "End");
                    //gameTime.setEndGame(true);
                    //gameTime.stop();
                    loop.setRunning(false);
                    play.endGame();
                }
            }
        }

    }
}
