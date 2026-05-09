package com.narxoz.rpg.council;

import com.narxoz.rpg.quest.Quest;
import com.narxoz.rpg.quest.QuestIterator;
import com.narxoz.rpg.quest.QuestLog;
import com.narxoz.rpg.quest.QuestPriority;
import com.narxoz.rpg.guild.GuildHall;
import com.narxoz.rpg.guild.Captain;
import com.narxoz.rpg.guild.Scout;
import com.narxoz.rpg.guild.Loremaster;

public class CouncilEngine {
    public CouncilRunResult runCouncil(QuestLog log, GuildHall hall, Captain cap, Scout scout, Loremaster lore) {
        int planned = 0;

        System.out.println("\n--- HIGH PRIORITY QUESTS ---");
        QuestIterator highIter = log.priorityAtLeast(QuestPriority.HIGH);
        while (highIter.hasNext()) {
            Quest q = highIter.next();
            System.out.println("Reviewing: " + q.getName());
            cap.issueOrder("Prepare units for " + q.getName());
            planned++;
        }

        System.out.println("\n--- LORE & RECONNAISSANCE ---");
        QuestIterator rewardIter = log.rewardSorted();
        if (rewardIter.hasNext()) {
            Quest topQuest = rewardIter.next();
            scout.reportIntel("Found tracks related to " + topQuest.getName());
            lore.shareLore("The area of " + topQuest.getName() + " contains ancient traps.");
        }

        return new CouncilRunResult(true, planned);
    }
}