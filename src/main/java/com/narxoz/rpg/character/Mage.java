package com.narxoz.rpg.character;

public class Mage implements Character {
    private String name = "Mage";
    private int hp = 70;
    private int mana = 150;
    private int strength = 5;
    private int intelligence = 30;

    @Override
    public void getStats() {
        System.out.println("--- " + name + " Stats ---");
        System.out.println("HP: " + hp + " | Mana: " + mana + " | STR: " + strength + " | INT: " + intelligence);
    }

    @Override
    public void useSpecialAbility() {
        System.out.println("Deals massive area magic damage!");
    }
}