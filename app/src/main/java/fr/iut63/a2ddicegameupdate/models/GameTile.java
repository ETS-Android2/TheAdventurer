package fr.iut63.a2ddicegameupdate.models;

public class GameTile {
    private int idCase = 0;
    private int coordX;
    private int coordY;
    private final boolean start;
    private final boolean end;
    private final boolean malus;
    private final boolean bonus;

    public static final int TILE_SIZE = 32; // en pixel

    public static final int TYPE_EMPTY = 0;
    public static final int TYPE_BONUS = 1;
    public static final int TYPE_MALUS = 2;
    public static final int TYPE_EXIT = 3;

    private int mType = TYPE_EMPTY;
    private final boolean mVisible = true;

    /**
     * Constructor of the Case class
     *  @param idCase  ID de la case
     * @param coordX  Coordonnée X
     * @param coordY  Coordonnée Y
     * @param start Est elle la case de départ
     * @param isBonus Est elle une case bonus
     * @param isMalus Est elle une case malus
     * @param end   Est elle la case de fin
     */
    public GameTile(int idCase, int coordX, int coordY, boolean isBonus, boolean isMalus, boolean end, boolean start, int mType) {
        this.idCase = idCase;
        this.coordX = coordX;
        this.coordY = coordY;
        this.start = start;
        this.bonus = isBonus;
        this.malus = isMalus;
        this.end = end;
        this.mType = mType;
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
        return start;
    }

    /**
     * Method to verify if the case is an end
     *
     * @return isEnd
     */
    public boolean isEnd() {
        return end;
    }

    /**
     * Method to verify if the case is a bonus
     *
     * @return isBonus
     */
    public boolean isBonus() {
        return bonus;
    }

    /**
     * Method to verify if the case is a malus
     *
     * @return isMalus
     */
    public boolean isMalus() {
        return malus;
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
        start = start;
    }

    /**
     * Method to set if the case is an end
     *
     * @param end setter de la case de fin
     */
    public void setEnd(boolean end) {
        end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameTile gameTile = (GameTile) o;
        return idCase == gameTile.idCase && coordX == gameTile.coordX && coordY == gameTile.coordY && start == gameTile.start && end == gameTile.end && malus == gameTile.malus && bonus == gameTile.bonus && mType == gameTile.mType && mVisible == gameTile.mVisible;
    }
}
