package com.narxoz.rpg.artifact;

public class CurseDetector implements ArtifactVisitor {
    private void check(Artifact artifact) {
        if (artifact.getName().toLowerCase().contains("cursed")) {
            System.out.println("[WARNING] " + artifact.getName() + " is CURSED!");
        } else {
            System.out.println(artifact.getName() + " is clean.");
        }
    }

    @Override
    public void visit(Weapon weapon) { check(weapon); }
    @Override
    public void visit(Potion potion) { check(potion); }
    @Override
    public void visit(Scroll scroll) { check(scroll); }
    @Override
    public void visit(Ring ring) { check(ring); }
    @Override
    public void visit(Armor armor) { check(armor); }
}