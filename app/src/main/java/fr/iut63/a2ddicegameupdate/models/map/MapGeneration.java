package fr.iut63.a2ddicegameupdate.models.map;

import android.util.Log;

import java.util.ArrayList;

import fr.iut63.a2ddicegameupdate.models.Case;

/**
 * Classe génératrice de la map ainsi que du chemin qu'utilisera le personnage
 */
public class MapGeneration extends Map{
    //private final int[][] coordFirstDifficultyMap = {{0,0},{0,1},{0,2},{0,3},{1,3},{2,3},{3,3},{3,4},{3,5},{3,6},{3,7},{3,8},{3,9},{3,10},{3,11},{3,12},{4,12},{5,12},{6,12},{7,12},{8,12},{9,12},{9,13},{9,14},{9,15},{9,16},{9,17},{9,18},{8,18}};
    private final int[][] coordFirstDifficultyMap = {{1,24},{2,24},{3,24},{4,24},{5,24},{5,23},{5,22},{5,21},{5,20},{5,19},{5,18},{6,18},{7,18},{8,18},{9,18},{9,17},{9,16},{9,16},{9,15},{9,14},{9,13},{9,12},{8,12},{7,12},{6,12},{5,12},{4,12},{3,12},{3,11},{3,10},{3,9},{3,8},{3,7},{3,6},{3,5},{3,4},{3,3},{4,3},{5,3},{6,3},{7,3},{8,3},{9,3},{9,2},{10,2},{11,2},{12,2},{13,2},{14,2},{15,2},{16,2},{17,2},{18,2},{19,2},{19,3},{19,4},{19,5},{19,6},{19,7},{19,8},{19,9},{19,10},{20,10},{21,10},{22,10},{23,10},{24,10},{24,11},{24,12},{24,13},{24,14},{24,15},{24,16},{24,17},{24,18},{24,19},{24,20},{24,21},{24,22},{24,23},{24,24},{25,24},{25,24},{26,24},{27,24},{28,24},{29,24},{30,24},{30,23},{30,22},{30,21},{30,20},{30,19},{31,19},{32,19},{33,19},{33,18},{33,17},{33,16},{34,16},{35,16},{36,16},{37,16},{38,16},{38,17},{38,18},{38,19},{39,19},{40,19}};
    private final int[][] coordSecondDifficultyMap = {{0,24},{1,24},{2,24},{3,24},{4,24},{5,24},{6,24},{7,24},{7,23},{7,22},{7,21},{7,20},{7,19},{7,18},{7,17},{7,16},{7,15},{7,14},{7,13},{7,12},{7,11},{7,10},{7,9},{7,8},{7,7},{7,6},{7,5},{7,4},{8,4},{9,4},{10,4},{11,4},{12,4},{13,4},{14,4},{15,4},{16,4},{16,5},{16,6},{16,7},{16,8},{16,9},{16,10},{16,11},{16,12},{16,13},{16,14},{16,15},{16,16},{16,17},{16,18},{16,19},{16,20},{17,20},{18,20},{19,20},{20,20},{21,20},{22,20},{23,20},{23,21},{23,22},{23,23},{24,23},{25,23},{26,23},{27,23},{28,23},{29,23},{30,23},{30,22},{30,21},{30,20},{31,20},{32,20},{33,20},{34,20},{35,20},{36,20},{37,20},{37,19},{37,18},{37,17},{37,16},{37,15},{37,14},{37,13},{37,12},{37,11},{37,10},{37,9},{37,8},{36,8},{35,8},{34,8},{33,8},{32,8},{31,8},{31,7},{31,6},{31,5},{31,4},{31,3},{31,2},{31,1},{31,0}};
    private final int[][] coordThirdDifficultyMap = {{1,2},{2,2},{3,2},{4,2},{4,3},{4,4},{4,5},{4,6},{4,7},{4,8},{4,9},{4,10},{4,11},{4,12},{4,13},{4,14},{4,15},{4,16},{4,17},{4,18},{4,19},{4,20},{4,21},{4,22},{4,23},{4,24},{5,24},{6,24},{7,24},{8,24},{9,24},{10,24},{10,23},{10,22},{10,21},{10,20},{10,19},{10,18},{10,17},{11,17},{12,17},{12,17},{13,17},{14,17},{15,17},{16,17},{17,17},{18,17},{19,17},{19,18},{19,19},{19,20},{19,21},{19,22},{20,22},{21,22},{22,22},{23,22},{24,22},{25,22},{26,22},{27,22},{28,22},{28,21},{28,20},{29,20},{30,20},{31,20},{32,20},{33,20},{34,20},{35,20},{36,20},{37,20},{38,20},{38,19},{38,18},{38,17},{38,16},{38,15},{38,14},{38,13},{38,12},{38,11},{38,10},{38,9},{38,8},{38,7},{38,6},{38,5},{37,5},{36,5},{35,5},{34,5},{33,5},{32,5},{31,5},{30,5},{29,5},{28,5},{27,5},{26,5},{26,6},{26,7},{26,8},{26,9},{26,10},{25,10},{24,10},{23,10},{22,10},{21,10},{20,10},{20,9},{19,9},{18,9},{17,9},{16,9},{15,9},{14,9},{13,9},{12,9},{11,9},{10,9},{10,8},{10,7},{10,6},{10,5},{10,4},{10,3},{11,3},{12,3},{13,3},{14,3},{15,3},{16,3},{17,3},{18,3},{19,3},{20,3},{21,3},{22,3},{23,3},{24,3},{24,2},{24,1},{24,0}};
    private int[][] coordMap = {};
    private Map map;

