package com.sikaseal.java.fundamentals.strings;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class StringPoolTest {
    @Test
    void should_prove_that_string_literals_share_the_same_memory_address() {
        //GIVEN: On utilise des littéraux
        String hero1 = "Batman";
        String hero2 = "Batman";

        //THEN: Le string pool a fait son travail. Il n'a créé qu'un seul "Batman" !
        // '==' renvoie vrai car hero1 et hero2 pointent vers la même adresse mémoire
        assertThat(hero1 == hero2).isTrue();

        // Bien sûr, ils seront aussi logiquement égaux
        assertThat(hero1.equals(hero2)).isTrue();
    }

    @Test
    void should_prove_that_new_keyword_bypasses_the_string_pool() {
        // GIVEN: Un littéral dans la piscine
        String heroInPool = "Superman";

        //GIVEN: On force  la création d'un nouvel objet hors de la piscine avec 'new'
        String heroOutsideThePool = new String("Superman");

        //THEN: C'est le grand piège ! Ils ont le même texte, mais pas les même adresses
        assertThat(heroInPool == heroOutsideThePool).isFalse();

        // C'est POURQUOI on dit toujours utiliser .eqauls() pour comparer des strings en Java !
        assertThat(heroInPool.equals(heroOutsideThePool)).isTrue();
    }
}
