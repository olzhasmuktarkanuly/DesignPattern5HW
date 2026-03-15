package com.narxoz.rpg.decorator.decorators;

import com.narxoz.rpg.decorator.ActionDecorator;
import com.narxoz.rpg.decorator.AttackAction;

public class CriticalFocusDecorator extends ActionDecorator {
    public CriticalFocusDecorator(AttackAction action) { super(action); }

    @Override
    public String getDescription() { return super.getDescription() + " (CRITICAL FOCUS)"; }

    @Override
    public int getDamage() { return super.getDamage() * 2; }
}