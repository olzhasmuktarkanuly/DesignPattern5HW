package com.narxoz.rpg.state;

import com.narxoz.rpg.combatant.Hero;

public class PoisonState implements HeroState {
    private int duration = 3;

    public String getName() { return "Poisoned"; }
    public int modifyOutgoingDamage(int p) { return (int)(p * 0.8); }
    public int modifyIncomingDamage(int d) { return d; }
    public void onTurnStart(Hero h) {
        h.setHp(h.getHp() - 10);
        duration--;
        System.out.println("-> [Poison] " + h.getName() + " suffers 10 poison damage. Left: " + duration);
    }
    public void onTurnEnd(Hero h) {
        if (duration <= 0) h.setState(new NeutralState());
    }
    public boolean canAct() { return true; }
}