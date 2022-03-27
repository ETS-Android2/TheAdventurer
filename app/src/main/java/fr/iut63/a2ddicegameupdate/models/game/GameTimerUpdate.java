package fr.iut63.a2ddicegameupdate.models.game;

public class GameTimerUpdate {

        public static void updateTimerSeconds(int timer, long millis, GameState game){
            long timeMillis = timer * millis;
            int timeSeconds = (int) (timeMillis / 1000);
            if (timeSeconds != game.getTimeSeconds()) {
                game.setTimeSeconds(game.getTimeSeconds() + 1);
            }
        }
}
