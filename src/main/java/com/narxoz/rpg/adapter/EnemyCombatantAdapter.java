package com.narxoz.rpg.adapter;

import com.narxoz.rpg.battle.Combatant;
import com.narxoz.rpg.enemy.Enemy;

public class EnemyCombatantAdapter implements Combatant {
    private Enemy enemy;

    public EnemyCombatantAdapter(Enemy enemy) {
        this.enemy = enemy;
    }

    @Override
    public String getName() {
        return enemy.getName();
    }

    @Override
    public int getAttackPower() {
        return 15;
    }

    @Override
    public void takeDamage(int damage) {

        int currentHP = 100;
        currentHP -= damage;
        System.out.println(getName() + " (Enemy) hit for " + damage + ". HP left: " + currentHP);
    }

    @Override
    public boolean isAlive() {
        return true;
    }
}