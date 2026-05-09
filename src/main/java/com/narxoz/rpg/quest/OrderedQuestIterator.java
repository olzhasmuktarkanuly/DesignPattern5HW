package com.narxoz.rpg.quest;

import java.util.List;

public class OrderedQuestIterator implements QuestIterator {
    private List<Quest> quests;
    private int cursor = 0;

    public OrderedQuestIterator(QuestLog log) {
        this.quests = log.snapshot();
    }

    @Override
    public boolean hasNext() {
        return cursor < quests.size();
    }

    @Override
    public Quest next() {
        return quests.get(cursor++);
    }
}