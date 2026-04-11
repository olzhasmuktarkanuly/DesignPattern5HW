package com.narxoz.rpg.observer;

public class GameEvent {
    private final GameEventType type;
    private final String sourceName;
    private final double value;

    public GameEvent(GameEventType type, String sourceName, double value) {
        this.type = type;
        this.sourceName = sourceName;
        this.value = value;
    }

    public GameEventType getType() { return type; }
    public String getSourceName() { return sourceName; }
    public double getValue() { return value; }
}