package fr.iut63.a2ddicegameupdate.models.map;

import java.util.ArrayList;

import fr.iut63.a2ddicegameupdate.models.Case;


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
    private final boolean offsetXFlag;
    private final boolean offsetYFlag;
    private int[][] mapFirstLayout;
    private int[][] mapSecondLayout;
    private int[][] mapThirdLayout;
    private int[][] mapFirstLayout2;
    private int[][] mapSecondLayout2;
    private int[][] mapThirdLayout2;

    /**
     * Constructor of the Map class
     */
    public Map(int mapWidth , int mapHeight) {

        resolutionWidth = mapWidth;
        resolutionHeight = mapHeight;
        this.map = new ArrayList<>();

        offsetX = tileLengthX * 64 - resolutionWidth;
        offsetY = tileLengthY * 64 - resolutionHeight;

        offsetXFlag = offsetX != 0;

        offsetYFlag = offsetY != 0;

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
     * Method to get the X coordonate of the start case
     * @return coordStartX
     */
    public int getCoordStartX(){
        return coordStartX;
    }

    /**
     * Method to set the X coordonate of the start case
     * @param x x coordinate setter for the starting case
     */
    public void setCoordStartX(int x){
        this.coordStartX = x;
    }

    /**
     * Method to get the Y coordonate of the start case
     * @return coordStartY
     */
    public int getCoordStartY(){
        return coordStartY;
    }

    /**
     * Method to set the Y coordonate of the start case
     * @param y y coordinate setter for the starting case
     */
    public void setCoordStartY(int y){
        this.coordStartY = y;
    }

    public int getResolutionWidth() {
        return resolutionWidth;
    }

    public int getResolutionHeight() {
        return resolutionHeight;
    }

    public int getTileLengthX() {
        return tileLengthX;
    }

    public int getTileLengthY() {
        return tileLengthY;
    }

    public void setTileLengthX(int x){ this.tileLengthX = x;}

    public void setTileLengthY(int y){ this.tileLengthY = y;}

    public int getOffsetY() {
        return offsetY;
    }

    public int getOffsetX() {
        return offsetX;
    }

    public boolean isOffsetYFlag() {
        return offsetYFlag;
    }

    public boolean isOffsetXFlag() {
        return offsetXFlag;
    }


    public int[][] getMapFirstLayout() {
        return mapFirstLayout;
    }

    public void setMapFirstLayout(int[][] mapFirstLayout) {
        this.mapFirstLayout = mapFirstLayout;
    }

    public int[][] getMapSecondLayout() {
        return mapSecondLayout;
    }

    public void setMapSecondLayout(int[][] mapSecondLayout) {
        this.mapSecondLayout = mapSecondLayout;
    }

    public int[][] getMapThirdLayout() {
        return mapThirdLayout;
    }

    public void setMapThirdLayout(int[][] mapThirdLayout) {
        this.mapThirdLayout = mapThirdLayout;
    }

    public int[][] getMapFirstLayout2() {
        return mapFirstLayout2;
    }

    public void setMapFirstLayout2(int[][] mapFirstLayout2) {
        this.mapFirstLayout2 = mapFirstLayout2;
    }

    public int[][] getMapSecondLayout2() {
        return mapSecondLayout2;
    }

    public void setMapSecondLayout2(int[][] mapSecondLayout2) {
        this.mapSecondLayout2 = mapSecondLayout2;
    }

    public int[][] getMapThirdLayout2() {
        return mapThirdLayout2;
    }

    public void setMapThirdLayout2(int[][] mapThirdLayout2) {
        this.mapThirdLayout2 = mapThirdLayout2;
    }



    public void setMapTile(int xCord , int yCord , int updatedValue){
        this.mapFirstLayout[yCord][xCord] = updatedValue;
    }

    public boolean isCaseEmpty(int xCord , int yCord){
        return mapFirstLayout[yCord][xCord] == 0;
    }
}