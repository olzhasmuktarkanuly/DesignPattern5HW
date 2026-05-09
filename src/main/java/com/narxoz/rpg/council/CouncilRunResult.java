package com.narxoz.rpg.council;

public class CouncilRunResult {
    private boolean success;
    private int questsPlanned;

    public CouncilRunResult(boolean success, int questsPlanned) {
        this.success = success;
        this.questsPlanned = questsPlanned;
    }

    public boolean isSuccess() { return success; }
    public int getQuestsPlanned() { return questsPlanned; }
}