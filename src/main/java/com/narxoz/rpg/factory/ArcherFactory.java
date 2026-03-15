package com.narxoz.rpg.factory;

import com.narxoz.rpg.character.Character;
import com.narxoz.rpg.character.Archer;

public class ArcherFactory extends CharacterFactory {
    @Override
    public Character createCharacter() {
        return new Archer();
    }
}