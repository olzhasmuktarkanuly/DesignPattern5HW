package com.narxoz.rpg.state;

import com.narxoz.rpg.combatant.Hero;

public class NeutralState implements HeroState {
    public String getName() { return "Neutral"; }
    public int modifyOutgoingDamage(int p) { return p; }
    public int modifyIncomingDamage(int d) { return d; }
    public void onTurnStart(Hero h) {}
    public void onTurnEnd(Hero h) {
        if (h.getHp() < h.getMaxHp() * 0.3) {
            h.setState(new BerserkState());
        }
    }
    public boolean canAct() { return true; }
}