package com.narxoz.rpg;

import com.narxoz.rpg.adapter.CharacterCombatantAdapter;
import com.narxoz.rpg.adapter.EnemyCombatantAdapter;
import com.narxoz.rpg.arena.ArenaFighter;
import com.narxoz.rpg.arena.ArenaOpponent;
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
import com.narxoz.rpg.chain.DefenseHandler;
import com.narxoz.rpg.chain.DodgeHandler;
import com.narxoz.rpg.chain.HpHandler;
import com.narxoz.rpg.character.Character;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.FlameBreath;
import com.narxoz.rpg.command.ActionQueue;
import com.narxoz.rpg.command.AttackCommand;
import com.narxoz.rpg.command.DefendCommand;
import com.narxoz.rpg.command.HealCommand;
import com.narxoz.rpg.composite.PartyComposite;
import com.narxoz.rpg.composite.UnitLeaf;
import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.decorator.BasicAttack;
import com.narxoz.rpg.decorator.decorators.CriticalFocusDecorator;
import com.narxoz.rpg.decorator.decorators.FireRuneDecorator;
import com.narxoz.rpg.decorator.decorators.PoisonCoatingDecorator;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.equipment.Armor;
import com.narxoz.rpg.equipment.Weapon;
import com.narxoz.rpg.facade.DungeonFacade;
import com.narxoz.rpg.factory.*;
import com.narxoz.rpg.floor.BattleFloor;
import com.narxoz.rpg.floor.RestFloor;
import com.narxoz.rpg.floor.TowerFloor;
import com.narxoz.rpg.floor.TrapFloor;
import com.narxoz.rpg.prototype.EnemyRegistry;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.builder.*;
import com.narxoz.rpg.factory.*;
import com.narxoz.rpg.prototype.EnemyRegistry;
import com.narxoz.rpg.raid.RaidEngine;
import com.narxoz.rpg.state.BerserkState;
import com.narxoz.rpg.state.NeutralState;
import com.narxoz.rpg.tournament.TournamentEngine;
import com.narxoz.rpg.combatant.*;
import com.narxoz.rpg.observer.*;
import com.narxoz.rpg.observer.observers.*;
import com.narxoz.rpg.strategy.*;
import com.narxoz.rpg.engine.*;
import com.narxoz.rpg.tower.TowerRunResult;
import com.narxoz.rpg.tower.TowerRunner;

import java.util.*;

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

/*System.out.println("=== Bridge Pattern Demo ===");
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
*/

/*        AttackAction attack = new BasicAttack();

        attack = new FireRuneDecorator(attack);
        attack = new PoisonCoatingDecorator(attack);
        attack = new CriticalFocusDecorator(attack);

        System.out.println("Final Attack Description: " + attack.getDescription());
        System.out.println("Final Damage: " + attack.getDamage());
        DungeonFacade dungeon = new DungeonFacade();


        dungeon.runDungeon("Aragorn", attack);*/

/* ArenaFighter hero = new ArenaFighter("Gladiator", 100, 25, 0.1, 20, 5, 3);
        ArenaOpponent boss = new ArenaOpponent("Mountain Troll", 150, 35);

        System.out.println("--- DEMO 1: Command Queue & Undo ---");
        ActionQueue queue = new ActionQueue();
        queue.enqueue(new AttackCommand(boss, 30));
        queue.enqueue(new HealCommand(hero));
        queue.enqueue(new DefendCommand(hero));

        System.out.println("Initial queue: " + queue.getCommandDescriptions());
        queue.undoLast();
        System.out.println("Queue after undo: " + queue.getCommandDescriptions());
        queue.executeAll();
        System.out.println();

        System.out.println("--- DEMO 2: Defense Chain Manual Test ---");
        DefenseHandler chain = new DodgeHandler();
        DefenseHandler hp = new HpHandler();
        chain.setNext(hp);

        System.out.println("Hero HP before: " + hero.getHp());
        chain.handle(50, hero);
        System.out.println("Hero HP after: " + hero.getHp());
        System.out.println();

        System.out.println("--- DEMO 3: Full Tournament Simulation ---");
        hero.heal(100);
        TournamentEngine engine = new TournamentEngine();
        engine.runTournament(hero, boss); */

/* GamePublisher publisher = new GamePublisher();

                Hero warrior = new Hero("Warrior", 150, 20, 15);
                warrior.setStrategy(new BalancedStrategy());

                Hero mage = new Hero("Mage", 100, 45, 5);
                mage.setStrategy(new AggressiveStrategy());

                Hero paladin = new Hero("Paladin", 200, 15, 30);
                paladin.setStrategy(new DefensiveStrategy());

                List<Hero> party = new ArrayList<>();
                party.add(warrior);
                party.add(mage);
                party.add(paladin);

                System.out.println("[Demo] Mage feels the danger and switches to Defensive Strategy before entering...");
                mage.setStrategy(new DefensiveStrategy());

                DungeonBoss boss = new DungeonBoss("Malphas the Cursed", 800, 35, 20, publisher);

                publisher.subscribe(new BattleLogger());
                publisher.subscribe(new AchievementTracker());
                publisher.subscribe(new HeroStatusMonitor());
                publisher.subscribe(new LootDropper());

                publisher.subscribe(boss);

                DungeonEngine engine = new DungeonEngine(publisher);

                EncounterResult result = engine.startEncounter(party, boss);

                result.printSummary();*/


        Hero arthur = new Hero("Arthur (Knight)", 100, 30, 15);
        arthur.setState(new NeutralState());

        Hero guts = new Hero("Guts (Berserker)", 120, 25, 10);
        guts.setState(new BerserkState());

        List<Hero> party = Arrays.asList(arthur, guts);

        List<TowerFloor> floors = Arrays.asList(
                new BattleFloor(),
                new TrapFloor(),
                new RestFloor(),
                new BattleFloor()
        );

        TowerRunner runner = new TowerRunner();
        TowerRunResult result = runner.run(party, floors);

        System.out.println("Total Floors Cleared: " + result.getFloorsCleared() + " out of " + floors.size());
        System.out.println("Heroes Survived: " + result.getSurvivors());

        if (result.getFloorsCleared() == floors.size()) {
            System.out.println("Result: VICTORY!");
        } else {
            System.out.println("Result: DEFEAT...");
        }


            }
        }



