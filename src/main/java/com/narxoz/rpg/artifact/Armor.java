package com.narxoz.rpg.artifact;

public class Armor extends Artifact {
    private int defense;

    public Armor(String name, int baseValue, int defense) {
        super(name, baseValue);
        this.defense = defense;
    }

    public int getDefense() { return defense; }

    @Override
    public void accept(ArtifactVisitor visitor) {
        visitor.visit(this);
    }
}