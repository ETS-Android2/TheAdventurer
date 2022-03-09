package fr.iut63.a2ddicegameupdate.models.player;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import fr.iut63.a2ddicegameupdate.activity.Play;
import fr.iut63.a2ddicegameupdate.models.Case;
import fr.iut63.a2ddicegameupdate.models.map.Map;

public class AvatarMovement {
    private ArrayList<Case> listeCase;
    private Case actualCase;
    private Case oldCase;

    public void avatarMovement(ImageView imgPerso, Map map, Play activityGame, List<Bitmap> avatar){
        System.out.println("Avatar mouvement");
//        listeCase = map.getMap();

        oldCase = actualCase;
        actualCase = map.getNextCase(oldCase);
        if(actualCase == null){
            System.out.print("Case actuelle vide");
        }else{
            System.out.print("Case OK");
        }
        System.out.print(actualCase);

//        int x = actualCase.getCoordX();
//        int y = actualCase.getCoordY();
//        imgPerso.setX(x * map.getTileLengthX());
//        imgPerso.setY(y * map.getTileLengthY());

    }
}
