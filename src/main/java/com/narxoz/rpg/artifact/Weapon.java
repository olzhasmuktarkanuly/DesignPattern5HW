package com.narxoz.rpg.artifact;

public class Weapon extends Artifact {
    private int damage;

    public Weapon(String name, int baseValue, int damage) {
        super(name, baseValue);
        this.damage = damage;
    }

    public int getDamage() { return damage; }


    @Override
    public void accept(ArtifactVisitor visitor) {
        visitor.visit(this);
    }
}