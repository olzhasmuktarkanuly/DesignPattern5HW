package com.narxoz.rpg.adapter;

import com.narxoz.rpg.battle.Combatant;
import com.narxoz.rpg.character.Character;

public class CharacterCombatantAdapter implements Combatant {
    private Character hero;
    private int health = 100;

    public CharacterCombatantAdapter(Character hero) {
        this.hero = hero;
    }

    @Override
    public String getName() {
        return hero.getClass().getSimpleName();
    }

    @Override
    public int getAttackPower() {

        return 20;
    }

    @Override
    public void takeDamage(int damage) {
        this.health -= damage;
        System.out.println(getName() + " took " + damage + " damage. Remaining HP: " + this.health);
    }

    @Override
    public boolean isAlive() {
        return this.health > 0;
    }
}