package com.narxoz.rpg.observer.observers;
import com.narxoz.rpg.observer.*;

public class LootDropper implements GameObserver {
    @Override
    public void onEvent(GameEvent event) {
        if (event.getType() == GameEventType.BOSS_PHASE_CHANGED) {
            System.out.println("🎁 Rare loot dropped during phase " + event.getValue() + "!");
        } else if (event.getType() == GameEventType.BOSS_DEFEATED) {
            System.out.println("💰 EPIC CHEST: Found 1000 Gold and a Magic Sword!");
        }
    }
}