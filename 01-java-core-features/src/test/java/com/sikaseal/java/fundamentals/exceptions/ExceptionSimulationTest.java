package com.sikaseal.java.fundamentals.exceptions;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionSimulationTest {
    // ===================================================================
    // SCÉNARIO 1 : L'ERROR (Le moteur de la JVM qui explose)
    // ===================================================================

    // Une méthode qui s'appelle elle-même à l'infini (Boucle infinie)
    void macronExplosionMacronDecapitation(){
        macronExplosionMacronDecapitation();
    }

    @Test
    void should_simulate_an_error_crashing_the_jvm(){
        // Le code va tourner en ron jusqu'à ce que la RAM de Java sature.
        // Résultat : Un "StackOverflowError". On ne le catch JAMAIS dans la vraie vie
        assertThatThrownBy(() -> macronExplosionMacronDecapitation()).isInstanceOf(StackOverflowError.class);
    }

    // ===================================================================
    // SCÉNARIO 2 : L'EXCEPTION CHECKED (Maman et le Parapluie ☔)
    // ===================================================================
    @Test
    void should_simulate_checked_exception(){
        // GIVEN: Un fichier qui n'existe absolument pas sur mon ordinateur
        Path fauxFichier = Path.of("dossier_imaginaire/secret.txt");

        // SI ON DECOMMENTE LA LIGNE CI : Le compilateur va bloquer en rouge !
        // Files.readString(fauxFichier);

        // POURQUOI ? La méthode readString() déclare "throws IOException".
        // Java m'oblige à mettre un parapluie (try-catch) avant même de lancer le programme

        // Voici le parapluie obligatoire :
        try {
            Files.readString(fauxFichier);
        } catch (IOException e) {
            // On attrape l'erreur liée au monde extérieur (Disque dur)
            assertThat(e.getMessage()).contains("dossier_imaginaire");
        }
    }

    // ===================================================================
    // SCÉNARIO 3 : L'EXCEPTION UNCHECKED (Le poteau dans la rue 🤕)
    // ===================================================================
    @Test
    void should_simulate_unchecked_exception() {
        // GIVEN: Une variable texte qui est vide (null)
        String texteVide = null;

        // Le compilateur ne dit rien. Il me fait confiance, il pense que "texteVide" a une valeur
        // Mais à l'exécution (Runtime), je vais me prendre un bon poteau dans la gueule !

        assertThatThrownBy(() -> {
            // POTEAU : Essayer de mettre en majuscule un truc qui n'existe pas
            texteVide.toUpperCase();
        }).isInstanceOf(NullPointerException.class);
    }

    // ===================================================================
    // SCÉNARIO 4 : LA PROPAGATION (La Patate Chaude 🥔)
    // ===================================================================
    // 1. L'ouvrier fait une bêtise, mais n'a pas de try-catch.
    void ouvrier(){
        throw new RuntimeException("J'ai cassé la machine !");
    }

    // 2. Le manager appelle l'ouvrier. Il n'a pas de try-catch non plus !
    // La patate chaude (l'erreur) traverse le manager sans s'arrêter
    void manager(){
        ouvrier();
    }

    @Test
    void pdg_doit_gerer_la_propagation_des_exceptions(){
        String rapport = "";

        // 3. Le PDG (notre test) appelle le manager.
        // C'est LUI qui décide de mettre le filet de sécurité pour sauver l'entreprise
        try {
            manager();
            rapport = "Tout va bien"; // Cette ligne ne sera jamais lue
        } catch (RuntimeException e) {
            // L'erreur est remontée de l'ouvrier -> manager -> jusqu'ici !
            rapport = "Le PDG a géré la crise : " + e.getMessage();
        }
        assertThat(rapport).isEqualTo("Le PDG a géré la crise : J'ai cassé la machine !");
    }
}
