package com.narxoz.rpg.arena;

public class ArenaFighter {
    private String name;
    private int hp;
    private int maxHp;
    private int attackPower;
    private double dodgeChance;
    private int blockRating;
    private int armor;
    private int potions;

    public ArenaFighter(String name, int maxHp, int attackPower, double dodgeChance, int blockRating, int armor, int potions) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.attackPower = attackPower;
        this.dodgeChance = dodgeChance;
        this.blockRating = blockRating;
        this.armor = armor;
        this.potions = potions;
    }

    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getMaxHp() { return maxHp; }
    public int getAttackPower() { return attackPower; }
    public double getDodgeChance() { return dodgeChance; }
    public void setDodgeChance(double dodgeChance) { this.dodgeChance = dodgeChance; }
    public int getBlockRating() { return blockRating; }
    public int getArmor() { return armor; }
    public int getPotions() { return potions; }
    public void consumePotion() { this.potions--; }

    public void takeDamage(int amount) {
        this.hp -= amount;
        if (this.hp < 0) this.hp = 0;
    }

    public void heal(int amount) {
        this.hp += amount;
        if (this.hp > maxHp) this.hp = maxHp;
    }

    public boolean isAlive() { return hp > 0; }
}