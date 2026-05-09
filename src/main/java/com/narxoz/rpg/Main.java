package com.narxoz.rpg;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.council.CouncilEngine;
import com.narxoz.rpg.council.CouncilRunResult;
import com.narxoz.rpg.guild.*;
import com.narxoz.rpg.quest.*;

public class Main {
    public static void main(String[] args) {
        Hero h1 = new Hero("Arthur", 10);
        Hero h2 = new Hero("Merlin", 12);

        QuestLog log = new QuestLog();
        log.addQuest(new Quest("Goblin Camp", "Clear the local goblins", QuestPriority.LOW, 50));
        log.addQuest(new Quest("Dragon's Lair", "Slay the ancient dragon", QuestPriority.URGENT, 5000));
        log.addQuest(new Quest("Lost Caravan", "Find missing merchants", QuestPriority.NORMAL, 200));
        log.addQuest(new Quest("Cursed Ruins", "Purge the undead", QuestPriority.HIGH, 1000));
        log.addQuest(new Quest("Bandit King", "Capture the bandit leader", QuestPriority.NORMAL, 300));

        GuildHall hall = new GuildHall();
        Captain captain = new Captain("Vanguard Leon", hall);
        Quartermaster qm = new Quartermaster("Stash Keeper", hall);
        Scout scout = new Scout("Eagle Eye", hall);
        Healer healer = new Healer("Sister Elara", hall);
        Loremaster loremaster = new Loremaster("Archivist Theron", hall);

        QuestIterator allIter = log.ordered();
        while (allIter.hasNext()) { System.out.println(allIter.next()); }

        QuestIterator revIter = log.reverse();
        while (revIter.hasNext()) { System.out.println(revIter.next()); }

        CouncilEngine engine = new CouncilEngine();
        CouncilRunResult result = engine.runCouncil(log, hall, captain, scout, loremaster);

        qm.requestSupplies("We need 50 healing potions for the upcoming raids.");
        healer.requestMedicalHelp("Setting up triage tents in the courtyard.");

        System.out.println("Success: " + result.isSuccess() + ", Quests Planned: " + result.getQuestsPlanned());
        }
}




