package com.sikaseal.java.fundamentals.attributes;

public class Hero {
    // 1. VISIBILITE
    public String publicName; // Visible partout
    protected int protectedHealth; // Visible dans le package et par les enfants
    int packagePrivateLevel; // Visible uniquement dans ce package
    private String secretIdentity; // Visible uniquement dans cette classe

    // 2. COMPORTEMENT
    public final String universe; // Inchageable une fois défini
    public static int totalHeroesCreated = 0; // Partagé par toutes les instances de la classe Hero

    // 3. LA CONSTANTE ABSOLUE
    public static final int MAX_LEVEL = 100;

    // Constructeur
    public Hero(String publicName, String secretIdentity, String universe) {
        this.publicName = publicName;
        this.secretIdentity = secretIdentity;
        this.universe = universe;

        // A chaque fois qu'un héro est créé on augmente le compteur global
        totalHeroesCreated++;
    }

    // Un getter pour lire la donnée privée (Encapsulation)
    public String getSecretIdentity() {
        return secretIdentity;
    }
}
