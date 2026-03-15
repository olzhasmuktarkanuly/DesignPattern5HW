package com.narxoz.rpg.decorator;

public abstract class ActionDecorator implements AttackAction {
    protected AttackAction decoratedAction;

    public ActionDecorator(AttackAction action) {
        this.decoratedAction = action;
    }

    @Override
    public String getDescription() {
        return decoratedAction.getDescription();
    }

    @Override
    public int getDamage() {
        return decoratedAction.getDamage();
    }
}