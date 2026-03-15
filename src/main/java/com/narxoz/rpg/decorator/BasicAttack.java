package com.narxoz.rpg.decorator;

public class BasicAttack implements AttackAction {
    @Override
    public String getDescription() { return "Basic Sword Strike"; }
    @Override
    public int getDamage() { return 15; }
}