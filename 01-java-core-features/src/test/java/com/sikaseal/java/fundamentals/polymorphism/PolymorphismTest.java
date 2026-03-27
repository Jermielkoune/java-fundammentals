package com.sikaseal.java.fundamentals.polymorphism;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PolymorphismTest {
    @Test
    void should_demonstrate_static_polymorphism_overloading(){
        Healer cleric = new Healer();

        // Le compilateur sait exactement quel méthode appelé grâce aux paramètres
        assertThat(cleric.castHeal()).isEqualTo("Soin de base (10HP)");

        assertThat(cleric.castHeal(10)).isEqualTo("Soin puissant (10HP)");

        assertThat(cleric.castHeal("poison")).isEqualTo("Utilise la potion : poison");
    }

    @Test
    void should_demonstrate_dynamic_polymorphism_overloading(){
        // GIVEN: Une liste qui n'accepte que l'interface 'Fighter'
        // La liste ne sait pas s'il y a des Chevaliers ou des Archers. Elle s'en fiche !
        List<Fighter> team = List.of(new Knight(), new Archer(), new Knight());

        // WHEN: On fait attaquer le premier membre (C'est un chevalier)
        Fighter firstMember = team.get(0);

        // THEN: Le programme découvre *à la dernière seconde* que c'est un chevalier et appelle son code
        assertThat(firstMember.attack()).isEqualTo("Coup d'épée !");

        // WHEN: On fait attaquer le deuxième membre (C'est un Archer)
        Fighter secondMember = team.get(1);
        assertThat(secondMember.attack()).isEqualTo("Tire une flèche !");
    }
}
