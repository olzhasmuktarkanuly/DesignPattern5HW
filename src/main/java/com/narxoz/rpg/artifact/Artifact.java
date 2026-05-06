package com.narxoz.rpg.artifact;

public abstract class Artifact {
    private String name;
    private int baseValue;

    public Artifact(String name, int baseValue) {
        this.name = name;
        this.baseValue = baseValue;
    }

    public String getName() { return name; }
    public int getBaseValue() { return baseValue; }

    public abstract void accept(ArtifactVisitor visitor);
}