package com.narxoz.rpg.composite;

public interface CombatNode {
    String getName();
    int getAttackPower();
    void takeDamage(int amount);
    boolean isAlive();
    void printTree(String indent);
}