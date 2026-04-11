package com.narxoz.rpg.observer.observers;
import com.narxoz.rpg.observer.*;

public class AchievementTracker implements GameObserver {
    private int totalDamage = 0;

    @Override
    public void onEvent(GameEvent event) {
        if (event.getType() == GameEventType.ATTACK_LANDED) {
            totalDamage += event.getValue();
            if (totalDamage > 200) unlock("Big Hitter: Dealt over 200 damage!");
        } else if (event.getType() == GameEventType.HERO_DIED) {
            unlock("Sacrifice: A hero has fallen...");
        } else if (event.getType() == GameEventType.BOSS_DEFEATED) {
            unlock("Kingslayer: The boss is no more!");
        }
    }

    private void unlock(String name) {
        System.out.println("🏆 ACHIEVEMENT UNLOCKED: " + name);
    }
}