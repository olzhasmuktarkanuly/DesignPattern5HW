package com.narxoz.rpg.quest;

import java.util.ArrayList;
import java.util.List;

public class QuestLog {
    private List<Quest> quests = new ArrayList<>();

    public void addQuest(Quest quest) {
        quests.add(quest);
    }

    public List<Quest> snapshot() {
        return new ArrayList<>(quests);
    }

    public QuestIterator ordered() {
        return new OrderedQuestIterator(this);
    }

    public QuestIterator reverse() {
        return new ReverseQuestIterator(this);
    }

    public QuestIterator priorityAtLeast(QuestPriority p) {
        return new PriorityQuestIterator(this, p);
    }

    public QuestIterator rewardSorted() {
        return new RewardSortedQuestIterator(this);
    }
}