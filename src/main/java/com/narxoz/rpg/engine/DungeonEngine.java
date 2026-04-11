package com.narxoz.rpg.engine;

import com.narxoz.rpg.combatant.*;
import com.narxoz.rpg.observer.*;
import java.util.List;

public class DungeonEngine {
    private final GamePublisher publisher;
    private final int MAX_ROUNDS = 50;

    public DungeonEngine(GamePublisher publisher) {
        this.publisher = publisher;
    }

    public EncounterResult startEncounter(List<Hero> heroes, DungeonBoss boss) {
        int round = 1;
        boolean bossDefeated = false;

        while (round <= MAX_ROUNDS) {
            System.out.println("\n--- Round " + round + " ---");

            for (Hero hero : heroes) {
                if (hero.isAlive() && boss.isAlive()) {
                    int damage = hero.getStrategy().calculateDamage(hero.getAttackPower());
                    boss.takeDamage(damage);

                    publisher.notifyObservers(new GameEvent(GameEventType.ATTACK_LANDED, hero.getName(), damage));
                }
            }

            if (!boss.isAlive()) {
                bossDefeated = true;
                publisher.notifyObservers(new GameEvent(GameEventType.BOSS_DEFEATED, boss.getName(), 0));
                break;
            }

            System.out.println(boss.getName() + " prepares a massive counter-attack!");
            for (Hero hero : heroes) {
                if (hero.isAlive()) {
                    int bossDamage = boss.getStrategy().calculateDamage(boss.getAttackPower());
                    hero.takeDamage(bossDamage);

                    publisher.notifyObservers(new GameEvent(GameEventType.ATTACK_LANDED, boss.getName(), bossDamage));

                    if (!hero.isAlive()) {
                        publisher.notifyObservers(new GameEvent(GameEventType.HERO_DIED, hero.getName(), 0));
                    } else if (hero.getHp() < hero.getMaxHp() * 0.3) {
                        publisher.notifyObservers(new GameEvent(GameEventType.HERO_LOW_HP, hero.getName(), hero.getHp()));
                    }
                }
            }

            boolean anyHeroAlive = false;
            for (Hero h : heroes) { if (h.isAlive()) anyHeroAlive = true; }

            if (!anyHeroAlive) {
                System.out.println("All heroes have fallen...");
                break;
            }

            round++;
        }

        String winner = bossDefeated ? "HEROES" : boss.getName();
        return new EncounterResult(winner, round, bossDefeated);
    }
}