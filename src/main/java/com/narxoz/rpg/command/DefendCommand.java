package com.narxoz.rpg.command;

import com.narxoz.rpg.arena.ArenaFighter;

public class DefendCommand implements ActionCommand {
    private ArenaFighter hero;
    private double dodgeBoost = 0.20;

    public DefendCommand(ArenaFighter hero) { this.hero = hero; }

    @Override
    public void execute() {
        hero.setDodgeChance(hero.getDodgeChance() + dodgeBoost);
        System.out.println("-> [Command] Defense stance! Dodge chance increased by 20%.");
    }

    @Override
    public void undo() {
        hero.setDodgeChance(hero.getDodgeChance() - dodgeBoost);
        System.out.println("-> [Command] Defense stance undone.");
    }

    @Override
    public String getDescription() { return "Defend (+20% Dodge)"; }
}