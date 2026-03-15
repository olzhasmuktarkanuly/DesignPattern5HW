package com.narxoz.rpg.bridge.effects;
import com.narxoz.rpg.bridge.EffectImplementor;

public class IceEffect implements EffectImplementor {
    @Override
    public void applyDamage(String skillName, int baseDamage) {
        System.out.println("  [Ice] " + skillName + " freezes enemies for " + baseDamage + " ice damage and slows them!");
    }
}