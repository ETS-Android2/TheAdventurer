package fr.iut63.a2ddicegameupdate.models.player;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import fr.iut63.a2ddicegameupdate.activity.Play;
import fr.iut63.a2ddicegameupdate.models.Case;
import fr.iut63.a2ddicegameupdate.models.map.Map;
import fr.iut63.a2ddicegameupdate.models.map.MapGeneration;

public class AvatarMovement {
    private ArrayList<Case> listeCase;
    private Case actualCase;
    private Case oldCase;
    private int nbCase;

    public void avatarMovement(ImageView imgPerso, MapGeneration map, Play activityGame, List<Bitmap> avatar){
        listeCase = map.getPlayerMap();
        if(listeCase == null){
            Log.d("listecase", "is null");
        }else{
            Log.d("TAILLE", " : " + listeCase.toArray().length);
            for(Case i : listeCase){
                Log.d("MAP", "Coord : " + i.getCoordX() + " " + i.getCoordY());
            }
        }
        Map mapCase = map.getMapTile();
        if(actualCase == null && oldCase == null){
            System.out.println("actualCase null");
            actualCase = listeCase.get(0);
            oldCase = listeCase.get(0);
            nbCase = 0;
        }else {
            oldCase = actualCase;
            actualCase = mapCase.getNextCase(oldCase);
        }
        System.out.println(actualCase);

        if(actualCase != null){
            Log.d("OldCase", oldCase.getCoordX()+" "+ oldCase.getCoordY());
            Log.d("actualCase", actualCase.getCoordX()+" "+ actualCase.getCoordY());

            int x = actualCase.getCoordX();
            int y = actualCase.getCoordY();
            System.out.println("x "+x);
            System.out.println("y "+y);
            int xMovement = x * map.getSizeTile();
            int yMovement = y * map.getSizeTile();
            System.out.println(xMovement);
            System.out.println(yMovement);
            imgPerso.setX(xMovement);
            imgPerso.setY(yMovement);
        }else{
            System.out.println("Fin du jeu");
        }

    }
}
