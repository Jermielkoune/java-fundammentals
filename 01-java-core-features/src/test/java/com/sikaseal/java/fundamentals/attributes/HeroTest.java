package com.sikaseal.java.fundamentals.attributes;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HeroTest {
    @Test
    public void should_prove_that_static_attribute_is_shared_across_all_instances() {
        // GIVEN: On remet le compteur à zero pour ce test
        Hero.totalHeroesCreated = 0;

        // WHEN: On crée deux instances différentes
        Hero batman = new Hero("Batman", "Bruce Wayne", "DC");
        Hero spiderman = new Hero("Spiderman", "Peter Parker", "Marvel");

        // THEN: Le compteur n'appartient ni à batman, ni à sipderman, mais à la classe Hero
        // Les deux instances voient la même valeur (2)
        assertThat(Hero.totalHeroesCreated).isEqualTo(2);
        assertThat(batman.totalHeroesCreated).isEqualTo(2);
        assertThat(spiderman.totalHeroesCreated).isEqualTo(2);
    }

    @Test
    public void should_demonstrate_final_and_private_compiler_restrictions(){
        Hero ironman = new Hero("Iron Man", "Tony Stark", "Marvel");

        // 1. Test du mot clé 'final'
        assertThat(ironman.universe).isEqualTo("Marvel");

        // Si on decommente la ligne suivante, le compilateur va hurler "secretIdentity has private access in Hero"
        // String secret = ironman.secretIdentity;

        // La seule façon de lire une variable private est d'utiliser une méthode public (Getter)
        assertThat(ironman.getSecretIdentity()).isEqualTo("Tony Stark");
    }

    @Test
    public void should_prove_that_records_are_immutable_by_default(){
        // GIVEN: Un record Java 21
        HeroRecord superman = new HeroRecord("Superman", "DC");

        // THEN: Les getters n'ont pas le préfixe "get" ce sont juste des noms de variables
        assertThat(superman.name()).isEqualTo("Superman");
        assertThat(superman.universe()).isEqualTo("DC");

        // Et comme tout est private final dans un record, ceci est impossible
        // superman.name = "Batman";
    }
}
