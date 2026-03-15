package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class IceLootTable implements LootTable {
    @Override
    public List<String> getItems() {
        return new ArrayList<>(List.of("Ice Gem", "Frost Scale", "Ice Rune"));
    }
    @Override
    public int getGoldDrop() { return 120; }
    @Override
    public int getExperienceDrop() { return 450; }

    @Override
    public LootTable clone() {
        return new IceLootTable();
    }
}