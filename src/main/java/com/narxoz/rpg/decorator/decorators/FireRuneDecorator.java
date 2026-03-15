package com.narxoz.rpg.decorator.decorators;

import com.narxoz.rpg.decorator.ActionDecorator;
import com.narxoz.rpg.decorator.AttackAction;

public class FireRuneDecorator extends ActionDecorator {
    public FireRuneDecorator(AttackAction action) { super(action); }

    @Override
    public String getDescription() { return super.getDescription() + " + Fire Rune"; }

    @Override
    public int getDamage() { return super.getDamage() + 10; }
}