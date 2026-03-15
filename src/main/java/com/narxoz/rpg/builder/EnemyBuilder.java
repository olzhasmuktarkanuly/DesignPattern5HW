package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.List;

public interface EnemyBuilder {
    EnemyBuilder setName(String name);
    EnemyBuilder setHealth(int health);
    EnemyBuilder setDamage(int damage);
    EnemyBuilder setDefense(int defense);
    EnemyBuilder setElement(String element);
    EnemyBuilder setAbilities(List<Ability> abilities);
    EnemyBuilder setLootTable(LootTable loot);
    EnemyBuilder setAI(String aiBehavior);

    Enemy build();
}