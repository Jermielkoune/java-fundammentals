package com.sikaseal.java.fundamentals.types;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TypeTest {
    //1. Démonstration des valeurs par défaut des primitives
    int primitiveInt; // Par défaut : 0
    Integer objectInt; // Par défaut : null

    @Test
    public void should_prove_primitives_cannot_be_null(){
        // THEN: La primitive a une valeur par défaut, l'objet est nul par défaut
        assertThat(primitiveInt).isEqualTo(0);
        assertThat(objectInt).isNull();
    }

    @Test
    public void should_demonstrate_autoboxing() {
        // GIVEN: Un type primitif
        int rawMaterial = 42;

        //WHEN: On le place dans un type objet (Wrapper)
        Integer smartBox = rawMaterial; // C'est l'autoboxing ! Java fait "new Integer (42)" en coulisse

        // THEN: Ils sont mathématiquement égaux
        assertThat(smartBox).isEqualTo(42);

        // Et maintenant on a accès aux méthodes d'Objet !
        assertThat(smartBox.toString()).isEqualTo("42");
    }

    @Test
    public void should_prove_generics_provide_type_safety(){
        // GIVEN: Une liste paramétrée (Parameterized type)
        // Note: En Java moderne, on utilise l'opérateur Diamant "<>" à droite
        List<String> names = new ArrayList<>();

        // WHEN
        names.add("Alice");
        names.add("Bob");

        // DECOMMENTE CETTE LIGNE : Le compilateur va bloquer la comilation immédiatement.
        // C'est la magie de la sécurité des types !
        // names.add(42);

        // THEN : Quand on récupère l'élement, on n'a pas besoin de faire de cast
        String firstPerson = names.get(0);
        assertThat(firstPerson.toUpperCase()).isEqualTo("ALICE");
    }
}
