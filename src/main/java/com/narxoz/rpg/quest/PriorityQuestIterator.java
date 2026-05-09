package com.narxoz.rpg.quest;

import java.util.ArrayList;
import java.util.List;

public class PriorityQuestIterator implements QuestIterator {
    private List<Quest> filtered = new ArrayList<>();
    private int cursor = 0;

    public PriorityQuestIterator(QuestLog log, QuestPriority minPriority) {
        for (Quest q : log.snapshot()) {
            if (q.getPriority().compareTo(minPriority) >= 0) {
                filtered.add(q);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return cursor < filtered.size();
    }

    @Override
    public Quest next() {
        return filtered.get(cursor++);
    }
}