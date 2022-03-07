package fr.iut63.a2ddicegameupdate.models.map;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import fr.iut63.a2ddicegameupdate.activity.Play;

public class DrawMap {

    private Map map;
    private final int mapH;
    private final int mapW;

    private final Play activityGame;
    private final List<Bitmap> tiles;

    public DrawMap(Play context, Map mapTile) {
        activityGame = context;
        map = mapTile;

        int screenWidth = map.getResolutionWidth();
        int screenHeight = map.getResolutionHeight();

        mapH = map.getMap().length;
        mapW = map.getMap()[0].length;

        map.setTileLengthX(screenWidth / mapW);
        map.setTileLengthY(screenHeight / mapH);

        this.tiles = loadTileSet();
    }

    private List<Bitmap> loadTileSet() {
        ArrayList<Bitmap> tiles = new ArrayList<>();

        try {
            for (String path : activityGame.getAssets().list("tiles/")) {
                InputStream tileIS = activityGame.getAssets().open("tiles/"+path);
                Bitmap bitmap = BitmapFactory.decodeStream(tileIS);
                tiles.add(Bitmap.createScaledBitmap(bitmap, map.getTileLengthX(), map.getTileLengthY(), true));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tiles;
    }

    public void drawMap() {
        for (int i = 0; i < mapH; i++) {
            for (int j = 0; j < mapW; j++) {
                ImageView tileIMG = new ImageView(activityGame);
                tileIMG.setImageBitmap(tiles.get(map.getMap()[i][j]));

                tileIMG.setX(j * map.getTileLengthX());
                tileIMG.setY(i * map.getTileLengthY());

                activityGame.getConstraintLayout().addView(tileIMG);
            }
        }
    }

}
