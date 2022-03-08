package fr.iut63.a2ddicegameupdate.models.player;

public class Player {
    private int idAvatar;
    private int numImage;
    private int coordX;
    private int coordY;

    /**
     * Constructor for the Avatar class
     * @param idAvatar id du personnage
     * @param coordX Coordonnée X
     * @param coordY Coordonnée Y
     */
    public Player(int idAvatar, int coordX, int coordY) {
        this.idAvatar = idAvatar;
        this.coordX = coordX;
        this.coordY = coordY;
    }

    /**
     * Method to get the ID of the avatar
     * @return idAvatar
     */
    public int getIdAvatar() {
        return idAvatar;
    }

    /**
     * Method to get the image of the avatar
     * @return image
     */
    public int getNumImage() {
        return this.numImage;
    }

    /**
     * Method to get the X coordinate of the avatar
     * @return coordX
     */
    public int getCoordX() {
        return coordX;
    }

    /**
     * Method to get the Y coordinate of the avatar
     * @return coordY
     */
    public int getCoordY() {
        return coordY;
    }

    /**
     * Method to set the ID of the avatar
     * @param idAvatar ID Personnage
     */
    public void setIdAvatar(int idAvatar) {
        this.idAvatar = idAvatar;
    }

    /**
     * Method to set the image of the avatar
     * @param numImage numéro de l'image
     */
    public void setNumImage(int numImage) {
        this.numImage = numImage;
    }

    /**
     * Method to set the X coordinate of the avatar
     * @param coordX Coordonnée X
     */
    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    /**
     * Method to set the Y coordinate of the avatar
     * @param coordY Coordonnée Y
     */
    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    /**
     * Method to get the coordinates of the avatar
     * @param coordX Coordonnée X
     * @param coordY Coordonnée Y
     */
    public void setCoord(int coordX, int coordY){
        this.coordX = coordX;
        this.coordY = coordY;
    }

}
