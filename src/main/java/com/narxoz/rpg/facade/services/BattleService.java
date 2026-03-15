package com.narxoz.rpg.facade.services;

import com.narxoz.rpg.decorator.AttackAction;

public class BattleService {
    public void performBattle(String heroName, AttackAction attack) {
        System.out.println("[Battle] A wild Dungeon Boss appears!");
        System.out.println("[Battle] " + heroName + " uses: " + attack.getDescription());
        System.out.println("[Battle] Total damage dealt: " + attack.getDamage());
        System.out.println("[Battle] Boss defeated!");
    }
}