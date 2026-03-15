package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;
import java.util.List;

public class Enemy {
    protected String name;
    protected int health;
    protected int damage;
    protected int defense;
    protected String element;
    protected List<Ability> abilities = new ArrayList<>();
    protected LootTable lootTable;
    protected String aiBehavior;

    public void setName(String name) { this.name = name; }
    public void setHealth(int health) { this.health = health; }
    public void setDamage(int damage) { this.damage = damage; }
    public void setDefense(int defense) { this.defense = defense; }
    public void setElement(String element) { this.element = element; }
    public void setAbilities(List<Ability> abilities) { this.abilities = new ArrayList<>(abilities); }
    public void setLootTable(LootTable lootTable) { this.lootTable = lootTable; }
    public void setAI(String ai) { this.aiBehavior = ai; }
    public String getName() {
        return name;
    }

    public Enemy clone() {
        Enemy copy = new Enemy();
        copy.name = this.name;
        copy.health = this.health;
        copy.damage = this.damage;
        copy.defense = this.defense;
        copy.element = this.element;
        copy.aiBehavior = this.aiBehavior;

        List<Ability> clonedAbilities = new ArrayList<>();
        for (Ability a : this.abilities) {
            clonedAbilities.add(a.clone());
        }
        copy.abilities = clonedAbilities;

        if (this.lootTable != null) {
            copy.lootTable = this.lootTable.clone();
        }

        return copy;
    }

    public void displayInfo() {
        System.out.println("-> " + name + " [" + element + "] | HP: " + health + " | AI: " + aiBehavior);
    }
}