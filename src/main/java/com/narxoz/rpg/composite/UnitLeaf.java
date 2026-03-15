package com.narxoz.rpg.composite;

public class UnitLeaf implements CombatNode {
    private String name;
    private int health;
    private int attackPower;

    public UnitLeaf(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    @Override
    public String getName() { return name; }

    @Override
    public int getAttackPower() { return isAlive() ? attackPower : 0; }

    @Override
    public void takeDamage(int amount) {
        this.health -= amount;
        if (health < 0) health = 0;
        System.out.println("  [Unit] " + name + " received " + amount + " damage. HP: " + health);
    }

    @Override
    public boolean isAlive() { return health > 0; }

    @Override
    public void printTree(String indent) {
        System.out.println(indent + " - " + name + (isAlive() ? "" : " (DEAD)"));
    }
}