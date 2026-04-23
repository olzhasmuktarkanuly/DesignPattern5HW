package com.narxoz.rpg.tower;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.floor.*;
import java.util.*;

public class TowerRunner {
    public TowerRunResult run(List<Hero> party, List<TowerFloor> floors) {
        int cleared = 0;
        for (TowerFloor f : floors) {
            for (Hero h : party) h.startTurn();
            FloorResult r = f.explore(party);
            for (Hero h : party) h.endTurn();

            if (!r.isSuccess()) break;
            cleared++;
        }
        return new TowerRunResult(cleared, party.stream().filter(h -> h.getHp() > 0).count());
    }
}