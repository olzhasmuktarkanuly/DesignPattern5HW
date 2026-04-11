package com.narxoz.rpg.strategy;
public class DefensiveStrategy implements CombatStrategy {
    public int calculateDamage(int p) { return (int)(p * 0.6); }
    public int calculateDefense(int d) { return (int)(d * 0.4); }
    public String getName() { return "Defensive"; }
}