package com.sikaseal.java.fundamentals.inheritance;

public class Dragon extends GameCharacter implements Flyable, Swimmable {
    public Dragon(String name) {
        super(name, 100);
    }

    // On est OBLIGÉ d'écrire le code de la méthode abstraite du parent
    @Override
    public String attack() {
        return "Crache du feu !";
    }

    // On est OBLIGÉ d'écrire le code du contrat Flyable
    @Override
    public String fly() {
        return "Bat de ses grandes ailes";
    }

    // On est OBLIGÉ d'écrire le code du contrat Swimmable
    @Override
    public String swim() {
        return "Nage comme un reptile";
    }

    // DÉCOMMENTE CECI : Le compilateur va te bloquer car takeDamage() est 'final' dans le parent !
    /*
    @Override
    public void takeDamage(int damage) {
        // Le dragon essaie de tricher et d'annuler les dégâts
        this.health -= 0;
    }
    */
}
