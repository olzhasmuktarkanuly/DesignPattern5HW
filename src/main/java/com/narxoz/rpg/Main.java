package com.narxoz.rpg;

import com.narxoz.rpg.adapter.CharacterCombatantAdapter;
import com.narxoz.rpg.adapter.EnemyCombatantAdapter;
import com.narxoz.rpg.battle.BattleEngine;
import com.narxoz.rpg.battle.Combatant;
import com.narxoz.rpg.bridge.Skill;
import com.narxoz.rpg.bridge.effects.FireEffect;
import com.narxoz.rpg.bridge.effects.IceEffect;
import com.narxoz.rpg.bridge.skills.AreaSkill;
import com.narxoz.rpg.bridge.skills.SingleTargetSkill;
import com.narxoz.rpg.builder.BossEnemyBuilder;
import com.narxoz.rpg.builder.EnemyBuilder;
import com.narxoz.rpg.builder.EnemyDirector;
import com.narxoz.rpg.character.Character;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.FlameBreath;
import com.narxoz.rpg.composite.PartyComposite;
import com.narxoz.rpg.composite.UnitLeaf;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.equipment.Armor;
import com.narxoz.rpg.equipment.Weapon;
import com.narxoz.rpg.factory.*;
import com.narxoz.rpg.prototype.EnemyRegistry;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.builder.*;
import com.narxoz.rpg.factory.*;
import com.narxoz.rpg.prototype.EnemyRegistry;
import com.narxoz.rpg.raid.RaidEngine;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
/*        System.out.println("=== RPG Character & Equipment System ===\n");


        System.out.println("--- Creating Warrior ---");
        CharacterFactory warriorFactory = new WarriorFactory();
        Character warrior = warriorFactory.createCharacter();
        warrior.getStats();
        warrior.useSpecialAbility();

        EquipmentFactory medievalFactory = new MedievalFactory();
        equipCharacter(medievalFactory);

        System.out.println("\n----------------------------------------\n");


        System.out.println("--- Creating Mage ---");
        CharacterFactory mageFactory = new MageFactory();
        Character mage = mageFactory.createCharacter();
        mage.getStats();
        mage.useSpecialAbility();

        EquipmentFactory magicFactory = new MagicFactory();
        equipCharacter(magicFactory);

        System.out.println("\n----------------------------------------\n");

        System.out.println("--- Creating Archer ---");
        CharacterFactory archerFactory = new ArcherFactory();
        Character archer = archerFactory.createCharacter();
        archer.getStats();
        archer.useSpecialAbility();

        EquipmentFactory rangerFactory = new RangerFactory();
        equipCharacter(rangerFactory);
    }


    private static void equipCharacter(EquipmentFactory factory) {
        Weapon weapon = factory.createWeapon();
        Armor armor = factory.createArmor();

        System.out.println("Equipping items:");
        weapon.getWeaponInfo();
        armor.getArmorInfo();
    }*/

/*        EnemyComponentFactory fireFactory = new FireComponentFactory();
        EnemyComponentFactory iceFactory = new IceComponentFactory();

        EnemyDirector director = new EnemyDirector();
        EnemyBuilder bossBuilder = new BossEnemyBuilder();

        Enemy baseFireDragon = director.createBoss(bossBuilder, fireFactory, "Ancient Fire Dragon");
        Enemy baseIceDragon = director.createBoss(bossBuilder, iceFactory, "Ancient Ice Dragon");



        EnemyRegistry registry = new EnemyRegistry();
        registry.registerTemplate("FIRE_DRAGON_BOSS", baseFireDragon);
        registry.registerTemplate("ICE_DRAGON_BOSS", baseIceDragon);


        Enemy eliteFireDragon = registry.createFromTemplate("FIRE_DRAGON_BOSS");
        if (eliteFireDragon != null) {
            eliteFireDragon.setName("Elite " + eliteFireDragon.getName());
            eliteFireDragon.setHealth(20000);
        }

        Ability extraSkill = new FlameBreath();

        baseFireDragon.displayInfo();
        eliteFireDragon.displayInfo();*/

/* BattleEngine engine = BattleEngine.getInstance();
        System.out.println("Battle Engine Initialized. Seed: 12345\n");


        CharacterFactory warriorFactory = new WarriorFactory();
        Character warrior = warriorFactory.createCharacter();

        CharacterFactory mageFactory = new MageFactory();
        Character mage = mageFactory.createCharacter();

        Combatant hero1 = new CharacterCombatantAdapter(warrior);
        Combatant hero2 = new CharacterCombatantAdapter(mage);


        EnemyComponentFactory fireFactory = new FireComponentFactory();
        EnemyBuilder builder = new BossEnemyBuilder();
        EnemyDirector director = new EnemyDirector();

        Enemy fireDragon = director.createBoss(builder, fireFactory, "Ancient Fire Dragon");

        Combatant enemyBoss = new EnemyCombatantAdapter(fireDragon);


        List<Combatant> heroesTeam = new ArrayList<>(List.of(hero1, hero2));
        List<Combatant> enemiesTeam = new ArrayList<>(List.of(enemyBoss));

        engine.runEncounter(heroesTeam, enemiesTeam);

        BattleEngine anotherEngine = BattleEngine.getInstance();
        System.out.println("\nSingleton Check: " + (engine == anotherEngine));*/

        System.out.println("=== Bridge Pattern Demo ===");
        Skill fireRain = new AreaSkill(new FireEffect());
        Skill iceBolt = new SingleTargetSkill(new IceEffect());

        fireRain.cast("Goblin Horde", 100);
        iceBolt.cast("Dragon Boss", 50);
        System.out.println();


        PartyComposite eliteSquad = new PartyComposite("Elite Squad");
        eliteSquad.addMember(new UnitLeaf("Captain America", 150, 30));
        eliteSquad.addMember(new UnitLeaf("Iron Man", 120, 40));

        PartyComposite mainRaid = new PartyComposite("Alpha Raid Group");
        mainRaid.addMember(eliteSquad);
        mainRaid.addMember(new UnitLeaf("Healer", 80, 5));

        PartyComposite enemyArmy = new PartyComposite("Undead Legion");
        enemyArmy.addMember(new UnitLeaf("Zombie 1", 40, 10));
        enemyArmy.addMember(new UnitLeaf("Zombie 2", 40, 10));
        enemyArmy.addMember(new UnitLeaf("Lich King", 300, 50));

        System.out.println("Raid Structure:");
        mainRaid.printTree("");
        enemyArmy.printTree("");
        System.out.println();

        RaidEngine.getInstance().runRaid(mainRaid, enemyArmy);


            }
        }

