package com.narxoz.rpg.artifact;

public class EnchantmentScanner implements ArtifactVisitor {
    @Override
    public void visit(Weapon weapon) { System.out.println(weapon.getName() + " -> Magic Resonance: High"); }
    @Override
    public void visit(Potion potion) { System.out.println(potion.getName() + " -> Alchemical Traces: Present"); }
    @Override
    public void visit(Scroll scroll) { System.out.println(scroll.getName() + " -> Spell Power: " + scroll.getSpell()); }
    @Override
    public void visit(Ring ring) { System.out.println(ring.getName() + " -> Enchantment: " + ring.getMagicEffect()); }
    @Override
    public void visit(Armor armor) { System.out.println(armor.getName() + " -> Ward Strength: Moderate"); }
}