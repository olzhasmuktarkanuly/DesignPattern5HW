package com.narxoz.rpg.artifact;

public class Potion extends Artifact {
    private int healAmount;

    public Potion(String name, int baseValue, int healAmount) {
        super(name, baseValue);
        this.healAmount = healAmount;
    }

    public int getHealAmount() { return healAmount; }

    @Override
    public void accept(ArtifactVisitor visitor) {
        visitor.visit(this);
    }
}