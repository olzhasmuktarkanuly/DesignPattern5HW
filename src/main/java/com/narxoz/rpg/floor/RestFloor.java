package com.narxoz.rpg.floor;

import com.narxoz.rpg.combatant.Hero;
import java.util.List;

public class RestFloor extends TowerFloor {
    public void announce() {
        System.out.println(">> A peaceful fountain room. Time to rest.");
    }

    public void setup(List<Hero> party) {}

    public FloorResult resolveChallenge(List<Hero> party) {
        for (Hero h : party) h.setHp(h.getMaxHp());
        return new FloorResult(true, "Restored HP");
    }

    public boolean shouldAwardLoot(FloorResult r) { return false; }

    public void awardLoot(List<Hero> party, FloorResult r) {}
}