    /**
     * Génère une map par tableau
     * @param mapWidth  int Largeur de la Fenetre
     * @param mapHeight int Longueur de la Fenetre
     */
    public MapGeneration(int mapWidth, int mapHeight, int difficulty) {
        super(mapWidth, mapHeight);
        this.map = new Map(mapWidth, mapHeight);
        setMapFirstLayout(generateFirstLayoutMapArray());
        setMapSecondLayout(generateSecondLayoutMapArray());
        setMapThirdLayout(generateThirdLayoutMapArray());
        setMapFirstLayout2(generateFirstLayoutMapArray2());
        setMapSecondLayout2(generateSecondLayoutMapArray2());
        setMapThirdLayout2(generateThirdLayoutMapArray2());
        createCaseList(difficulty);
    }

    /**
     * Method which create the caselist of the map
     * @param difficulty
     */
    public void createCaseList(int difficulty) {

        int j = 1, k;
        if(difficulty==1){
            coordMap = coordFirstDifficultyMap;
        }else if (difficulty==2){
                coordMap = coordSecondDifficultyMap;
        }else{
            coordMap = coordThirdDifficultyMap;
        }
        for(int[] i : coordMap){
            boolean boolStart = j == 1;
            boolean boolEnd = j == coordMap.length;
            boolean bonus = false, malus = false;

            if(difficulty == 1) k = (int) (Math.random() * 10);
            else if(difficulty == 2) k = (int) (Math.random() * 8);
            else k = (int) (Math.random() * 6);

            if(k == 1 || k == 2) bonus = true;
            else if(k == 3) malus = true;

            Case case1 = new Case(j, i[0], i[1], boolStart, bonus, malus, boolEnd, map);
            map.addCase(case1);
            j++;
        }


        if (difficulty != 1 && difficulty != 2 && difficulty != 3) {
            System.out.println("Difficulty not found");
        }
    }

    public ArrayList<Case> getPlayerMap(){
        return map.getMap();
    }

    public Map getMapTile(){
        return this.map;
    }

