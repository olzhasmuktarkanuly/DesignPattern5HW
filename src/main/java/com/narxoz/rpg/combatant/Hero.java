package com.narxoz.rpg.combatant;

import com.narxoz.rpg.strategy.CombatStrategy;
import com.narxoz.rpg.strategy.BalancedStrategy;

public class Hero {
    private String name;
    private int hp, maxHp, attackPower, defense;
    private CombatStrategy strategy;

    public Hero(String name, int maxHp, int attackPower, int defense) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.attackPower = attackPower;
        this.defense = defense;
        this.strategy = new BalancedStrategy();
    }

    // Геттеры и сеттеры
    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getMaxHp() { return maxHp; }
    public int getAttackPower() { return attackPower; }
    public int getDefense() { return defense; }
    public CombatStrategy getStrategy() { return strategy; }
    public void setStrategy(CombatStrategy strategy) { this.strategy = strategy; }

    public void takeDamage(int amount) {
        int reduced = strategy.calculateDefense(amount);
        this.hp = Math.max(0, this.hp - reduced);
    }

    public void heal(int amount) { this.hp = Math.min(maxHp, this.hp + amount); }
    public boolean isAlive() { return hp > 0; }
}