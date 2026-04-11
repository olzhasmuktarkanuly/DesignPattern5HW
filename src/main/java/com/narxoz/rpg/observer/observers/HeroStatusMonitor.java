package com.narxoz.rpg.observer.observers;
import com.narxoz.rpg.observer.*;

public class HeroStatusMonitor implements GameObserver {
    @Override
    public void onEvent(GameEvent event) {
        if (event.getType() == GameEventType.HERO_LOW_HP || event.getType() == GameEventType.HERO_DIED) {
            System.out.println("⚠️  STATUS ALERT: " + event.getSourceName() + " is in critical condition! (HP: " + event.getValue() + ")");
        }
    }
}