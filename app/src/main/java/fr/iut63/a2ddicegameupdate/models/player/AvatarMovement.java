package fr.iut63.a2ddicegameupdate.models.player;


import android.util.Log;
import android.widget.ImageView;
import java.util.ArrayList;

import fr.iut63.a2ddicegameupdate.activity.Play;
import fr.iut63.a2ddicegameupdate.models.Case;
import fr.iut63.a2ddicegameupdate.models.loop.Loop;
import fr.iut63.a2ddicegameupdate.models.map.Map;
import fr.iut63.a2ddicegameupdate.models.map.MapGeneration;

/**
 * Classe de déplacement du personnage
 */
public class AvatarMovement {
    private Case actualCase;
    private Case oldCase;
    private Play play;
    private Boolean isEnd = false;
    private Loop loop;

    /**
     * Constructeur de la classe avatarMovement
     * @param imgPerso ImageView du personnage
     * @param map Map sur laquelle bouge le personnage
     * @param loop Loop de jeu observable
     * @param play Activité du jeu.
     */
    public void avatarMovement(ImageView imgPerso, MapGeneration map, Loop loop, Play play){
        this.play = play;
        this.loop = loop;
        ArrayList<Case> listeCase = map.getPlayerMap();
        Map mapCase = map.getMapTile();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int random = (int) ((Math.random() * 6)+1);
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
                        int xMovement = x * map.getTileLengthX();
                        int yMovement = y * map.getTileLengthY();
                        imgPerso.setX(xMovement);
                        imgPerso.setY(yMovement);
                        if(actualCase.isEnd()){
                            //isEnd = true;
                            loop.setRunning(false);
                            break;
                        }
                    }
                    try {
                        Thread.sleep(100);

                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(isEnd){
                        break;
                    }
                }
            }
        } );
        thread.start();

    }

}
