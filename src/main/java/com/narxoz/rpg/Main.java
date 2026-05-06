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
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.memento.Caretaker;
import com.narxoz.rpg.artifact.*;
import com.narxoz.rpg.vault.ChronomancerEngine;
import com.narxoz.rpg.vault.VaultRunResult;

public class Main {
    public static void main(String[] args) {

        Hero knight = new Hero("Knight Arthur", 150, 30, 20);
        Hero mage = new Hero("Mage Merlin", 80, 10, 5);

        Inventory vaultLoot = new Inventory();
        vaultLoot.addArtifact(new Weapon("Excalibur", 500, 50));
        vaultLoot.addArtifact(new Potion("Elixir of Life", 50, 100));
        vaultLoot.addArtifact(new Scroll("Scroll of Time", 200, "Time Warp"));
        vaultLoot.addArtifact(new Ring("Cursed Ring of Greed", 300, "Gold Drain"));
        vaultLoot.addArtifact(new Armor("Dragon Scale", 400, 60));

        Caretaker caretaker = new Caretaker();
        ChronomancerEngine engine = new ChronomancerEngine();

        VaultRunResult run1 = engine.runVault(knight, vaultLoot, caretaker);
        VaultRunResult run2 = engine.runVault(mage, vaultLoot, caretaker);

        System.out.println(knight.getName() + " -> Success: " + run1.isSuccessfulRun() + " | Rewinds: " + run1.getRewindsUsed());
        System.out.println(mage.getName() + " -> Success: " + run2.isSuccessfulRun() + " | Rewinds: " + run2.getRewindsUsed());
    }
}




