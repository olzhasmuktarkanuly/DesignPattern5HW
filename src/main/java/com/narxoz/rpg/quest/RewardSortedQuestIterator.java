package com.narxoz.rpg.quest;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RewardSortedQuestIterator implements QuestIterator {
    private List<Quest> sorted;
    private int cursor = 0;

    public RewardSortedQuestIterator(QuestLog log) {
        this.sorted = log.snapshot();
        this.sorted.sort(Comparator.comparingInt(Quest::getReward).reversed());
    }

    @Override
    public boolean hasNext() {
        return cursor < sorted.size();
    }

    @Override
    public Quest next() {
        return sorted.get(cursor++);
    }
}