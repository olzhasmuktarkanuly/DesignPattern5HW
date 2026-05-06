package com.narxoz.rpg.artifact;

public class WeightCalculator implements ArtifactVisitor {
    private double totalWeight = 0;

    @Override
    public void visit(Weapon weapon) { totalWeight += 5.0; }
    @Override
    public void visit(Potion potion) { totalWeight += 0.5; }
    @Override
    public void visit(Scroll scroll) { totalWeight += 0.2; }
    @Override
    public void visit(Ring ring) { totalWeight += 0.1; }
    @Override
    public void visit(Armor armor) { totalWeight += 15.0; }

    public double getTotalWeight() { return totalWeight; }
}