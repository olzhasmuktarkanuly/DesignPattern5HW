package com.narxoz.rpg.battle;

import java.util.List;
import java.util.ArrayList;

public class BattleEngine {
    private static BattleEngine instance;

    private BattleEngine() {}

    public static BattleEngine getInstance() {
        if (instance == null) {
            instance = new BattleEngine();
        }
        return instance;
    }

    public void runEncounter(List<Combatant> heroes, List<Combatant> enemies) {
        System.out.println("=== THE BATTLE BEGINS ===");

        while (!heroes.isEmpty() && !enemies.isEmpty()) {
            for (Combatant hero : new ArrayList<>(heroes)) {
                if (!enemies.isEmpty()) {
                    Combatant target = enemies.get(0);
                    target.takeDamage(hero.getAttackPower());
                    if (!target.isAlive()) enemies.remove(target);
                }
            }


            for (Combatant enemy : new ArrayList<>(enemies)) {
                if (!heroes.isEmpty()) {
                    Combatant target = heroes.get(0);
                    target.takeDamage(enemy.getAttackPower());
                    if (!target.isAlive()) heroes.remove(target);
                }
            }
        }

        System.out.println("=== BATTLE OVER ===");
        if (heroes.isEmpty()) System.out.println("ENEMIES WON!");
        else System.out.println("HEROES WON!");
    }
}