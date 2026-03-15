package com.narxoz.rpg.factory;

import com.narxoz.rpg.equipment.*;

public class MedievalFactory implements EquipmentFactory {
    public Weapon createWeapon() { return new IronSword(); }
    public Armor createArmor() { return new PlateArmor(); }
}