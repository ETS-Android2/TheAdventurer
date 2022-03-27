package fr.iut63.a2ddicegameupdate.models;


import fr.iut63.a2ddicegameupdate.models.map.Map;

public class Case {
    private int idCase;
    private int coordX;
    private int coordY;
    private boolean isStart;
    private boolean isEnd;
    private boolean isMalus;
    private boolean isBonus;
    private int sizeTileWidth, sizeTileHeight;

    /**
     * Constructor of the Case class
     * @param idCase
     * @param coordX
     * @param coordY
     * @param isStart
     * @param isBonus
     * @param isMalus
     * @param isEnd
     * @param map
     */
    public Case(int idCase, int coordX, int coordY, boolean isStart, boolean isBonus, boolean isMalus, boolean isEnd, Map map) {
        this.sizeTileWidth = map.getSizeTileWidth();
        this.sizeTileHeight = map.getSizeTileHeight();
        this.idCase = idCase;
        this.coordX = coordX;
        this.coordY = coordY;
        this.isStart = isStart;
        this.isBonus = isBonus;
        this.isMalus = isMalus;
        this.isEnd = isEnd;
    }

    /**
     *Method to get the id of the case
     * @return idCase
     */
    public int getIdCase() {
        return idCase;
    }

    /**
     * Method to set the X coordinate of the case
     * @return coordX
     */
    public int getCoordX() {
        return coordX;
    }

    /**
     * Method to set the Y coordinate of the case
     * @return coordY
     */
    public int getCoordY() {
        return coordY;
    }

    /**
     * Method to verify if the case is a start
     * @return isStart
     */
    public boolean getIsStart() {
        return isStart;
    }

    /**
     * Method to verify if the case is an end
     * @return isEnd
     */
    public boolean isEnd() {
        return isEnd;
    }

    /**
     * Method to verify if the case is a bonus
     * @return isBonus
     */
    public boolean isBonus() {
        return isBonus;
    }

    /**
     * Method to verify if the case is a malus
     * @return isMalus
     */
    public boolean isMalus() {
        return isMalus;
    }

    /**
     * Method to set the ID of the case
     * @param idCase
     */
    public void setIdCase(int idCase) {
        this.idCase = idCase;
    }

    /**
     * Method to set the X coordinate of the case
     * @param coordX
     */
    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    /**
     * Method to set the Y coordinate of the case
     * @param coordY
     */
    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    /**
     * Method to set if the case is a start
     * @param start
     */
    public void setStart(boolean start) {
        isStart = start;
    }

    /**
     * Method to set if the case is an end
     * @param end
     */
    public void setEnd(boolean end) {
        isEnd = end;
    }

    public int getSizeTileWidth(){
        return this.sizeTileWidth;
    }
    public int getSizeTileHeight() { return this.sizeTileHeight; }
}
