package com.narxoz.rpg.combatant;

public class Monster {
    private String name;
    private int hp;
    private int attackPower;

    public Monster(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
    }

    public void takeDamage(int amount) {
        this.hp -= amount;
        if (this.hp < 0) this.hp = 0;
    }

    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getAttackPower() { return attackPower; }
}