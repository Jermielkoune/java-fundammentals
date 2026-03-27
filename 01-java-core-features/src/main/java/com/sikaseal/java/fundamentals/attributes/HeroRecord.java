package com.sikaseal.java.fundamentals.attributes;

/**
 * En une seule ligne, Java génère :
 * - Des attributs private final
 * - Un constructeur
 * - Les getters
 * - Les methodes equals(), hashCode() et toString()
 * */
public record HeroRecord (String name, String universe){
}
