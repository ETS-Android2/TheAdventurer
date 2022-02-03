package fr.iut63.a2ddicegameupdate.models;

public class Case {
    int idCase;
    int coordX;
    int coordY;
    boolean isStart;
    boolean isEnd;
    boolean isMalus;
    boolean isBonus;
    int sizeTile;

    /**
     * Constructor of the Case class
     *
     * @param idCase  ID de la case
     * @param coordX  Coordonnée X
     * @param coordY  Coordonnée Y
     * @param isStart Est elle la case de départ
     * @param isBonus Est elle une case bonus
     * @param isMalus Est elle une case malus
     * @param isEnd   Est elle la case de fin
     */
    public Case(int idCase, int coordX, int coordY, boolean isStart, boolean isBonus, boolean isMalus, boolean isEnd) {
        this.idCase = idCase;
        this.coordX = coordX;
        this.coordY = coordY;
        this.isStart = isStart;
        this.isBonus = isBonus;
        this.isMalus = isMalus;
        this.isEnd = isEnd;
    }

    /**
     * Method to get the id of the case
     *
     * @return idCase
     */
    public int getIdCase() {
        return idCase;
    }

    /**
     * Method to set the X coordinate of the case
     *
     * @return coordX
     */
    public int getCoordX() {
        return coordX;
    }

    /**
     * Method to set the Y coordinate of the case
     *
     * @return coordY
     */
    public int getCoordY() {
        return coordY;
    }

    /**
     * Method to verify if the case is a start
     *
     * @return isStart
     */
    public boolean isStart() {
        return isStart;
    }

    /**
     * Method to verify if the case is an end
     *
     * @return isEnd
     */
    public boolean isEnd() {
        return isEnd;
    }

    /**
     * Method to verify if the case is a bonus
     *
     * @return isBonus
     */
    public boolean isBonus() {
        return isBonus;
    }

    /**
     * Method to verify if the case is a malus
     *
     * @return isMalus
     */
    public boolean isMalus() {
        return isMalus;
    }

    /**
     * Method to set the ID of the case
     *
     * @param idCase ID de la case
     */
    public void setIdCase(int idCase) {
        this.idCase = idCase;
    }

    /**
     * Method to set the X coordinate of the case
     *
     * @param coordX Coordonnée X
     */
    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    /**
     * Method to set the Y coordinate of the case
     *
     * @param coordY Coordonnée Y
     */
    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    /**
     * Method to set if the case is a start
     *
     * @param start setter de la case de départ
     */
    public void setStart(boolean start) {
        isStart = start;
    }

    /**
     * Method to set if the case is an end
     *
     * @param end setter de la case de fin
     */
    public void setEnd(boolean end) {
        isEnd = end;
    }
}
