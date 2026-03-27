package com.sikaseal.java.fundamentals.inheritance;

public abstract class GameCharacter {
    protected String name;
    protected int health;

    public GameCharacter(String name, int health) {
        this.name = name;
        this.health = health;
    }

    // Méthode abstraite : Le parent force les enfants à l'écrire eux-mêmes
    public abstract String attack();

    // Méthode finale : Le parent INTERDIT aux enfants de changer la façon de prendre des dégâts
    public final void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) this.health = 0;
    }

    public int getHealth() { return health;}
}
