package fr.iut63.a2ddicegameupdate.models;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import fr.iut63.a2ddicegameupdate.activity.Play;
import fr.iut63.a2ddicegameupdate.models.map.Map;

public class GameDrawer {

    private final Map map;
    private final int mapH;
    private final int mapW;

    private final Play activityGame;
    private final List<Bitmap> tiles;
    private final List<Bitmap> avatar;

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

    private List<Bitmap> loadTileSet() {
        ArrayList<Bitmap> tiles = new ArrayList<>();

        try {
            for (String path : activityGame.getAssets().list("tiles/")) {
                Log.d("PATH", path);
                InputStream tileIS = activityGame.getAssets().open("tiles/"+path);
                Bitmap bitmap = BitmapFactory.decodeStream(tileIS);
                tiles.add(Bitmap.createScaledBitmap(bitmap, map.getTileLengthX(), map.getTileLengthY(), true));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tiles;
    }

    private List<Bitmap> loadAvatarSet(){
        ArrayList<Bitmap> avavar = new ArrayList<>();

        try {
            for (String path : activityGame.getAssets().list("avatar/")) {
                Log.d("PATH", path);
                InputStream tileIS = activityGame.getAssets().open("avatar/"+path);
                Bitmap bitmap = BitmapFactory.decodeStream(tileIS);
                avavar.add(Bitmap.createScaledBitmap(bitmap, map.getTileLengthX(), map.getTileLengthY(), true));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return avavar;
    }

    public void drawMap() {
        for (int i = 0; i < mapH; i++) {
            for (int j = 0; j < mapW; j++) {

                ImageView tileIMG = new ImageView(activityGame);

                tileIMG.setImageBitmap(tiles.get(map.getMapFirstLayout()[i][j]));
                tileIMG.setX(j * map.getTileLengthX());
                tileIMG.setY(i * map.getTileLengthY());

                activityGame.getConstraintLayout().addView(tileIMG);
            }
        }
    }

    public ImageView drawPlayer() {
        for (int i = 0; i < mapH; i++) {
            for (int j = 0; j < mapW; j++) {
                if (i == 24 && j == 0) {
                    ImageView tileIMG = new ImageView(activityGame);

                    tileIMG.setImageBitmap(avatar.get(4));
                    tileIMG.setX(j * map.getTileLengthX());
                    tileIMG.setY(i * map.getTileLengthY());

                    activityGame.getConstraintLayout().addView(tileIMG);
                    return tileIMG;
                }
            }
        }
        return null;
    }
    public List<Bitmap> getAvatar(){
        return avatar;
    }

}
