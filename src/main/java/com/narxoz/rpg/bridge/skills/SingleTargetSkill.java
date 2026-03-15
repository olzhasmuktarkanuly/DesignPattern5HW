package com.narxoz.rpg.bridge.skills;

import com.narxoz.rpg.bridge.EffectImplementor;
import com.narxoz.rpg.bridge.Skill;

public class SingleTargetSkill extends Skill {
    public SingleTargetSkill(EffectImplementor effect) {
        super(effect);
    }

    @Override
    public void cast(String targetName, int power) {
        System.out.println("Casting Single Target Skill on " + targetName);
        effect.applyDamage("Heavy Strike", power);
    }
}