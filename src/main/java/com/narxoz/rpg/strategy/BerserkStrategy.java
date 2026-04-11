package com.narxoz.rpg.strategy;

public class BerserkStrategy implements CombatStrategy {
    @Override
    public int calculateDamage(int basePower) {
        return basePower * 2;
    }

    @Override
    public int calculateDefense(int baseDefense) {
        return baseDefense;
    }

    @Override
    public String getName() {
        return "Berserk Mode (Phase 3)";
    }
}