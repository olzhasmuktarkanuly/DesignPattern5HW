package com.narxoz.rpg.arena;

public class ArenaOpponent {
    private String name;
    private int hp;
    private int attackPower;

    public ArenaOpponent(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
    }

    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getAttackPower() { return attackPower; }
    public boolean isAlive() { return hp > 0; }

    public int takeDamage(int amount) {
        int actualDamage = Math.min(this.hp, amount);
        this.hp -= actualDamage;
        return actualDamage;
    }

    public void heal(int amount) {
        this.hp += amount;
    }
}