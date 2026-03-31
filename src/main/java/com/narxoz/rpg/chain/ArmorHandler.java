package com.narxoz.rpg.chain;

import com.narxoz.rpg.arena.ArenaFighter;

public class ArmorHandler extends DefenseHandler {
    @Override
    public void handle(int incomingDamage, ArenaFighter target) {
        int reducedDamage = Math.max(0, incomingDamage - target.getArmor());
        System.out.println("-> [ARMOR] Armor deflected " + (incomingDamage - reducedDamage) + " damage. Remaining: " + reducedDamage);
        passToNext(reducedDamage, target);
    }
}