package fr.iut63.a2ddicegameupdate.models.game;

/**
 * Classe d'update du timer.
 */
public class GameTimerUpdate {

    /**
     * Update du timer en direct
     * @param timer timer à update
     * @param millis nombre de millis écoulé
     * @param game Etat de la game (si mis sur pause timer arreté).
     */
        public static void updateTimerSeconds(int timer, long millis, GameState game){
            long timeMillis = timer * millis;
            int timeSeconds = (int) (timeMillis / 1000);
            if (timeSeconds != game.getTimeSeconds()) {
                game.setTimeSeconds(game.getTimeSeconds() + 1);
            }
        }
}
