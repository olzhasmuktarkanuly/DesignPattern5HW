package com.narxoz.rpg.loot;

import java.util.List;
import java.util.ArrayList;

public class FireLootTable implements LootTable {
    @Override
    public List<String> getItems() {
        return new ArrayList<>(List.of("Fire Gem", "Dragon Scale", "Flame Rune"));
    }
    @Override
    public int getGoldDrop() { return 100; }
    @Override
    public int getExperienceDrop() { return 500; }

    @Override
    public LootTable clone() {
        return new FireLootTable();
    }
}