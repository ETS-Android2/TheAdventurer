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

    public void avatarMovement(ImageView imgPerso, MapGeneration map, Play activityGame, List<Bitmap> avatar){
        System.out.println("Avatar mouvement");
        listeCase = map.getPlayerMap();
        if(listeCase == null){
            System.out.println("listecase is null");
        }else{
            System.out.println("listecase is not null");
        }
        Log.d("TAILLE", " : " + listeCase.toArray().length);
        for(Case i : listeCase){
            Log.d("MAP", "Coord : " + i.getCoordX() + i.getCoordY());
        }
        if(actualCase == null){
            System.out.println("actualCase null");
            actualCase = listeCase.get(0);
        }
        Map mapCase = map.getMapTile();
        oldCase = actualCase;
        actualCase = mapCase.getNextCase(oldCase);

        if(actualCase == null){
            System.out.println("Case actuelle vide");
        }else{
            System.out.println("Case OK");
        }
        System.out.println(actualCase);

        if(actualCase != null){

            Log.d("OldCase", oldCase.getCoordX()+" "+ oldCase.getCoordY());
            Log.d("actualCase", actualCase.getCoordX()+" "+ actualCase.getCoordY());

            int x = actualCase.getCoordX();
            int y = actualCase.getCoordY();
            System.out.println("x "+x);
            System.out.println("y "+y);
            imgPerso.setX(x * map.getSizeTile());
            imgPerso.setY(y * map.getSizeTile());
        }else{
            System.out.println("Fin du jeu");
        }

    }
}
