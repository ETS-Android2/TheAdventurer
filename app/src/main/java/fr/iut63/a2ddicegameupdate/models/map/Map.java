package fr.iut63.a2ddicegameupdate.models.map;

import java.util.ArrayList;

import fr.iut63.a2ddicegameupdate.models.Case;


public class Map {
    private final int sizeTile;
    private int coordStartX;
    private int coordStartY;
    private final ArrayList<Case> map;
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
        this.sizeTile = 32;
    }


    /**
     * Method to get the size of the tile
     * @return sizeTile
     */
    public int getSizeTile() {
        return this.sizeTile;
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

    public void setMapTile(int xCord , int yCord , int updatedValue){
        this.mapFirstLayout[yCord][xCord] = updatedValue;
    }

    public boolean isCaseEmpty(int xCord , int yCord){
        return mapFirstLayout[yCord][xCord] == 0;
    }
}