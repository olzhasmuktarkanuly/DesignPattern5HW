package com.narxoz.rpg.artifact;

public class Ring extends Artifact {
    private String magicEffect;

    public Ring(String name, int baseValue, String magicEffect) {
        super(name, baseValue);
        this.magicEffect = magicEffect;
    }

    public String getMagicEffect() { return magicEffect; }

    @Override
    public void accept(ArtifactVisitor visitor) {
        visitor.visit(this);
    }
}