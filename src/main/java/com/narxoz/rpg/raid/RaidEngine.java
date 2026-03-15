package com.narxoz.rpg.raid;

import com.narxoz.rpg.composite.CombatNode;

public class RaidEngine {
    private static RaidEngine instance;

    private RaidEngine() {}

    public static RaidEngine getInstance() {
        if (instance == null) instance = new RaidEngine();
        return instance;
    }

    public void runRaid(CombatNode teamA, CombatNode teamB) {
        System.out.println("=== RAID START: " + teamA.getName() + " VS " + teamB.getName() + " ===\n");
        int round = 1;

        while (teamA.isAlive() && teamB.isAlive() && round <= 10) {
            System.out.println("--- Round " + round + " ---");

            if (teamA.isAlive()) {
                int damage = teamA.getAttackPower();
                System.out.println(teamA.getName() + " attacks for " + damage);
                teamB.takeDamage(damage);
            }


            if (teamB.isAlive()) {
                int damage = teamB.getAttackPower();
                System.out.println(teamB.getName() + " counter-attacks for " + damage);
                teamA.takeDamage(damage);
            }

            round++;
            System.out.println();
        }

        System.out.println("=== RAID OVER ===");
        if (teamA.isAlive()) System.out.println("WINNER: " + teamA.getName());
        else if (teamB.isAlive()) System.out.println("WINNER: " + teamB.getName());
        else System.out.println("MUTUAL DESTRUCTION!");
    }
}