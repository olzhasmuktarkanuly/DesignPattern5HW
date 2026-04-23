package com.narxoz.rpg.floor;

public class FloorResult {
    private boolean success;
    private String message;

    public FloorResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
}