package com.narxoz.rpg.facade;

import com.narxoz.rpg.facade.services.*;
import com.narxoz.rpg.decorator.AttackAction;

public class DungeonFacade {
    private final PreparationService preparation;
    private final BattleService battle;
    private final RewardService rewards;

    public DungeonFacade() {
        this.preparation = new PreparationService();
        this.battle = new BattleService();
        this.rewards = new RewardService();
    }

    public void runDungeon(String heroName, AttackAction chosenAttack) {
        System.out.println("\n--- FACADE: STARTING ADVENTURE ---");
        preparation.prepareHero(heroName);
        battle.performBattle(heroName, chosenAttack);
        rewards.distributeRewards();
        System.out.println("--- FACADE: ADVENTURE COMPLETE ---\n");
    }
}