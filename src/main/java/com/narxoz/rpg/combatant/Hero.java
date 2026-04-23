package com.narxoz.rpg.combatant;

import com.narxoz.rpg.strategy.CombatStrategy;
import com.narxoz.rpg.strategy.BalancedStrategy;
import com.narxoz.rpg.state.HeroState;
import com.narxoz.rpg.state.NeutralState;

public class Hero {
    private String name;
    private int hp, maxHp, attackPower, defense;
    private CombatStrategy strategy;
    private HeroState state;

    public Hero(String name, int maxHp, int attackPower, int defense) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.attackPower = attackPower;
        this.defense = defense;
        this.strategy = new BalancedStrategy();
        this.state = new NeutralState();
    }


    public int getAttackPower() {
        int base = strategy.calculateDamage(attackPower);
        return state.modifyOutgoingDamage(base);
    }

    public void takeDamage(int amount) {
        int reduced = strategy.calculateDefense(amount);
        int finalDamage = state.modifyIncomingDamage(reduced);
        this.hp = Math.max(0, this.hp - finalDamage);
    }


    public void startTurn() { state.onTurnStart(this); }
    public void endTurn() { state.onTurnEnd(this); }
    public boolean canAct() { return state.canAct(); }

    public void setState(HeroState state) { this.state = state; }
    public HeroState getState() { return state; }

    public String getName() { return name; }
    public int getHp() { return hp; }
    public void setHp(int hp) { this.hp = Math.min(maxHp, Math.max(0, hp)); }
    public int getMaxHp() { return maxHp; }
    public int getDefense() { return defense; }
    public void setStrategy(CombatStrategy strategy) { this.strategy = strategy; }
    public CombatStrategy getStrategy() { return strategy; }
    public void heal(int amount) { this.hp = Math.min(maxHp, this.hp + amount); }
    public boolean isAlive() { return hp > 0; }
}