package fr.iut63.a2ddicegameupdate.models;

import java.util.ArrayList;

public class Map {
    private final int sizeTile;
    private final int sizeMap;
    private final ArrayList<GameTile> map;
    private int coordStartX;
    private int coordStartY;

    /**
     * Constructor of the Map class
     * @param sizeTile Taille en pixel d'une case
     * @param sizeMap Taille en largeur d'une map (nombre de cases)
     */
    public Map(int sizeTile, int sizeMap) {
        this.sizeTile = sizeTile;
        this.sizeMap = sizeMap;
        this.map = new ArrayList<GameTile>();
        this.coordStartX = getCoordStartX();
        this.coordStartY = getCoordStartY();
    }

    /**
     * Method to add a case to the map
     * @param c case to add
     */
    public void addCase(GameTile c) {
        this.map.add(c);
        if(c.isMalus()){
            setCoordStartX(c.getCoordX());
            setCoordStartY(c.getCoordY());
        }
    }

    /**
     * Method to remove a case from the map
     * @param c Caseto remove
     */
    public void removeCase(GameTile c) {
        this.map.remove(c);
    }

    /**
     * Method to get the map
     * @return map
     */
    public ArrayList<GameTile> getMap() {
        return this.map;
    }

    /**
     * Method to get the size of the tile
     * @return sizeTile
     */
    public int getSizeTile() {
        return this.sizeTile;
    }

    /**
     * Method to get the size of the map
     * @return sizeMap
     */
    public int getSizeMap() {
        return this.sizeMap;
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

    /**
     * Method to get the next case of the map
     * @param c case given
     * @return next Case
     */
    public GameTile getNextCase(GameTile c){
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
     * Method to get the start case of the map
     * @return starting case getter
     */
    public GameTile getStartCase(){
        for(GameTile c : this.map){
            if(c.isStart()){
                System.out.println(c);
                return c;
            }
        }
        return null;
    }

}
