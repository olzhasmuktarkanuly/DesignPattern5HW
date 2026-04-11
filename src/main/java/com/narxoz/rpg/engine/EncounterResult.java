package com.narxoz.rpg.engine;

public class EncounterResult {
    private String winner;
    private int totalRounds;
    private boolean bossDefeated;

    public EncounterResult(String winner, int totalRounds, boolean bossDefeated) {
        this.winner = winner;
        this.totalRounds = totalRounds;
        this.bossDefeated = bossDefeated;
    }

    public void printSummary() {
        System.out.println("\n--- ENCOUNTER SUMMARY ---");
        System.out.println("Winner: " + winner);
        System.out.println("Rounds: " + totalRounds);
        System.out.println("Boss Defeated: " + (bossDefeated ? "YES" : "NO"));
        System.out.println("--------------------------");
    }
}