package com.narxoz.rpg.factory;

import com.narxoz.rpg.equipment.Weapon;
import com.narxoz.rpg.equipment.Armor;

public interface EquipmentFactory {
    Weapon createWeapon();
    Armor createArmor();
}