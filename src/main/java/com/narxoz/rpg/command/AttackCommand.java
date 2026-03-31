package com.narxoz.rpg.command;

import com.narxoz.rpg.arena.ArenaOpponent;

public class AttackCommand implements ActionCommand {
    private ArenaOpponent opponent;
    private int attackPower;
    private int damageDealt;

    public AttackCommand(ArenaOpponent opponent, int attackPower) {
        this.opponent = opponent;
        this.attackPower = attackPower;
    }

    @Override
    public void execute() {
        damageDealt = opponent.takeDamage(attackPower);
        System.out.println("-> [Command] Attack executed: -" + damageDealt + " HP to opponent.");
    }

    @Override
    public void undo() {
        opponent.heal(damageDealt);
        System.out.println("-> [Command] Attack undone: opponent restored " + damageDealt + " HP.");
    }

    @Override
    public String getDescription() { return "Attack (" + attackPower + " power)"; }
}