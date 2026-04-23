package com.narxoz.rpg.state;

import com.narxoz.rpg.combatant.Hero;

public class BerserkState implements HeroState {
    public String getName() { return "Berserk"; }
    public int modifyOutgoingDamage(int p) { return p * 2; }
    public int modifyIncomingDamage(int d) { return (int)(d * 1.5); }
    public void onTurnStart(Hero h) {}
    public void onTurnEnd(Hero h) {
        if (h.getHp() > h.getMaxHp() * 0.5) h.setState(new NeutralState());
    }
    public boolean canAct() { return true; }
}