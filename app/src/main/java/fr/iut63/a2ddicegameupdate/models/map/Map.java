package fr.iut63.a2ddicegameupdate.models.map;

import java.util.ArrayList;

import fr.iut63.a2ddicegameupdate.models.Case;

/**
 * Classe contenant toutes les informations d'une map généré dans le jeu.
 */
public class Map {
    private final int sizeTileWidth;
    private final int sizeTileHeight;
    private int coordStartX;
    private int coordStartY;
    private ArrayList<Case> map;
    private final int resolutionWidth;
    private final int resolutionHeight;
    private int tileLengthX;
    private int tileLengthY;
    private final int offsetX;
    private final int offsetY;
    private int[][] mapFirstLayout;
    private int[][] mapSecondLayout;
    private int[][] mapThirdLayout;
    private int[][] mapFirstLayout2;
    private int[][] mapSecondLayout2;
    private int[][] mapThirdLayout2;

    /**
     * Constructeur de la classe map
     * @param mapWidth largeur de la map
     * @param mapHeight heuteur de la map
     */
    public Map(int mapWidth , int mapHeight) {

        resolutionWidth = mapWidth;
        resolutionHeight = mapHeight;
        this.map = new ArrayList<>();

        offsetX = tileLengthX * 64 - resolutionWidth;
        offsetY = tileLengthY * 64 - resolutionHeight;

        boolean offsetXFlag = offsetX != 0;

        boolean offsetYFlag = offsetY != 0;

        this.sizeTileWidth = resolutionWidth / 42;
        this.sizeTileHeight = resolutionHeight / 42;
    }


    /**
     * Method to get the size of the tile
     * @return sizeTile
     */
    public int getSizeTileWidth() {
        return this.sizeTileWidth;
    }

    public int getSizeTileHeight() {
        return sizeTileHeight;
    }

    /**
     * Method to add a case to the map
     * @param c
    */
    public void addCase(Case c) {
        this.map.add(c);
        if(c.getIsStart()){
            setCoordStartX(c.getCoordX());
            setCoordStartY(c.getCoordY());
        }
    }

    /**
     * Method to get the map
     * @return map
     */
    public ArrayList<Case> getMap() {
        return this.map;
    }

    public Case getNextCase(Case c){
        int i,j;
        for(i = 0; i < this.map.size(); i++){
            if(c == this.map.get(i)){
                j=i+1;
                try {
                    return this.map.get(j);
                }catch (IndexOutOfBoundsException e){
                    return null;
                }

            }
        }
        return c;
    }

    /**
     * Method to set the X coordonate of the start case
     * @param x x coordinate setter for the starting case
     */
    public void setCoordStartX(int x){
        this.coordStartX = x;
    }

    /**
     * Method to set the Y coordonate of the start case
     * @param y y coordinate setter for the starting case
     */
    public void setCoordStartY(int y){
        this.coordStartY = y;
    }

    /**
     * Getter de la résolution en largeur de l'écran
     * @return resolutionWidth
     */
    public int getResolutionWidth() {
        return resolutionWidth;
    }

    /**
     * Getter de la résolution en hauteur de l'écran
     * @return resolutionHeight
     */
    public int getResolutionHeight() {
        return resolutionHeight;
    }

    /**
     * Getter de la largeur du Tile (X)
     * @return tileLengthX
     */
    public int getTileLengthX() {
        return tileLengthX;
    }

    /**
     * Getter de la hauteur du Tile (Y)
     * @return tileLengthY
     */
    public int getTileLengthY() {
        return tileLengthY;
    }

    /**
     * Setter de la largeur du Tile (X)
     * @param x
     */
    public void setTileLengthX(int x){ this.tileLengthX = x;}

    /**
     * Setter de la hauteur du Tile (Y)
     * @param y
     */
    public void setTileLengthY(int y){ this.tileLengthY = y;}

    /**
     * Getter de la première couche de la map (tiles de sol sans colision)
     * @return mapFirstLayout
     */
    public int[][] getMapFirstLayout() {
        return mapFirstLayout;
    }

    /**
     * Setter de la première couche de la map (tiles de sol sans colision)
     * @param mapFirstLayout
     */
    public void setMapFirstLayout(int[][] mapFirstLayout) {
        this.mapFirstLayout = mapFirstLayout;
    }

    /**
     * Getter de la deuxième couche de la map (tiles de sol avec colision)
     * @return mapSecondLayout
     */
    public int[][] getMapSecondLayout() {
        return mapSecondLayout;
    }

    /**
     * Setter de la deuxième couche de la map (tiles de sol sans colision)
     * @param mapSecondLayout
     */
    public void setMapSecondLayout(int[][] mapSecondLayout) {
        this.mapSecondLayout = mapSecondLayout;
    }

    /**
     * Getter de la troisième couche de la map (tiles de décors)
     * @return mapThirdLayout
     */
    public int[][] getMapThirdLayout() {
        return mapThirdLayout;
    }

    /**
     * Setter de la troisième couche de la map (tiles de sol sans colision)
     * @param mapThirdLayout
     */
    public void setMapThirdLayout(int[][] mapThirdLayout) {
        this.mapThirdLayout = mapThirdLayout ;
    }

    /**
     * Getter de la première couche de niveau 2
     * @return mapFirstLayout2
     */
    public int[][] getMapFirstLayout2() {
        return mapFirstLayout2;
    }

    /**
     * Setter de la première couche de niveau 2
     * @param mapFirstLayout2
     */
    public void setMapFirstLayout2(int[][] mapFirstLayout2) {
        this.mapFirstLayout2 = mapFirstLayout2;
    }

    /**
     * Getter de la deuxième couche de niveau 2
     * @return mapSecondLayout2
     */
    public int[][] getMapSecondLayout2() {
        return mapSecondLayout2;
    }

    /**
     * Setter de la deuxième couche de niveau 2
     * @param mapSecondLayout2
     */
    public void setMapSecondLayout2(int[][] mapSecondLayout2) {
        this.mapSecondLayout2 = mapSecondLayout2;
    }

    /**
     * Getter de la troisème couche de niveau 2
     * @return mapThirdLayout2
     */
    public int[][] getMapThirdLayout2() {
        return mapThirdLayout2;
    }

    /**
     * Setter de la troisième couche de niveau 2
     * @param mapThirdLayout2
     */
    public void setMapThirdLayout2(int[][] mapThirdLayout2) {
        this.mapThirdLayout2 = mapThirdLayout2;
    }
}