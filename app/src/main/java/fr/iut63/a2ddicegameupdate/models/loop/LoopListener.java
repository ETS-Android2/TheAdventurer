package fr.iut63.a2ddicegameupdate.models.loop;

import java.util.LinkedList;

/**
 * Classe abstraite de la loop (méthode observer)
 */
public abstract class LoopListener {
    private LinkedList<ILoopListener> observatory = new LinkedList<>();

    /**
     * Ajout d'un listener dans la liste de l'observateur
     * @param listener
     */
    public void subscribe(ILoopListener listener){
        observatory.add(listener);
    }

    /**
     * Suppression d'un listener dans la liste de l'observateur
     * @param listener
     */
    public void unsubscribe(ILoopListener listener){
        observatory.remove(listener);
    }

    /**
     * Notification de tout Observer sur la boucle
     * @param timer
     */
    protected void notify(int timer){
        for(ILoopListener observer : observatory){
            observer.update(timer);
        }
    }
}