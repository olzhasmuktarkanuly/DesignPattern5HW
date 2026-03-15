package com.narxoz.rpg.character;

public class Warrior implements Character {
    private String name = "Warrior";
    private int hp = 150;
    private int mana = 20;
    private int strength = 25;
    private int intelligence = 5;

    @Override
    public void getStats() {
        System.out.println("--- " + name + " Stats ---");
        System.out.println("HP: " + hp + " | Mana: " + mana + " | STR: " + strength + " | INT: " + intelligence);
    }

    @Override
    public void useSpecialAbility() {
        System.out.println("Deals physical damage and stuns the enemy!");
    }
}