package com.sikaseal.java.fundamentals.inheritance;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InheritanceTest {
    @Test
    void should_prove_abstract_classes_cannot_be_instantiated() {
        // DÉCOMMENTE CECI : Le compilateur hurle "GameCharacter is abstract; cannot be instantiated"
        // GameCharacter npc = new GameCharacter("PNJ", 100);
    }

    @Test
    void should_prove_dragon_is_polymorphic(){
        // GIVEN: Un seul objet en mémoire (le Dragon)
        Dragon smaug = new Dragon("smaug");

        // THEN: Grâce à l'héritage et aux interfaces, Smaug possède PLUSIEURS identités (Polymorphisme)
        // C'est un Dragon
        assertThat(smaug).isInstanceOf(Dragon.class);

        // C'est un GameCharacter (Héritage)
        assertThat(smaug).isInstanceOf(GameCharacter.class);

        // C'est un être capable de voler (Interface)
        assertThat(smaug).isInstanceOf(Flyable.class);
    }

    @Test
    void should_prove_final_method_execution(){
        Dragon smaug = new Dragon("smaug");
        // On utilise la méthode takeDamage.
        // Le code exécuté est celui de la classe parent GameCharacter, car on n'a pas pu l'Override.
        smaug.takeDamage(100);

        assertThat(smaug.getHealth()).isEqualTo(900);
    }
}
