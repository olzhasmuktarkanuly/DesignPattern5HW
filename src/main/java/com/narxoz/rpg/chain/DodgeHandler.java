package com.narxoz.rpg.chain;

import com.narxoz.rpg.arena.ArenaFighter;

public class DodgeHandler extends DefenseHandler {
    @Override
    public void handle(int incomingDamage, ArenaFighter target) {
        double roll = Math.random();
        if (roll < target.getDodgeChance()) {
            System.out.println("-> [DODGE] " + target.getName() + " dodged the attack! 0 damage taken.");
        } else {
            System.out.println("-> [DODGE FAILED] Attack connects.");
            passToNext(incomingDamage, target);
        }
    }
}