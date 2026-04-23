package com.narxoz.rpg.floor;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.state.PoisonState;
import java.util.List;

public class TrapFloor extends TowerFloor {
    public void setup(List<Hero> party) {}

    public FloorResult resolveChallenge(List<Hero> party) {
        for (Hero h : party) {
            h.takeDamage(10);
            h.setState(new PoisonState());
        }
        return new FloorResult(true, "Poison Trap Triggered");
    }

    public void awardLoot(List<Hero> party, FloorResult r) {
        System.out.println("Found a shiny gem behind the trap.");
    }
}