package com.narxoz.rpg.floor;

import com.narxoz.rpg.combatant.*;
import com.narxoz.rpg.state.PoisonState;
import java.util.List;

public class BattleFloor extends TowerFloor {
    private Monster monster;

    public void setup(List<Hero> party) {
        monster = new Monster("Tower Guardian", 150, 30);
    }

    public FloorResult resolveChallenge(List<Hero> party) {
        System.out.println("Fighting " + monster.getName());
        while (monster.getHp() > 0 && party.stream().anyMatch(Hero::isAlive)) {
            for (Hero h : party) {
                if (h.isAlive() && h.canAct()) {
                    monster.takeDamage(h.getAttackPower());
                    if (Math.random() < 0.2) h.setState(new PoisonState());
                }
            }
            if (monster.getHp() > 0) {
                party.get(0).takeDamage(monster.getAttackPower());
            }
        }
        return new FloorResult(monster.getHp() <= 0, "Battle won");
    }

    public void awardLoot(List<Hero> party, FloorResult r) {
        System.out.println("Victory loot awarded!");
    }
}