package com.sikaseal.java.fundamentals.objectclass;

import java.util.Objects;

public class Potion implements Cloneable {
    private String name;
    private int power;

    public Potion (String name, int power){
        this.name = name;
        this.power = power;
    }

    // 1. toString()
    @Override
    public String toString(){
        return "Potion de " + name + "; Puissance: " + power;
    }

    // 2. equals()
    @Override
    public boolean equals(Object o){
        if(this == o) return true; // On se demande ici es ce exactement la même adresse mémoire ?
        if(o == null || getClass() != o.getClass()) return false; // On se demande si les deux objets à comparer sont de la même famille

        Potion potion = (Potion) o; // On cast l'objet o en Potion etant donné qu'il est de la meme famille
        return power == potion.power && Objects.equals(name, potion.name);
    }

    // 3. hashCode()
    @Override
    public int hashCode(){
        return Objects.hash(name, power);
    }

    // 4. clone()
    @Override
    public Potion clone() throws CloneNotSupportedException {
        return (Potion) super.clone();
    }
}
