package com.narxoz.rpg.bridge;

public abstract class Skill {
    protected EffectImplementor effect; // Мост к реализации

    protected Skill(EffectImplementor effect) {
        this.effect = effect;
    }

    public abstract void cast(String targetName, int power);
}