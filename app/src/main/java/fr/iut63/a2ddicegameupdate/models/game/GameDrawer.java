package fr.iut63.a2ddicegameupdate.models.game;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import fr.iut63.a2ddicegameupdate.activity.Play;
import fr.iut63.a2ddicegameupdate.models.map.Map;

/**
 * Classe génératrice de la map et du personnage au lancement du jeu.
 */
public class GameDrawer {

    private final Map map;
    private final int mapH;
    private final int mapW;
    private int difficulty;

    private final Play activityGame;
    private final List<Bitmap> tiles;
    private final List<Bitmap> avatar;

    /**
     * Constructeur de la classe GameDrawer (Classe de dessin de la map et du personnage)
     * @param context Contexte de l'application lors de la génération de la map
     * @param mapTile Map généré lors du lancement du jeu passé en paramètre pour dessiner la grid d'images
     */
    public GameDrawer(Play context, Map mapTile) {
        activityGame = context;
        map = mapTile;

        int screenWidth = map.getResolutionWidth();
        int screenHeight = map.getResolutionHeight();

        mapH = map.getMapFirstLayout().length;
        mapW = map.getMapFirstLayout()[0].length;

        map.setTileLengthX(screenWidth / mapW+2);
        map.setTileLengthY(screenHeight / mapH);

        this.tiles = loadTileSet();
        this.avatar = loadAvatarSet();
    }

    /**
     * Méthode loader du tileset.
     * @return Retourne la liste des bitmaps avec toutes les tiles.
     */
    private List<Bitmap> loadTileSet() {
        ArrayList<Bitmap> tiles = new ArrayList<>();

        try {
            /*for (String path : activityGame.getAssets().list("tiles/")) {
                Log.d("PATH", path);
                InputStream tileIS = activityGame.getAssets().open("tiles/"+path);
                Bitmap bitmap = BitmapFactory.decodeStream(tileIS);
                tiles.add(Bitmap.createScaledBitmap(bitmap, map.getTileLengthX(), map.getTileLengthY(), true));
            }*/
            for(int i = 0; i < 2017; i++){
                InputStream tileIS = activityGame.getAssets().open("tiles/"+i+".png");
                Bitmap bitmap = BitmapFactory.decodeStream(tileIS);
                tiles.add(Bitmap.createScaledBitmap(bitmap, map.getTileLengthX(), map.getTileLengthY(), true));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return tiles;
    }

    /**
     * Méthode loader du tileset du personnage.
     * @return Retourne la liste des bitmaps avec toutes les tiles du personnage.
     */
    private List<Bitmap> loadAvatarSet(){
        ArrayList<Bitmap> avavar = new ArrayList<>();

        try {
            for (String path : activityGame.getAssets().list("avatar/")) {
                InputStream tileIS = activityGame.getAssets().open("avatar/"+path);
                Bitmap bitmap = BitmapFactory.decodeStream(tileIS);
                avavar.add(Bitmap.createScaledBitmap(bitmap, map.getTileLengthX(), map.getTileLengthY(), true));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return avavar;
    }

    /**
     * Drawer de la map en fonction de la difficulté
     * @param difficulty difficulté choisi par le joueur.
     */
    public void drawMap(int difficulty) {
        this.difficulty = difficulty;
        for (int i = 0; i < mapH; i++) {
            for (int j = 0; j < mapW; j++) {

                ImageView tileIMG = new ImageView(activityGame);

                switch (difficulty) {
                    case 1:
                        tileIMG.setImageBitmap(tiles.get(map.getMapFirstLayout()[i][j]));
                        break;
                    case 2:
                        tileIMG.setImageBitmap(tiles.get(map.getMapSecondLayout()[i][j]));
                        break;
                    case 3:
                        tileIMG.setImageBitmap(tiles.get(map.getMapThirdLayout()[i][j]));
                        break;

                }
                tileIMG.setX(j * map.getTileLengthX());
                tileIMG.setY(i * map.getTileLengthY());

                activityGame.getConstraintLayout().addView(tileIMG);
            }
        }
        for (int i = 0; i < mapH; i++) {
            for (int j = 0; j < mapW; j++) {

                ImageView tileIMG2 = new ImageView(activityGame);

                switch (difficulty) {
                    case 1:
                        if(map.getMapFirstLayout2()[i][j] != 0){
                            tileIMG2.setImageBitmap(tiles.get(map.getMapFirstLayout2()[i][j]));
                        }
                        break;
                    case 2:
                        if(map.getMapSecondLayout2()[i][j] != 0) {
                            tileIMG2.setImageBitmap(tiles.get(map.getMapSecondLayout2()[i][j]));
                        }
                        break;
                    case 3:
                        if(map.getMapThirdLayout2()[i][j] != 0) {
                            tileIMG2.setImageBitmap(tiles.get(map.getMapThirdLayout2()[i][j]));
                        }
                        break;

                }
                tileIMG2.setX(j * map.getTileLengthX());
                tileIMG2.setY(i * map.getTileLengthY());

                activityGame.getConstraintLayout().addView(tileIMG2);
            }
        }
    }

    /**
     * Drawer du personnage en fonction de l'avatar choisi au début
     * @param avatarInt Avatar choisi au début passé en paramètre
     * @return return l'imageView du personnage pour pouvoir l'animé
     */
    public ImageView drawPlayer(int avatarInt) {
        int yDepart = 24;
        for (int i = 0; i < mapH; i++) {
            for (int j = 0; j < mapW; j++) {
                if(this.difficulty == 3){
                    yDepart = 2;
                }
                if (i == yDepart && j == 0) {
                    ImageView tileIMG = new ImageView(activityGame);
                    avatarInt --;
                    tileIMG.setImageBitmap(avatar.get(avatarInt));
                    tileIMG.setX(j * map.getTileLengthX());
                    tileIMG.setY(i * map.getTileLengthY());

                    activityGame.getConstraintLayout().addView(tileIMG);

                    return tileIMG;
                }
            }
        }
        return null;
    }
}
