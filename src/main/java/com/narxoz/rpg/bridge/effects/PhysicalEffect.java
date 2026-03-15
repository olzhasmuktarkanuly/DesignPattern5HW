package com.narxoz.rpg.bridge.effects;
import com.narxoz.rpg.bridge.EffectImplementor;

public class PhysicalEffect implements EffectImplementor {
    @Override
    public void applyDamage(String skillName, int baseDamage) {
        System.out.println("  [Physical] " + skillName + " deals " + baseDamage + " crushing physical damage!");
    }
}