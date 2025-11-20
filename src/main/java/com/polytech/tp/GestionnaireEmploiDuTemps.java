package com.polytech.tp;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireEmploiDuTemps implements Subject {
    private List<ICours> listeCours = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();
    private String Changement;
    public void ajouterCours(ICours cours) {
        this.listeCours.add(cours);
        System.out.println("Nouveau cours ajouté : " + cours.getDescription());
        // TODO: C'est ici qu'il faudrait notifier les étudiants (Observer pattern)
        notifyObservers("Nouveau cours ajouté : " + cours.getDescription());
    }

    public void modifierCours(ICours cours, String message) {
        // Logique de modification...
        System.out.println("Cours modifié : " + message);
        // TODO: Notifier les observateurs ici aussi
         notifyObservers("Cours modifié : " + message);
    }

     public void annulerCours(ICours cours) {
        this.listeCours.remove(cours);
        System.out.println("Cours annulé : " + cours.getDescription());
        // Notification des observateurs
        notifyObservers("Cours annulé : " + cours.getDescription());
    }

    // Implémentation des méthodes du pattern Observer
    @Override
    public void attach(Observer observer) {
        observers.add(observer);
        System.out.println("Nouvel observateur attaché : " + observer.getClass().getSimpleName());
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
        System.out.println("Observateur détaché : " + observer.getClass().getSimpleName());
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void setChangement(String message) {
        this.Changement=message;
        System.out.println("Changement détecté : " + message);
        notifyObservers( Changement);
    }
    
    // Méthode utilitaire pour voir le nombre d'observateurs
    public int getNombreObservateurs() {
        return observers.size();
    }
}