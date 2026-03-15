package com.narxoz.rpg.character;

public class Archer implements Character {
    private String name = "Archer";
    private int hp = 100;
    private int mana = 60;
    private int strength = 15;
    private int intelligence = 15;

    @Override
    public void getStats() {
        System.out.println("--- " + name + " Stats ---");
        System.out.println("HP: " + hp + " | Mana: " + mana + " | STR: " + strength + " | INT: " + intelligence);
    }

    @Override
    public void useSpecialAbility() {
        System.out.println("Rapid fire that hits multiple targets!");
    }
}