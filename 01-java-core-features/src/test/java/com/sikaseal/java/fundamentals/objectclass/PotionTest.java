package com.sikaseal.java.fundamentals.objectclass;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PotionTest {
    @Test
    void should_prove_difference_between_memory_equality_and_logical_equality(){
        //GIVEN: Deux potions physiquement distinctes en mémoire, mais avec le même contenu
        Potion potion1 = new Potion("Soin", 50);
        Potion potion2 = new Potion("Soin", 50);

        //THEN: '==' vérifie l'adresse mémoire (ce ne sont pas les mêmes objets physiques)
        assertThat(potion1 == potion2).isFalse();

        //THEN: 'equals()' vérifie le contenu (ce sont des jumeaux logiques)
        assertThat(potion1.equals(potion2)).isTrue();
    }

    @Test
    void should_prove_hashcode_contract(){
        Potion potion1 = new Potion("Mana", 100);
        Potion potion2 = new Potion("Mana", 100);

        //Puisqu'elles sont 'equals', leur hashcode DOIT être strictement identique
        assertThat(potion1.hashCode()).isEqualTo(potion2.hashCode());
    }

    @Test
    void should_return_custom_string_representation(){
        Potion potion = new Potion("Feu", 100);

        //Prouve que notre toString() a écrasé l'adresse mémoire illisible
        assertThat(potion.toString()).isEqualTo("Potion de Feu; Puissance: 100");
    }

    @Test
    void should_clone_object_properly() throws CloneNotSupportedException {
        Potion potion1 = new Potion("Poison", 50);

        // On clone la potion
        Potion cloned = (Potion) potion1.clone();

        // Ce n'est pas la même adresse mémoire (c'est bien un nouvel objet)
        assertThat(potion1 == cloned).isFalse();

        // Mais le contenu est parfaitement identique
        assertThat(potion1).isEqualTo(cloned);
    }
}
