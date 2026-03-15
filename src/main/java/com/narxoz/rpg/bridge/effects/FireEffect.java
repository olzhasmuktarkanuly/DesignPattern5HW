package com.narxoz.rpg.bridge.effects;
import com.narxoz.rpg.bridge.EffectImplementor;

public class FireEffect implements EffectImplementor {
    @Override
    public void applyDamage(String skillName, int baseDamage) {
        System.out.println("  [Fire] " + skillName + " ignites enemies for " + (baseDamage + 10) + " fire damage!");
    }
}