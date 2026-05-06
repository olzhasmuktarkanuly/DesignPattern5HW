package com.narxoz.rpg.combatant;

public class HeroMemento {
    private final int hp;
    private final int mana;
    private final int gold;

    HeroMemento(int hp, int mana, int gold) {
        this.hp = hp;
        this.mana = mana;
        this.gold = gold;
    }

    int getHp() { return hp; }
    int getMana() { return mana; }
    int getGold() { return gold; }
}