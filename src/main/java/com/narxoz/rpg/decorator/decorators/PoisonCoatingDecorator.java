package com.narxoz.rpg.decorator.decorators;

import com.narxoz.rpg.decorator.ActionDecorator;
import com.narxoz.rpg.decorator.AttackAction;

public class PoisonCoatingDecorator extends ActionDecorator {
    public PoisonCoatingDecorator(AttackAction action) { super(action); }

    @Override
    public String getDescription() { return super.getDescription() + " + Poison Coating"; }

    @Override
    public int getDamage() { return super.getDamage() + 5; }
}