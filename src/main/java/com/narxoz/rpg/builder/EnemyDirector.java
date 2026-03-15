package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.EnemyComponentFactory;

public class EnemyDirector {
    public Enemy createBoss(EnemyBuilder builder, EnemyComponentFactory factory, String name) {
        return builder.setName(name)
                .setHealth(5000)
                .setDamage(100)
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAI(factory.createAI())
                .build();
    }
}