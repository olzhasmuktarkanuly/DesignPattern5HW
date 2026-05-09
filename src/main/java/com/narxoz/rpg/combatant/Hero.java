package com.narxoz.rpg.combatant;

import com.narxoz.rpg.strategy.CombatStrategy;
import com.narxoz.rpg.strategy.BalancedStrategy;
import com.narxoz.rpg.state.HeroState;
import com.narxoz.rpg.state.NeutralState;

public class Hero {
    private String name;
    private int hp, maxHp, attackPower, defense;
    private int mana = 100;
    private int gold = 500;
    private CombatStrategy strategy;
    private HeroState state;

    public Hero(String name, int maxHp) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.attackPower = attackPower;
        this.defense = defense;
        this.strategy = new BalancedStrategy();
        this.state = new NeutralState();
    }

    public HeroMemento createMemento() {
        return new HeroMemento(this.hp, this.mana, this.gold);
    }

    public void restoreFromMemento(HeroMemento memento) {
        this.hp = memento.getHp();
        this.mana = memento.getMana();
        this.gold = memento.getGold();
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

    public void spendMana(int amount) { this.mana = Math.max(0, this.mana - amount); }
    public void loseGold(int amount) { this.gold = Math.max(0, this.gold - amount); }
    public void printStatus() { System.out.println(name + " -> HP: " + hp + ", Mana: " + mana + ", Gold: " + gold); }

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