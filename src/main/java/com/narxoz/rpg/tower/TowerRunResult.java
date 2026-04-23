package com.narxoz.rpg.tower;

public class TowerRunResult {
    private int floorsCleared;
    private long survivors;

    public TowerRunResult(int floorsCleared, long survivors) {
        this.floorsCleared = floorsCleared;
        this.survivors = survivors;
    }

    public int getFloorsCleared() { return floorsCleared; }
    public long getSurvivors() { return survivors; }
}