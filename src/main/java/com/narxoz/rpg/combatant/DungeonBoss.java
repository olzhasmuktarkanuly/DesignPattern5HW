package com.narxoz.rpg.combatant;

import com.narxoz.rpg.strategy.*;
import com.narxoz.rpg.observer.*;

public class DungeonBoss implements GameObserver {
    private String name;
    private int hp, maxHp, attackPower, defense, currentPhase = 1;
    private CombatStrategy strategy;
    private GamePublisher publisher;

    public DungeonBoss(String name, int maxHp, int attackPower, int defense, GamePublisher publisher) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.attackPower = attackPower;
        this.defense = defense;
        this.strategy = new BalancedStrategy();
        this.publisher = publisher;
    }

    public void takeDamage(int amount) {
        this.hp -= amount;
        checkPhaseTransition();
    }

    private void checkPhaseTransition() {
        double hpPercent = (double) hp / maxHp;
        int newPhase = currentPhase;

        if (hpPercent <= 0.3) newPhase = 3;
        else if (hpPercent <= 0.6) newPhase = 2;

        if (newPhase != currentPhase) {
            currentPhase = newPhase;
            publisher.notifyObservers(new GameEvent(GameEventType.BOSS_PHASE_CHANGED, name, currentPhase));
        }
    }

    @Override
    public void onEvent(GameEvent event) {
        if (event.getType() == GameEventType.BOSS_PHASE_CHANGED && event.getSourceName().equals(name)) {
            switch ((int)event.getValue()) {
                case 2 -> this.strategy = new AggressiveStrategy();
                case 3 -> this.strategy = new BerserkStrategy();
            }
        }
    }

    public String getName() { return name; }
    public int getHp() { return hp; }
    public CombatStrategy getStrategy() { return strategy; }
    public int getAttackPower() { return attackPower; }
    public boolean isAlive() { return hp > 0; }
}