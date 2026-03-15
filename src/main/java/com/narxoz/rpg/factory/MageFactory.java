package com.narxoz.rpg.factory;

import com.narxoz.rpg.character.Character;
import com.narxoz.rpg.character.Mage;

public class MageFactory extends CharacterFactory {
    @Override
    public Character createCharacter() {
        return new Mage();
    }
}