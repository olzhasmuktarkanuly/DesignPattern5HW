package com.narxoz.rpg.quest;

import java.util.List;

public class ReverseQuestIterator implements QuestIterator {
    private List<Quest> quests;
    private int cursor;

    public ReverseQuestIterator(QuestLog log) {
        this.quests = log.snapshot();
        this.cursor = quests.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return cursor >= 0;
    }

    @Override
    public Quest next() {
        return quests.get(cursor--);
    }
}