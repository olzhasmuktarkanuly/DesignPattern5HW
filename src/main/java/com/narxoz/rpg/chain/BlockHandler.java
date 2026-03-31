package com.narxoz.rpg.chain;

import com.narxoz.rpg.arena.ArenaFighter;

public class BlockHandler extends DefenseHandler {
    private double blockPercent;

    public BlockHandler(double blockPercent) {
        this.blockPercent = blockPercent;
    }

    @Override
    public void handle(int incomingDamage, ArenaFighter target) {
        int reducedDamage = incomingDamage - (int)(incomingDamage * blockPercent);
        System.out.println("-> [BLOCK] Shield absorbed " + (incomingDamage - reducedDamage) + " damage. Remaining: " + reducedDamage);
        passToNext(reducedDamage, target);
    }
}