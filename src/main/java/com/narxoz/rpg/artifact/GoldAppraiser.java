package com.narxoz.rpg.artifact;

public class GoldAppraiser implements ArtifactVisitor {
    private int totalValue = 0;

    @Override
    public void visit(Weapon weapon) { totalValue += weapon.getBaseValue() + (weapon.getDamage() * 2); }
    @Override
    public void visit(Potion potion) { totalValue += potion.getBaseValue(); }
    @Override
    public void visit(Scroll scroll) { totalValue += scroll.getBaseValue() * 3; }
    @Override
    public void visit(Ring ring) { totalValue += ring.getBaseValue() * 5; }
    @Override
    public void visit(Armor armor) { totalValue += armor.getBaseValue() + (armor.getDefense() * 3); }

    public int getTotalValue() { return totalValue; }
}