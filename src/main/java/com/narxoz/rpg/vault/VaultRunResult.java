package com.narxoz.rpg.vault;

public class VaultRunResult {
    private boolean successfulRun;
    private int rewindsUsed;

    public VaultRunResult(boolean successfulRun, int rewindsUsed) {
        this.successfulRun = successfulRun;
        this.rewindsUsed = rewindsUsed;
    }

    public boolean isSuccessfulRun() { return successfulRun; }
    public int getRewindsUsed() { return rewindsUsed; }
}