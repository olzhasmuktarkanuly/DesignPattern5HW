package com.narxoz.rpg.strategy;
public class AggressiveStrategy implements CombatStrategy {
    public int calculateDamage(int p) { return (int)(p * 1.5); }
    public int calculateDefense(int d) { return (int)(d * 1.5); }
    public String getName() { return "Aggressive"; }
}