package com.narxoz.rpg.command;

import com.narxoz.rpg.arena.ArenaFighter;

public class HealCommand implements ActionCommand {
    private ArenaFighter hero;
    private int healAmount = 30;
    private int actualHealApplied;

    public HealCommand(ArenaFighter hero) { this.hero = hero; }

    @Override
    public void execute() {
        if (hero.getPotions() > 0) {
            int hpBefore = hero.getHp();
            hero.heal(healAmount);
            actualHealApplied = hero.getHp() - hpBefore;
            hero.consumePotion();
            System.out.println("-> [Command] Healed for " + actualHealApplied + " HP. Potions left: " + hero.getPotions());
        } else {
            System.out.println("-> [Command] No potions left!");
        }
    }

    @Override
    public void undo() {
        hero.takeDamage(actualHealApplied);
        System.out.println("-> [Command] Heal undone: -" + actualHealApplied + " HP.");
    }

    @Override
    public String getDescription() { return "Heal (30 HP)"; }
}