package com.narxoz.rpg.tournament;

import com.narxoz.rpg.arena.*;
import com.narxoz.rpg.chain.*;
import com.narxoz.rpg.command.*;

public class TournamentEngine {

    public void runTournament(ArenaFighter hero, ArenaOpponent opponent) {
        System.out.println("=== GRAND ARENA TOURNAMENT: " + hero.getName() + " VS " + opponent.getName() + " ===\n");

        DefenseHandler chain = new DodgeHandler();
        DefenseHandler block = new BlockHandler(hero.getBlockRating() / 100.0);
        DefenseHandler armor = new ArmorHandler();
        DefenseHandler hp = new HpHandler();

        chain.setNext(block);
        block.setNext(armor);
        armor.setNext(hp);

        ActionQueue actionQueue = new ActionQueue();
        int round = 1;

        while (hero.isAlive() && opponent.isAlive() && round <= 20) {
            System.out.println("--- Round " + round + " ---");

            actionQueue.enqueue(new AttackCommand(opponent, hero.getAttackPower()));

            if (hero.getHp() < 50) actionQueue.enqueue(new HealCommand(hero));
            if (hero.getHp() < 30) actionQueue.enqueue(new DefendCommand(hero));

            System.out.println("Hero queue: " + actionQueue.getCommandDescriptions());
            actionQueue.executeAll();

            if (opponent.isAlive()) {
                System.out.println(opponent.getName() + " attacks with power " + opponent.getAttackPower() + "!");
                chain.handle(opponent.getAttackPower(), hero);
            }

            System.out.println();
            round++;
        }

        System.out.println("=== TOURNAMENT ENDED ===");
        if (hero.isAlive()) System.out.println("WINNER: HERO (" + hero.getHp() + " HP left)");
        else System.out.println("WINNER: " + opponent.getName());
    }
}