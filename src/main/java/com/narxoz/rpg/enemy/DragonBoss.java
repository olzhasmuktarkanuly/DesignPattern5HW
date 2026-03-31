package com.narxoz.rpg.enemy;

public class DragonBoss extends Enemy {
    public DragonBoss() {
        this.name = "Ancient Dragon";
    }

    @Override
    public void displayInfo() {
        System.out.println("[BOSS DRAGON] " + name.toUpperCase() + " | HP: " + health + " | Attack: " + damage);
        System.out.println("-> Skills count: " + abilities.size());
    }
}