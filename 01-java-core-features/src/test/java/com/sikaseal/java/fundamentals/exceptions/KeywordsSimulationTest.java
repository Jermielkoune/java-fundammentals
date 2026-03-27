package com.sikaseal.java.fundamentals.exceptions;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class KeywordsSimulationTest {

    // ===================================================================
    // 1. LE MOT-CLÉ 'throw' (Lancer la bombe 💣)
    // ===================================================================

    // Une méthode simple de retrait d'argent
    void retirerArgent(int solde, int montant) {
        if (montant > solde) {
            // L'ACTION : On utilise 'throw' pourcréer et lancer physiquement l'erreur.
            // Vu que c'est une RuntimeException (Unchecked), on n'est pas obligé de mettre 'thorws' sur la porte.
            throw new IllegalArgumentException("Solde insuffisant !");
        }
    }

    @Test
    void should_demonstrate_throw_keyword() {
        // On vérifie que notre 'throw' fonctionne bien quand la condition est remplie
        assertThatThrownBy(() -> retirerArgent(100, 500)).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Solde insuffisant !");
    }

    // ===================================================================
    // 2. LE MOT-CLÉ 'throws' (Le panneau d'avertissement ⚠️)
    // ===================================================================

    // LE PANNEAU : On ajoute 'throws IOException' à la signature.
    // Cela prévient le monde entier : "Cette méthode peut lancer une exception Checked".
    void connecterAuServeur() throws IOException {
        boolean serveurEnPanne = true;

        if (serveurEnPanne) {
            // On lance la bombe à l'intérieur
            throw new IOException("Le câble réseau est débranché");
        }
    }

    @Test
    void should_demonstrate_throws_keyword() {
        // Puisque connecterAuServeur() a le panneau 'throws IOException',
        // Java NOUS OBLIGE ici à mettre un try-catch, sinon ce test ne compilera pas
        try {
            connecterAuServeur();
        } catch (IOException e) {
            assertThat(e.getMessage()).isEqualTo("Le câble réseau est débranché");
        }
    }

    // ===================================================================
    // 3. LE BLOC 'try-catch-finally' (Le nettoyage garanti 🧹)
    // ===================================================================
    @Test
    void should_demonstrate_try_catch_finally_execution_order() {
        String etape = "Début";
        boolean porteFermee = false;

        try {
            etape = "Dans le try";

            // On simule une erreur en plein milieu du travail
            retirerArgent(50, 100);

            // Cette ligne ne sera jamais lue car l'erreur nous a éjectés du try
            etape = "Fin du try";
        } catch (IllegalArgumentException e) {
            // On atterit ici car l'errer a été lancée
            etape = "Dans le catch";
        } finally {
            // LE SECRET DU FINALLY :
            // Que le code ait réussi (try) ou explosé (catch), ce bloc s'exécute TOUJOURS.
            // On l'utilise dans la vraie vie pour fermer des fichiers ou déconnecter la base de données.
            porteFermee = true;
        }
        // Vérification du parcours
        assertThat(etape).isEqualTo("Dans le catch"); // Prouve qu'on est passé par le catch
        assertThat(porteFermee).isTrue();             // Prouve que le finally s'est bien exécuté à la toute fin
    }
}
