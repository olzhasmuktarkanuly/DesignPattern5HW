package com.narxoz.rpg.floor;

import com.narxoz.rpg.combatant.Hero;
import java.util.List;

public abstract class TowerFloor {

    public final FloorResult explore(List<Hero> party) {
        announce();
        setup(party);
        FloorResult r = resolveChallenge(party);

        if (shouldAwardLoot(r)) {
            awardLoot(party, r);
        }

        cleanup(party);
        return r;
    }

    protected void announce() {
        System.out.println(">> Entering a mysterious floor...");
    }

    protected boolean shouldAwardLoot(FloorResult r) {
        return r.isSuccess();
    }

    protected void cleanup(List<Hero> party) {
    }

    protected abstract void setup(List<Hero> party);
    protected abstract FloorResult resolveChallenge(List<Hero> party);
    protected abstract void awardLoot(List<Hero> party, FloorResult r);
}