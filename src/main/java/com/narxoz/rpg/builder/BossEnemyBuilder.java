package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.List;

public class BossEnemyBuilder implements EnemyBuilder {
    private Enemy enemy = new Enemy();

    @Override
    public EnemyBuilder setName(String name) {
        enemy.setName(name);
        return this;
    }

    @Override
    public EnemyBuilder setHealth(int health) {
        enemy.setHealth(health);
        return this;
    }

    @Override
    public EnemyBuilder setDamage(int damage) {
        enemy.setDamage(damage);
        return this;
    }

    @Override
    public EnemyBuilder setDefense(int defense) {
        enemy.setDefense(defense);
        return this;
    }

    @Override
    public EnemyBuilder setElement(String element) {
        enemy.setElement(element);
        return this;
    }

    @Override
    public EnemyBuilder setAbilities(List<Ability> abilities) {
        enemy.setAbilities(abilities);
        return this;
    }

    @Override
    public EnemyBuilder setLootTable(LootTable loot) {
        enemy.setLootTable(loot);
        return this;
    }

    @Override
    public EnemyBuilder setAI(String aiBehavior) {
        enemy.setAI(aiBehavior);
        return this;
    }

    @Override
    public Enemy build() {
        return enemy;
    }
}