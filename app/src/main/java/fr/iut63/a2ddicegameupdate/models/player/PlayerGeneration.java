package fr.iut63.a2ddicegameupdate.models.player;

public class PlayerGeneration extends Player {

    /**
     * Constructor for the Avatar class
     *
     * @param idAvatar id du personnage
     * @param coordX   Coordonnée X
     * @param coordY   Coordonnée Y
     */
    public PlayerGeneration(int idAvatar, int coordX, int coordY) {
        super(idAvatar, coordX, coordY);
    }

    /**
     * Génère une map du jeu
     * @return  int [][] Map
     */
    public int[] generatePlayerArray(){

        return new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12};
    }

}
