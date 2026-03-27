package com.sikaseal.java.fundamentals.polymorphism;

public class Healer {

    // Méthode 1 : Sans paramètre
    public String castHeal(){
        return "Soin de base (10HP)";
    }

    // Méthode 2 : Avec un entier (Surcharge !)
    public  String castHeal(int power){
        return "Soin puissant (" + power + "HP)";
    }

    // Méthode 3 : Avec un texte (Surchage !)
    public String castHeal(String potionName){
        return "Utilise la potion : " + potionName;
    }
}