    /**
     * Génère une map du jeu
     * @return  int [][] Map
     */
    public int[][] generateFirstLayoutMapArray(){

        return new int[][]{

                {73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73},
                {73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73},
                {73,73,73,73,73,73,73,73,73,578,578,578,578,578,578,578,578,578,578,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73},
                {73,73,73,578,578,578,578,578,578,578,73,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73},
                {73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73},
                {73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73},
                {73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73},
                {73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73},
                {73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73},
                {73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73},
                {73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,578,578,578,578,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73},
                {73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73},
                {73,73,73,578,578,578,578,578,578,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73},
                {73,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73},
                {73,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73},
                {73,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73},
                {73,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,578,578,578,578,578,578,73,73,73},
                {73,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,578,73,73,73,73,578,73,73,73},
                {73,73,73,73,73,578,578,578,578,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,578,73,73,73,73,578,73,73,73},
                {73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73,73,578,578,578,578,73,73,73,73,578,578,578,578},
                {73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73},
                {73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73},
                {73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73},
                {73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73},
                {578,578,578,578,578,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,578,578,578,578,578,578,73,73,73,73,73,73,73,73,73,73,73},
                {73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73},
                {73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73},
        };
    }

    public int[][] generateFirstLayoutMapArray2(){

        return new int[][]{

                {1411,1026,0,0,1477,1478,0,0,0,0,1383,1384,0,0,0,1351,1352,0,0,0,0,0,0,0,1505,1475,1476,1475,1476,1475,1476,1475,1476,1475,1476,1475,1476,1475,1476,1475,1476,1475},
                {1443,0,1509,0,0,0,0,1412,0,0,0,0,0,0,0,1383,1384,0,0,1025,0,1509,0,1413,1537,1507,1508,1507,1508,1507,1508,1507,1508,1507,1508,1507,1508,1507,1508,1507,1508,1507},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1537,1476,1475,1476,1475,1476,1475,1476,1475,1476,1475,1476,1475,1476,1475,1476,1475},
                {0,1026,1026,0,0,0,0,0,0,0,0,1411,0,0,0,0,1025,0,0,0,0,0,0,1026,0,0,1537,1507,1508,1507,1508,1507,1508,1507,1508,1507,1508,1507,1508,1507,1508,1507},
                {1351,1352,0,0,0,0,0,0,0,0,0,1443,0,1026,0,0,1025,1411,0,0,0,1411,0,0,0,0,0,1537,1476,1475,1476,1475,1476,1475,1476,1475,1476,1475,1476,1475,1476,147},
                {1383,1384,0,0,1411,0,0,0,1413,0,0,1510,0,1351,1352,0,1509,1443,0,0,0,1443,0,1510,0,1412,0,1025,1537,1507,1508,1507,1508,1507,1508,1507,1508,1507,1508,1507,1508,1507},
                {0,0,0,0,1443,0,1351,1352,0,0,0,0,1026,1383,1384,0,0,0,0,0,0,0,0,0,0,1411,0,0,0,1537,1476,1475,1476,1475,1476,1475,1476,1475,1476,1475,1476,1475},
                {0,1413,0,0,0,0,1383,1384,1026,0,1025,1026,0,0,0,0,0,1026,0,0,0,1413,0,0,0,1443,0,0,1026,1505,1508,1507,1508,1507,1508,1507,1508,1507,1508,1507,1508,1507},
                {1026,0,0,0,0,1477,1478,0,0,0,1509,0,1026,0,0,1477,1478,0,0,0,0,0,0,0,0,0,0,0,0,1537,1538,1537,1538,1537,1538,1537,1476,1475,1476,1475,1476,1475},
                {0,1510,0,0,0,0,0,0,0,0,0,0,1412,0,0,1411,0,0,0,0,0,0,0,0,0,1026,0,1509,0,0,0,0,0,0,0,0,1537,1507,1508,1507,1508,1507},
                {0,0,0,0,0,1412,0,1025,0,1413,0,0,0,0,0,1443,0,1413,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1411,0,1026,0,0,1537,1476,1475,1476,1475},
                {0,1026,0,0,0,0,0,0,0,0,0,0,1351,1352,0,0,0,0,0,0,0,0,0,0,0,0,1025,0,0,1477,1478,0,1443,0,0,0,1411,0,1537,1507,1508,1507},
                {1025,0,0,0,0,0,0,0,0,0,0,0,1383,1384,0,1510,0,1026,0,1412,0,0,1411,0,0,0,0,1413,0,0,0,0,0,0,1351,1352,1443,0,0,1537,1538,1537},
                {1351,1352,1411,0,0,0,0,0,0,0,0,1026,0,0,0,0,1411,0,0,0,1026,0,1443,0,0,0,1414,0,0,0,1412,0,1026,0,1383,1384,0,1026,0,0,1025,0},
                {1383,1384,1443,0,0,0,1413,0,1025,0,0,0,0,0,0,0,1443,0,1509,0,0,0,0,0,0,0,1445,0,0,1411,0,1509,0,0,0,1411,0,1413,0,0,1411,0},
                {0,0,0,0,1414,0,0,0,0,0,0,0,1510,0,1477,1478,0,0,0,0,1351,1352,1026,0,0,0,1446,0,0,1443,0,0,0,0,0,1443,0,0,0,0,1443,0},
                {0,1026,0,0,1445,0,0,1025,0,0,0,1351,1352,0,0,0,0,0,1411,0,1383,1384,0,0,0,0,0,0,1510,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,1509,1026,0,1446,0,0,0,0,0,0,1383,1384,0,0,1941,1942,0,1443,0,0,0,0,0,0,0,0,0,1411,0,0,1026,0,0,0,0,0,0,0,0,0,1026},
                {0,0,0,0,0,0,0,0,0,0,0,0,1610,0,0,1973,1974,0,0,1738,0,1025,1026,0,0,0,0,0,1443,0,0,0,0,0,0,0,1411,0,0,0,0,0},
                {0,0,0,1412,0,0,0,0,0,0,0,1025,1642,0,0,0,0,0,0,1770,0,0,0,0,0,0,1026,0,0,0,0,0,0,0,0,1026,1443,0,0,0,0,0},
                {0,1510,0,0,0,0,0,0,1026,0,0,0,1411,1880,0,2006,0,1880,0,0,0,1477,1478,0,0,0,0,1351,1352,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,1351,1352,0,0,0,0,0,1413,0,0,1443,0,2006,1411,2005,2005,0,1880,0,0,0,0,0,0,0,1383,1384,0,0,1025,0,0,0,1412,0,0,1413,0,1411,0},
                {1026,0,1383,1384,0,0,0,1411,1025,0,0,1882,1738,1880,0,1443,2005,2006,1411,0,1883,0,0,0,0,0,0,0,0,0,0,0,0,1411,0,0,0,0,0,0,1443,0},
                {0,0,0,0,0,0,0,1443,1025,1026,0,1914,1770,0,0,2005,0,0,1443,1802,1915,0,1413,0,0,0,0,1025,0,0,0,0,0,1443,0,1025,1026,0,0,0,0,1414},
                {0,0,0,0,0,0,0,0,0,0,1411,0,0,0,0,0,0,1880,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1477,1478,0,1445},
                {0,1411,0,0,0,0,0,0,0,0,1443,0,0,1477,1478,0,0,0,1026,0,1025,0,1510,0,1411,0,0,0,0,0,1025,0,0,1413,0,0,1025,0,0,0,0,1446},
                {0,1443,0,0,1411,0,0,0,1351,1352,0,0,1510,0,0,1025,0,0,0,1412,0,1026,0,0,1443,0,0,1026,0,0,0,1509,0,1025,0,0,1413,0,0,1026,0,0},
        };
    }

    public int[][] generateSecondLayoutMapArray(){

        return new int[][]{



                {73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73},
                {73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73},
                {73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73},
                {73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73},
                {73,73,73,73,73,73,73,578,578,578,578,578,578,578,578,578,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73},
                {73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73},
                {73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73},
                {73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73},
                {73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,578,578,578,578,578,578,73,73,73,73},
                {73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73},
                {73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73},
                {73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73},
                {73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73},
                {73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73},
                {73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73},
                {73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73},
                {73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73},
                {73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73},
                {73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73},
                {73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73},
                {73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,578,578,578,578,578,578,578,578,73,73,73,73,73,73,578,578,578,578,578,578,578,578,73,73,73,73},
                {73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73},
                {73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73},
                {73,73,73,73,73,73,73,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,578,578,578,578,578,578,578,578,73,73,73,73,73,73,73,73,73,73,73},
                {578,578,578,578,578,578,578,578,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73},
                {73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73},
                {73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73},
        };
    }
    public int[][] generateSecondLayoutMapArray2(){

        return new int[][]{

                {1508,1507,1508,1507,1508,1507,1508,1538,1060,0,0,0,0,0,0,1380,0,0,0,0,0,0,1380,0,1059,0,1446,0,1380,0,0,0,0,1961,0,0,1383,1384,1383,1384,1383,1384},
                {1507,1508,1507,1508,1507,1508,1538,0,0,0,1379,0,1411,1345,0,0,0,0,1026,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1961,0,0,0,0,0,0,0,0},
                {1508,1507,1508,1507,1508,1538,0,1345,0,0,1058,0,1443,0,0,0,1091,0,0,0,1380,0,0,0,0,1345,0,0,0,1091,0,0,0,1961,0,0,0,1059,0,0,1345,0},
                {1507,1508,1507,1508,1538,0,0,0,0,0,0,0,0,0,0,0,0,0,1026,0,0,0,1091,0,0,0,1380,0,1058,0,0,0,0,1995,1931,1931,1931,1931,1931,1964,0,0},
                {1537,1538,1537,1538,0,1026,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1961,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1382,0,0,0,0,1414,0,0,0,1382,0,0,0,0,1351,1352,0,0,1936,0,1961,0,0},
                {1580,1581,0,0,1414,1058,0,0,0,1351,1352,0,1026,0,0,0,0,0,0,0,0,0,0,0,1446,1058,0,0,0,0,0,0,0,1383,1384,0,0,0,0,1961,0,0},
                {1612,1613,0,0,1446,0,0,0,0,1383,1384,1539,1540,0,1345,0,0,0,0,0,1091,0,1345,0,0,0,0,0,0,1058,0,0,0,0,0,0,0,0,0,1995,1964,0},
                {0,0,0,0,0,0,0,0,0,0,0,1571,1572,0,0,0,0,1060,0,0,0,0,0,0,0,0,1121,0,0,0,0,0,0,0,0,0,0,0,0,0,1961,0},
                {1671,1671,1671,0,1345,0,0,0,0,0,0,1603,1604,0,0,0,0,0,0,0,0,0,0,1411,0,0,1153,0,1414,0,1345,0,0,0,0,0,0,0,0,0,1961,0},
                {1671,1671,1671,0,1580,1581,0,0,0,0,0,0,0,0,1058,0,0,0,1026,0,1414,0,0,1443,0,1345,0,0,1446,0,0,0,0,0,0,0,0,0,0,0,1961,0},
                {1671,1671,1671,0,1612,1613,0,0,0,1411,0,0,0,0,0,0,0,0,0,0,1446,0,0,0,0,0,0,1059,0,0,0,0,1441,1442,0,0,0,0,0,0,1961,0},
                {1671,1671,1671,0,0,0,0,0,0,1443,0,1026,0,1345,0,0,0,0,0,0,0,0,0,0,1441,1442,0,0,0,0,0,0,1473,1474,0,0,0,0,1345,0,1961,0},
                {1671,1671,1671,0,0,1059,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1473,1474,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1961,0},
                {0,0,0,0,1634,0,0,0,0,0,0,0,1414,0,1058,0,0,0,0,1414,0,0,1026,0,0,1882,0,1000,0,1000,0,1000,0,1000,0,1883,0,0,0,0,1995,1931},
                {1672,1672,1672,0,1666,0,0,0,0,0,0,0,1446,0,0,0,0,0,0,1446,0,0,0,0,0,1914,0,0,0,0,0,0,0,0,0,1915,0,0,0,0,0,0},
                {1672,1672,1672,0,0,0,0,0,0,0,1345,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1000,0,1000,0,1000,0,1000,0,0,0,0,1026,0,0,1935},
                {1672,1672,1672,0,1026,0,1058,0,0,0,0,0,0,1026,0,0,0,0,1060,0,1345,0,0,0,0,1121,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {1672,1672,1672,0,0,0,0,0,0,0,0,0,0,1060,0,0,0,0,0,0,0,0,0,0,0,1153,0,0,0,1000,0,1000,0,1441,1442,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,1058,0,1351,1352,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1473,1474,0,0,0,0,1411,0,1026},
                {1703,1703,1703,1703,1703,1059,0,0,0,0,0,1383,1384,0,1058,0,0,0,0,0,0,0,0,0,0,0,0,1060,1411,0,0,0,0,0,0,0,0,0,0,1443,0,0},
                {1703,1703,1703,1703,1703,1411,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1026,0,0,1443,0,0,1058,0,0,1345,0,0,0,0,0,1059,0},
                {1703,1703,1703,1703,1703,1443,0,0,0,1345,0,0,0,0,1026,0,0,1411,0,0,1026,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1345,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1443,0,1026,1026,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,1414,0,1060,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1351,1352,1351},
                {1026,0,0,0,0,0,0,0,0,0,0,1446,0,0,0,0,1345,0,0,0,1351,1352,0,0,1059,0,0,0,1059,0,0,0,0,1351,1352,0,1060,0,1351,1415,1416,1415},
                {0,0,1351,1352,0,0,1026,0,0,0,0,0,1058,0,0,0,0,0,0,0,1383,1384,0,0,0,0,0,1026,0,0,1414,0,0,1383,1384,0,0,1351,1415,1447,1448,1447},
        };
    }

    public int[][] generateThirdLayoutMapArray(){

        return new int[][]{

                {800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,578,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800},
                {800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,578,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800},
                {578,578,578,578,578,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,578,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800},
                {800,800,800,800,578,800,800,800,800,800,578,578,578,578,578,578,578,578,578,578,578,578,578,578,578,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800},
                {800,800,800,800,578,800,800,800,800,800,578,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800},
                {800,800,800,800,578,800,800,800,800,800,578,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,578,578,578,578,578,578,578,578,578,578,578,578,578,800,800,800},
                {800,800,800,800,578,800,800,800,800,800,578,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,578,800,800,800,800,800,800,800,800,800,800,800,578,800,800,800},
                {800,800,800,800,578,800,800,800,800,800,578,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,578,800,800,800,800,800,800,800,800,800,800,800,578,800,800,800},
                {800,800,800,800,578,800,800,800,800,800,578,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,578,800,800,800,800,800,800,800,800,800,800,800,578,800,800,800},
                {800,800,800,800,578,800,800,800,800,800,578,578,578,578,578,578,578,578,578,578,578,800,800,800,800,800,578,800,800,800,800,800,800,800,800,800,800,800,578,800,800,800},
                {800,800,800,800,578,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,578,578,578,578,578,578,578,800,800,800,800,800,800,800,800,800,800,800,578,800,800,800},
                {800,800,800,800,578,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,578,800,800,800},
                {800,800,800,800,578,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,578,800,800,800},
                {800,800,800,800,578,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,578,800,800,800},
                {800,800,800,800,578,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,578,800,800,800},
                {800,800,800,800,578,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,578,800,800,800},
                {800,800,800,800,578,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,578,800,800,800},
                {800,800,800,800,578,800,800,800,800,800,578,578,578,578,578,578,578,578,578,578,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,578,800,800,800},
                {800,800,800,800,578,800,800,800,800,800,578,800,800,800,800,800,800,800,800,578,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,578,800,800,800},
                {800,800,800,800,578,800,800,800,800,800,578,800,800,800,800,800,800,800,800,578,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,578,800,800,800},
                {800,800,800,800,578,800,800,800,800,800,578,800,800,800,800,800,800,800,800,578,800,800,800,800,800,800,800,800,578,578,578,578,578,578,578,578,578,578,578,800,800,800},
                {800,800,800,800,578,800,800,800,800,800,578,800,800,800,800,800,800,800,800,578,800,800,800,800,800,800,800,800,578,800,800,800,800,800,800,800,800,800,800,800,800,800},
                {800,800,800,800,578,800,800,800,800,800,578,800,800,800,800,800,800,800,800,578,578,578,578,578,578,578,578,578,578,800,800,800,800,800,800,800,800,800,800,800,800,800},
                {800,800,800,800,578,800,800,800,800,800,578,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800},
                {800,800,800,800,578,578,578,578,578,578,578,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800},
                {800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800},
                {800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800},
        };
    }

    public int[][] generateThirdLayoutMapArray2(){

        return new int[][]{

                {0,1038,0,0,1070,0,0,0,1038,0,1070,0,0,0,1070,0,1038,0,0,0,1038,0,0,0,0,0,1070,0,0,0,1070,0,0,0,1038,0,0,0,0,1040,1034,1038},
                {0,1070,0,0,0,0,1034,0,1070,0,0,0,1038,0,0,0,1070,0,1037,0,1070,0,1036,0,0,0,0,1037,0,1038,0,0,1040,0,1070,0,0,1038,0,0,0,1070},
                {0,0,0,0,0,0,1038,1069,0,0,1002,0,1070,0,0,0,0,0,0,0,0,0,0,0,0,0,1038,0,0,1070,0,1036,0,1038,0,0,0,1070,0,0,0,1036},
                {0,1038,0,0,0,0,1070,0,1034,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1070,0,1040,0,0,1038,0,1070,0,1034,0,0,0,1038,0,0},
                {0,1070,0,1038,0,0,0,0,1040,0,0,0,1036,0,0,0,0,0,0,1038,0,0,0,0,0,0,0,0,0,0,0,1070,0,0,0,0,0,1036,0,1070,0,1038},
                {0,1069,0,1070,0,1037,0,1038,0,0,0,0,0,1038,1040,0,0,1069,0,1070,0,1036,1067,0,1038,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1070},
                {1034,0,0,0,0,1038,0,1070,0,0,0,0,0,1070,0,0,1038,0,0,0,0,1038,0,0,1070,0,0,0,0,0,0,0,0,1038,0,0,0,0,0,0,1036,0},
                {0,1038,1036,0,0,1070,0,1036,0,0,0,0,0,1038,0,0,1070,0,1037,0,0,1070,0,0,1038,0,0,1037,0,1038,1069,0,1038,1070,0,1038,0,0,0,0,1038,0},
                {0,1070,0,0,0,0,0,0,0,1038,0,0,0,1070,0,0,0,0,0,0,0,0,1040,0,1070,0,0,0,0,1070,0,0,1070,0,0,1070,1036,0,0,0,1070,1036},
                {0,1036,1040,0,0,0,1038,0,1067,1070,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1038,0,0,0,0,0,0,0,0,1038,0,0},
                {0,0,0,0,0,0,1070,0,1034,0,0,1038,0,0,0,0,0,1038,0,0,0,0,0,0,0,0,0,0,1040,0,1070,0,0,1038,0,0,1038,0,0,1070,0,1038},
                {1034,0,1038,0,0,0,0,1038,0,1040,0,1070,0,1038,0,0,0,1070,0,1036,0,0,0,0,0,0,0,0,0,0,0,0,1038,1070,0,0,1070,0,0,0,0,1070},
                {0,0,1070,0,0,1036,0,1070,0,0,0,1036,0,1070,0,0,1038,0,0,0,0,1040,1186,0,1037,0,1036,1186,0,1038,0,0,1070,0,1034,0,0,0,0,0,1038,0},
                {1038,0,0,0,0,1038,0,0,0,1038,0,0,0,0,0,1034,1070,0,1038,0,0,0,1038,0,0,1038,0,0,0,1070,0,1069,0,0,0,1038,0,0,0,0,1070,0},
                {1070,0,1034,0,0,1070,0,1038,0,1070,0,1038,0,0,1038,0,0,0,1070,0,1067,0,1070,0,0,1070,0,1038,0,0,0,1038,0,0,0,1070,0,1038,0,0,0,0},
                {0,1038,0,1036,0,0,0,1070,0,0,0,1070,0,0,1070,0,1038,0,0,1036,0,0,0,0,1006,0,1004,1070,0,1186,0,1070,0,0,0,0,0,1070,0,0,1040,0},
                {0,1070,0,1038,0,0,0,0,1036,0,1003,0,0,0,0,0,1070,0,0,0,0,0,0,1038,1006,1006,1005,0,1067,0,0,0,0,0,1038,0,0,0,0,0,0,1038},
                {1069,0,1038,1070,0,0,1040,0,1038,0,0,0,0,0,0,0,0,0,0,0,0,1040,0,1070,0,0,1005,0,0,1038,0,0,0,0,1070,0,0,0,0,0,1036,1070},
                {0,0,1070,0,0,0,0,0,1070,0,0,0,0,1034,0,0,0,0,0,0,0,0,0,0,0,0,1005,0,0,1070,0,1065,0,0,0,0,1036,0,0,1038,0,0},
                {1038,1036,0,0,0,1038,0,0,0,0,0,0,1038,0,1038,1036,0,1038,0,0,0,1038,0,1069,0,1038,1005,0,1003,0,0,0,0,1034,0,0,0,0,0,1070,0,0},
                {1070,0,1038,0,0,1070,0,1038,0,0,0,0,1070,0,1070,0,0,1070,0,0,0,1070,0,0,0,1070,1005,0,0,0,0,0,0,0,0,0,0,0,0,0,1034,0},
                {0,1038,1070,0,0,0,0,1070,0,1037,0,0,0,1036,1038,0,1038,0,0,0,0,0,0,0,0,0,1005,0,0,1036,0,0,0,0,0,0,0,0,0,0,1038,0},
                {0,1070,0,0,0,0,1038,0,1038,0,0,0,1038,0,1070,0,1070,0,1036,0,0,0,0,0,0,0,0,0,0,0,0,1038,1069,0,1038,0,1036,1036,1038,0,1070,0},
                {0,0,0,0,0,0,1070,0,1070,0,0,0,1070,0,0,0,0,1034,0,0,0,0,0,0,1038,0,0,0,1038,1038,0,1070,0,0,1070,0,1038,0,1070,0,0,1038},
                {1034,0,1069,1038,0,0,0,0,0,0,0,0,0,1038,1069,0,1040,0,0,1038,0,0,0,0,1070,0,1036,0,1070,1070,0,0,1040,0,1069,0,1070,0,0,0,0,1070},
                {0,1038,0,1070,0,0,0,0,1034,0,1038,0,0,1070,1036,0,1038,0,0,1070,0,1038,1036,1069,0,0,1037,0,1038,0,0,1036,0,1038,0,0,0,0,0,1038,1069,0},
                {0,1070,0,1036,0,1040,0,1038,0,0,1070,1036,0,0,0,0,1070,0,0,0,0,1070,0,0,1038,0,0,0,1070,0,1034,0,0,1070,0,0,1038,0,0,1070,0,1037},
        };
    }

}