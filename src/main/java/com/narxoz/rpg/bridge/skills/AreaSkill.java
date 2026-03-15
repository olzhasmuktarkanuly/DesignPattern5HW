package com.narxoz.rpg.bridge.skills;

import com.narxoz.rpg.bridge.EffectImplementor;
import com.narxoz.rpg.bridge.Skill;

public class AreaSkill extends Skill {
    public AreaSkill(EffectImplementor effect) {
        super(effect);
    }

    @Override
    public void cast(String targetName, int power) {
        System.out.println("Casting Area Skill on group: " + targetName);
        effect.applyDamage("Explosion", power / 2);
    }
}