package com.narxoz.rpg.chain;

import com.narxoz.rpg.arena.ArenaFighter;

public abstract class DefenseHandler {
    protected DefenseHandler next;

    public void setNext(DefenseHandler next) {
        this.next = next;
    }

    protected void passToNext(int incomingDamage, ArenaFighter target) {
        if (next != null) {
            next.handle(incomingDamage, target);
        }
    }

    public abstract void handle(int incomingDamage, ArenaFighter target);
}