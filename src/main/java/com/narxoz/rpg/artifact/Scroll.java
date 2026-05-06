package com.narxoz.rpg.artifact;

public class Scroll extends Artifact {
    private String spell;

    public Scroll(String name, int baseValue, String spell) {
        super(name, baseValue);
        this.spell = spell;
    }

    public String getSpell() { return spell; }

    @Override
    public void accept(ArtifactVisitor visitor) {
        visitor.visit(this);
    }
}