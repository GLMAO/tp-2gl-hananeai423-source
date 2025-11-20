package com.polytech;
import com.polytech.tp.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        System.out.println( "=== TEST SIMPLE DES PATTERNS ===" );
        
        // 1. Test du Builder - Création de cours
        System.out.println("\n1. CRÉATION DE COURS AVEC BUILDER:");
        Cours cours1 = new CoursBuilder()
            .setMatiere("Génie Logiciel")
            .setEnseignant("Dr. Martin")
            .setSalle("A101")
            .setDate("2024-01-15")
            .setHeureDebut("14:00")
            .build();
        
        Cours cours2 = new CoursBuilder()
            .setMatiere("Base de Données")
            .setEnseignant("Prof. Wilson")
            .setSalle("B205")
            .setDate("2024-01-16")
            .setHeureDebut("10:00")
            .setEstOptionnel(true)
            .build();
        
        System.out.println("Cours 1: " + cours1.getDescription());
        System.out.println("Cours 2: " + cours2.getDescription());
        
        // 2. Test de l'Observer - Création d'étudiants et responsables
        System.out.println("\n2. TEST DE L'OBSERVER:");
        GestionnaireEmploiDuTemps gestionnaire = new GestionnaireEmploiDuTemps();
        
        Etudiant etudiant1 = new Etudiant("Alice");
        Etudiant etudiant2 = new Etudiant("Bob");
        Responsable responsable1 = new Responsable("Dr. Smith");
        
        gestionnaire.attach(etudiant1);
        gestionnaire.attach(etudiant2);
        gestionnaire.attach(responsable1);
        
        gestionnaire.ajouterCours(cours1);
        gestionnaire.ajouterCours(cours2);
        
        gestionnaire.modifierCours(cours1, "Changement de salle");
        
        // 3. Test du Decorator
        System.out.println("\n3. TEST DU DECORATOR:");
        ICours coursEnLigne = new CoursEnLigne(cours1);
       // ICours coursEnAnglais = new CoursEnAnglais(cours2);
        //ICours coursCombined = new CoursEnLigne(new CoursEnAnglais(cours1));
        
        System.out.println("Cours en ligne: " + coursEnLigne.getDescription());
        //System.out.println("Cours en anglais: " + coursEnAnglais.getDescription());
       // System.out.println("Cours combiné: " + coursCombined.getDescription());
        
        System.out.println("\n=== TEST TERMINÉ ===");

    
    }
}
