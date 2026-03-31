package com.narxoz.rpg.enemy;

public class Goblin extends Enemy {
    public Goblin() {
        this.name = "Basic Goblin";
    }

    @Override
    public void displayInfo() {
        System.out.println("[Goblin] Name: " + name + ", HP: " + health + ", DMG: " + damage);
    }
}